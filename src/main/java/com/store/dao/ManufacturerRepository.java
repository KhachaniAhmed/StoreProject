package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
	Manufacturer findByName(String name);

}
