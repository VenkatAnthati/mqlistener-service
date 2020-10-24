package com.mqlistenerservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_dequeue")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String productName;
	@Id
	private Long productId;
	
	@Column(name="price")
	private double price;
	
	
	
	/**
	 * Default constructo
	 */
	public Product() {
	}
	
	
	/**
	 * @param productName
	 * @param productId
	 * @param price
	 */
	public Product(String productName, Long productId, double price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
	}
	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", price=" + price + "]";
	}



}
