package com.gtinapp.requestdto;

import java.sql.Date;

public class BatchRequestDTO {
	private Integer mrp;
	private Integer sp;
	private Integer purchasePrice;
	private Integer availableQuantity;
	private Date inwardedOn;
	private Integer gtinId;

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

	public Integer getGtinId() {
		return gtinId;
	}

	public void setGtinId(Integer gtinId) {
		this.gtinId = gtinId;
	}
}
