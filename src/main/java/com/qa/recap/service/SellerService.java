package com.qa.recap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.recap.domain.Seller;
import com.qa.recap.exceptions.DeleteFailedException;
import com.qa.recap.exceptions.SellerNotFoundException;
import com.qa.recap.repo.SellerRepo;

@Service
public class SellerService {

	private SellerRepo repo;

	public SellerService(SellerRepo repo) {
		super();
		this.repo = repo;
	}

	public Seller create(Seller newSeller) {
		return this.repo.save(newSeller);
	}

	public Seller read(Integer id) {
		return this.repo.findById(id).orElseThrow(SellerNotFoundException::new);
	}

	public List<Seller> read() {
		return this.repo.findAll();
	}

	public Seller update(Integer id, Seller newSeller) {
		Seller toUpdate = this.read(id);

		if (newSeller.getFirstName() != null) {
			toUpdate.setFirstName(newSeller.getFirstName());
		}

		if (newSeller.getLastName() != null) {
			toUpdate.setLastName(newSeller.getLastName());
		}

		return this.repo.save(toUpdate);
	}

	public Seller delete(Integer id) {
		Seller toDelete = this.read(id);

		this.repo.delete(toDelete);

		if (this.repo.existsById(id)) {
			throw new DeleteFailedException();
		}

		return toDelete;
	}

}
