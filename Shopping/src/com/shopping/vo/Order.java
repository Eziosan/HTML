package com.shopping.vo;

public class Order {
	private int order_no;
	private String user_id;
	private String order_date;
	private int product_id;
	private String product_name;
	private int order_cnt;
	private int price;
	
	public Order() {}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getUser_id() {
		return user_id;
	}
	

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

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

	public int getOrder_cnt() {
		return order_cnt;
	}

	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return "�ֹ���ȣ : " + order_no + " ���̵� : " + user_id + " �ֹ��� : " + order_date
				+ " ��ǰ��ȣ : " + product_id + " ��ǰ�� : " + product_name 
				+ " ���� : " + order_cnt + " ���� : " + price; 
	}
}
