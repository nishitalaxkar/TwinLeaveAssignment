package com.gtinapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gtinapp.model.Batch;
import com.gtinapp.model.Gtin;
import com.gtinapp.model.Product;
import com.gtinapp.repository.BatchRepository;
import com.gtinapp.repository.GtinRepository;
import com.gtinapp.repository.ProductRepository;
import com.gtinapp.requestdto.BatchRequestDTO;
import com.gtinapp.requestdto.GtinRequestDTO;

@Component
public class GtinService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private GtinRepository gtinRepository;

	@Autowired
	private BatchRepository batchRepository;

	public Product saveProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;

	}

	public Gtin saveGtin(GtinRequestDTO gtinRequest) {
		// Save GTIN
		Product product = productRepository.findById(gtinRequest.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		Gtin gtin = new Gtin();
		gtin.setGtin(gtinRequest.getGtin());
		gtin.setProduct(product);

		Gtin gtinSaved = gtinRepository.save(gtin);
		return gtinSaved;

	}

	public Batch saveBatch(BatchRequestDTO batchRequest) {
		Gtin gtin = gtinRepository.findById(batchRequest.getGtinId())
				.orElseThrow(() -> new RuntimeException("GTIN not found"));

		Batch batch = new Batch();
		batch.setMrp(batchRequest.getMrp());
		batch.setSp(batchRequest.getSp());
		batch.setPurchasePrice(batchRequest.getPurchasePrice());
		batch.setAvailableQuantity(batchRequest.getAvailableQuantity());
		batch.setInwardedOn(batchRequest.getInwardedOn());
		batch.setGtin(gtin);

		Batch savedBatch = batchRepository.save(batch);
		return savedBatch;
	}

	public List<Gtin> fetchGtinsWithPositiveQuantity() {

		return batchRepository.findGtinsWithPositiveQuantity();
	}

	public List<Batch> fetchLatestGtinsWithNegativeZeroQuantity() {

		return batchRepository.findLatestBatchesWithZeroOrNegativeQuantity();
	}

}
