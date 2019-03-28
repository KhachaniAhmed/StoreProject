package com.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.ManufacturerRepository;
import com.store.entities.Manufacturer;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> getAll() {
		// TODO Auto-generated method stub
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerByName(String name) {
		// TODO Auto-generated method stub
		return manufacturerRepository.findByName(name);
	}

}
