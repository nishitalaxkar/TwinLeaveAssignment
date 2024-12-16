package com.gtinapp.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Gtin")
public class Gtin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String gtin;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@OneToMany(mappedBy = "gtin", cascade = CascadeType.ALL)
	private List<Batch> batches;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
