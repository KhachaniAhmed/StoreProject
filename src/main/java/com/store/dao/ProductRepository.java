package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
