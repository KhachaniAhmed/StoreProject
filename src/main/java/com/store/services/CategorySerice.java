package com.store.services;

import java.util.List;

import com.store.entities.Category;

public interface CategorySerice {
	List<Category> getAll();
	Category getByCategoryName(String name);
	Category save(Category category);
}
