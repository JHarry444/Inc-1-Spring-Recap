package com.qa.recap.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.qa.recap.domain.Seller;
import com.qa.recap.service.SellerService;

@RestController
@RequestMapping("/seller")
@CrossOrigin
public class SellerController {

	private SellerService service;

	public SellerController(SellerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Seller> create(@RequestBody Seller newSeller) {
		return new ResponseEntity<Seller>(this.service.create(newSeller), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public Seller read(@PathVariable Integer id) {
		return this.service.read(id);
	}

	@GetMapping("/get")
	public List<Seller> read() {
		return this.service.read();
	}

	@PatchMapping("/update/{id}")
	public Seller update(@PathVariable Integer id, @RequestBody Seller newSeller) {
		return this.service.update(id, newSeller);
	}

	@DeleteMapping("/delete/{id}")
	public Seller delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}

}
