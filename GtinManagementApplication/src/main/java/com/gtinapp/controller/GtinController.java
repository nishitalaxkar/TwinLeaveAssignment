package com.gtinapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gtinapp.model.Batch;
import com.gtinapp.model.Gtin;
import com.gtinapp.model.Product;
import com.gtinapp.repository.ProductRepository;
import com.gtinapp.requestdto.BatchRequestDTO;
import com.gtinapp.requestdto.GtinRequestDTO;
import com.gtinapp.service.GtinService;

@RestController
@RequestMapping("/gtin/api")
public class GtinController {

	@Autowired
	private GtinService gtinService;

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct = gtinService.saveProduct(product);
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}

	@PostMapping("/gtin")
	public ResponseEntity<Gtin> createProduct(@RequestBody GtinRequestDTO gtinReqDto) {
		Gtin response = gtinService.saveGtin(gtinReqDto);
		return new ResponseEntity<Gtin>(response, HttpStatus.CREATED);
	}

	@PostMapping("/batch")
	public ResponseEntity<Batch> createProduct(@RequestBody BatchRequestDTO batchRqDto) {
		Batch response = gtinService.saveBatch(batchRqDto);
		return new ResponseEntity<Batch>(response, HttpStatus.CREATED);
	}

	@GetMapping("/positivequantity")
	public List<Gtin> fetchGtinsWithPositiveQuantity() {
		return gtinService.fetchGtinsWithPositiveQuantity();
	}

	@GetMapping("/negativequantity")
	public Batch fetchGtinsWithNegQuantity() {
		List<Batch> batches = gtinService.fetchLatestGtinsWithNegativeZeroQuantity();
		return batches.isEmpty() ? null : batches.get(0);
	}

}
