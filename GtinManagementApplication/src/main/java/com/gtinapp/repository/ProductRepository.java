package com.gtinapp.repository;

import com.gtinapp.model.Product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findById(Integer productId);
}
