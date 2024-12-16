package com.gtinapp.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id")
	private Integer batchId;

	private Integer mrp;
	private Integer sp;

	@Column(name = "purchase_price")
	private Integer purchasePrice;

	@Column(name = "available_quantity")
	private Integer availableQuantity;

	@Column(name = "inwarded_on")
	private Date inwardedOn;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Gtin gtin;

	// Getters and Setters
	public Integer getBatchId() {
		return batchId;
	}

	public Gtin getGtin() {
		return gtin;
	}

	public void setGtin(Gtin gtin) {
		this.gtin = gtin;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getMrp() {
		return mrp;
	}

	public void setMrp(Integer mrp) {
		this.mrp = mrp;
	}

	public Integer getSp() {
		return sp;
	}

	public void setSp(Integer sp) {
		this.sp = sp;
	}

	public Integer getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Date getInwardedOn() {
		return inwardedOn;
	}

	public void setInwardedOn(Date inwardedOn) {
		this.inwardedOn = inwardedOn;
	}
}
