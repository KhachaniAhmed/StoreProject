package com.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.dao.CategoryRepository;
import com.store.entities.Category;

@Service
@Transactional
public class CategorySericeImpl implements CategorySerice {
	@Autowired
    private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	@Override
	public Category getByCategoryName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryName(name);
	}
	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

}
