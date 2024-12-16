package com.gtinapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gtinapp.model.Gtin;

public interface GtinRepository extends JpaRepository<Gtin, Long> {

	Optional<Gtin> findById(Integer gtinId);

}