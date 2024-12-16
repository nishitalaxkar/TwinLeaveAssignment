package com.gtinapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gtinapp.model.Batch;
import com.gtinapp.model.Gtin;

public interface BatchRepository extends JpaRepository<Batch, Long> {

	@Query("SELECT b.gtin FROM Batch b WHERE b.availableQuantity > 0")
	List<Gtin> findGtinsWithPositiveQuantity();

	@Query("SELECT b FROM Batch b WHERE b.availableQuantity <= 0 " + "ORDER BY b.inwardedOn DESC")
	List<Batch> findLatestBatchesWithZeroOrNegativeQuantity();

}
