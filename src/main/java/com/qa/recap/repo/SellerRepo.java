package com.qa.recap.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.recap.domain.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

}
