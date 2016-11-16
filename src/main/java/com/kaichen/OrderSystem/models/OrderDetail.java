package com.kaichen.OrderSystem.models;

public class OrderDetail {

	private int orderNumber;
	private String productCode;
	private String productName;
	private String productDescription;
	private int quantity;
	private String price;
	
	public OrderDetail(){}
	public OrderDetail(int orderNumber, String productCode, String productName, String productDescription,
						    int quantity, String price){
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
