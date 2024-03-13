package com.qa.recap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.qa.recap.domain.Property;
import com.qa.recap.domain.Status;
import com.qa.recap.domain.Type;
import com.qa.recap.exceptions.DeleteFailedException;
import com.qa.recap.exceptions.PropertyNotFoundException;
import com.qa.recap.repo.PropertyRepo;

@Service
public class PropertyService {

	private PropertyRepo repo;

	public PropertyService(PropertyRepo repo) {
		super();
		this.repo = repo;
	}

	public Property create(Property newProperty) {
		return this.repo.save(newProperty);
	}

	public Property read(Integer id) {
		return this.repo.findById(id).orElseThrow(PropertyNotFoundException::new);
	}

	public List<Property> read() {
		return this.repo.findAll();
	}

	public Property update(Integer id, Property newProperty) {
		Property toUpdate = this.read(id);

		if (newProperty.getGarden() != null) {
			toUpdate.setGarden(newProperty.getGarden());
		}

		if (newProperty.getAddress() != null) {
			toUpdate.setAddress(newProperty.getAddress());
		}

		if (newProperty.getBaths() != null) {
			toUpdate.setBaths(newProperty.getBaths());
		}

		if (newProperty.getBeds() != null) {
			toUpdate.setBeds(newProperty.getBeds());
		}

		if (newProperty.getPostcode() != null) {
			toUpdate.setPostcode(newProperty.getPostcode());
		}
		if (newProperty.getPrice() != null) {
			toUpdate.setPrice(newProperty.getPrice());
		}
		if (newProperty.getStatus() != null) {
			toUpdate.setStatus(newProperty.getStatus());
		}
		if (newProperty.getType() != null) {
			toUpdate.setType(newProperty.getType());
		}

		return this.repo.save(toUpdate);
	}

	public Property delete(Integer id) {
		Property toDelete = this.read(id);

		this.repo.delete(toDelete);

		if (this.repo.existsById(id)) {
			throw new DeleteFailedException();
		}

		return toDelete;
	}

	public List<Property> read(Example<Property> example) {
		return this.repo.findAll(example);
	}

	public List<Property> read(Integer minBeds, Integer maxBeds, Integer minBaths, Integer maxBaths, Type type,
			Status status, String address, String postcode, Integer minPrice, Integer maxPrice, Boolean garden) {
		return this.read().parallelStream().filter(prop -> minBeds == null || prop.getBeds() >= minBeds)
				.filter(prop -> maxBeds == null || prop.getBeds() <= maxBeds)
				.filter(prop -> minBaths == null || prop.getBaths() >= minBaths)
				.filter(prop -> maxBaths == null || prop.getBaths() <= maxBaths)
				.filter(prop -> type == null || prop.getType() == type)
				.filter(prop -> status == null || prop.getStatus() == status)
				.filter(prop -> address == null || prop.getAddress().equals(address))
				.filter(prop -> postcode == null || prop.getPostcode().equals(postcode))
				.filter(prop -> minPrice == null || prop.getPrice() >= minPrice)
				.filter(prop -> maxPrice == null || prop.getPrice() <= maxPrice)
				.filter(prop -> garden == null || prop.getGarden() == garden)

				.collect(Collectors.toList());
	}

}
