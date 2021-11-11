package com.shopping.vo;

public class Product {
	private int product_id;
	private String product_name;
	private int price;
	private int stock;
	
	public Product() {}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return product_id + "\t" + product_name + "\t\t" + price + "¿ø\t" + stock + "°³";
	}
}
