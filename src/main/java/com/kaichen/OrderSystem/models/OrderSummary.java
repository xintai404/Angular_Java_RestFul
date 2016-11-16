package com.kaichen.OrderSystem.models;

public class OrderSummary {
	
	private int orderNumber;
	private String firstName;
	private String lastName;
	private String orderDate;
	private String shipDate;
	private String orderStatus;
	
	public OrderSummary(){}
	
	public OrderSummary(String firstName, String lastName, int orderNumber,
			                 String orderDate, String  orderStatus, 
			                 String shipDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderNumber= orderNumber;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
