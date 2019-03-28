package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String name);

}
