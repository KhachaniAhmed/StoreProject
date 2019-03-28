package com.store.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.dao.ProductRepository;
import com.store.entities.Category;
import com.store.entities.Manufacturer;
import com.store.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CategorySerice categorySerice; 
	@Autowired
	private ManufacturerService manufacturerService; 

	@Override
	public Product save(Product product) {
		Category category=categorySerice.getByCategoryName(product.getCategory().getCategoryName());
		System.err.println("**************"+category);
		product.setCategory(category);
		Manufacturer manufacturer=manufacturerService.getManufacturerByName(product.getManufacturer().getName());
		System.err.println("**************"+manufacturer);
		product.setManufacturer(manufacturer);
		System.err.println("**************"+product.toString());
		return productRepository.save(product);
	}

	@Override
	public Product edit(Product product) {
		// TODO Auto-generated method stub
		Category category=categorySerice.getByCategoryName(product.getCategory().getCategoryName());
		System.err.println("**************"+category);
		product.setCategory(category);
		Manufacturer manufacturer=manufacturerService.getManufacturerByName(product.getManufacturer().getName());
		System.err.println("**************"+manufacturer);
		product.setManufacturer(manufacturer);
		System.err.println("**************"+product.toString());
		return productRepository.save(product);
	}

	@Override
	public void deleteByID(Integer id) {
	   productRepository.deleteById(id);
	}

	@Override
	public Product getByID(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

	@Override
	public Page<Product> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findAll(pageable);
	}

}
