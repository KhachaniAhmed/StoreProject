package com.store.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.entities.Product;

public interface ProductService {
	Product save(Product product);
	Product edit(Product product);
	Page<Product> getAll(Pageable pageable);
	void deleteByID(Integer id);
	Product getByID(Integer id);
	
	

}
