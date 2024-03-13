package com.qa.recap.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.recap.domain.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
