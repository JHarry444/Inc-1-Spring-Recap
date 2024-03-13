package com.qa.recap.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.recap.domain.Property;
import com.qa.recap.domain.Status;
import com.qa.recap.domain.Type;
import com.qa.recap.dto.PropertyDTO;
import com.qa.recap.service.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {

	private PropertyService service;

	public PropertyController(PropertyService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Property> create(@RequestBody Property newProperty) {
		return new ResponseEntity<Property>(this.service.create(newProperty), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public PropertyDTO read(@PathVariable Integer id) {
		return new PropertyDTO(this.service.read(id));
	}

	@GetMapping("/get")
	public List<PropertyDTO> read() {
		return this.service.read().stream().map(PropertyDTO::new).collect(Collectors.toList());
	}

	@GetMapping("/get/example")
	public List<Property> read(@RequestBody Property example) {
		return this.service.read(Example.of(example));
	}

	@GetMapping("/get/params")
	public List<Property> read(@RequestParam(name = "minBeds", required = false) Integer minBeds,
			@RequestParam(name = "maxBeds", required = false) Integer maxBeds,
			@RequestParam(name = "minBaths", required = false) Integer minBaths,
			@RequestParam(name = "maxBaths", required = false) Integer maxBaths,
			@RequestParam(name = "type", required = false) Type type,
			@RequestParam(name = "status", required = false) Status status,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "postcode", required = false) String postcode,
			@RequestParam(name = "minPrice", required = false) Integer minPrice,
			@RequestParam(name = "maxPrice", required = false) Integer maxPrice,
			@RequestParam(name = "garden", required = false) Boolean garden) {
		return this.service.read(minBeds, maxBeds, minBaths, maxBaths, type, status, address, postcode, minPrice,
				maxPrice, garden);
	}

	@PatchMapping("/update/{id}")
	public Property update(@PathVariable Integer id, @RequestBody Property newProperty) {
		return this.service.update(id, newProperty);
	}

	@DeleteMapping("/delete/{id}")
	public Property delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}

}
