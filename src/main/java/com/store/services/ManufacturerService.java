package com.store.services;

import java.util.List;

import com.store.entities.Manufacturer;

public interface ManufacturerService {
	List<Manufacturer> getAll();
	Manufacturer save(Manufacturer manufacturer);
	Manufacturer getManufacturerByName(String name);

}
