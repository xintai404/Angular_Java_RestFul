package com.kaichen.OrderSystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kaichen.OrderSystem.db.ConnectionFactory;
import com.kaichen.OrderSystem.models.OrderDetail;
import com.kaichen.OrderSystem.models.OrderSummary;

public class OrderDAO {
	private Connection connection;
	private Statement statement;
	
	public OrderDAO(){}
	
	public List<OrderSummary> getOrderSummary(String firstName, String lastName) throws SQLException {
		ResultSet rs = null;
		List<OrderSummary>list = new ArrayList<OrderSummary>();
		
		String query = "select orderNumber, contactFirstName, contactLastName, DATE_FORMAT(orderDate, '%m/%d/%Y') orderDate, status, DATE_FORMAT(shippedDate, '%m/%d/%Y') shippedDate"
					  +" from customers, orders"
					  +" where customers.customerNumber = orders.customerNumber";
		if(firstName!=null && !firstName.isEmpty()){
			query += " and contactFirstName= '"+firstName+"'";
		}
		if(lastName !=null && !lastName.isEmpty()){
			query += " and contactLastName ='"+lastName+"'";
		}    
		try{
			connection = ConnectionFactory.getConnection();
			statement  = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				String contactFirstName = rs.getString("contactFirstName");
				String contactLastName  = rs.getString("contactLastName");
				int orderNumber = rs.getInt("orderNumber");
				String orderDate = rs.getString("orderDate");
				String status = rs.getString("status");
				String shippedDate = rs.getString("shippedDate");
				
				//System.out.printf("%d %s %s %s %s %s\n",orderNumber, contactFirstName, contactLastName, status, orderDate, shippedDate);
				list.add(new OrderSummary(contactFirstName, contactLastName, orderNumber, orderDate, status, shippedDate));
			}
		}finally{
			close(connection,statement, rs);
		}
		
		return list;
	}
	
	public List<OrderDetail> getOrderDetail(int orderNumber) throws SQLException {
		ResultSet rs = null;
		List<OrderDetail>list = new ArrayList<OrderDetail>();
		
		String query = "select orderNumber, orderdetails.productCode, productName, productDescription, quantityOrdered, priceEach" 
				      +" from orderdetails, products"
				      +" where orderdetails.productCode = products.productCode"
				      +" and orderNumber = "+ String.valueOf(orderNumber);
  
		try{
			connection = ConnectionFactory.getConnection();
			statement  = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				String productCode = rs.getString("productCode");
				String productName  = rs.getString("productName");
				String productDescription = rs.getString("productDescription");
				int quantity  = rs.getInt("quantityOrdered");
				String price = rs.getString("priceEach");
				
				//System.out.printf("%d %s %s %s %d %s\n",orderNumber, productCode, productName, productDescription, quantity, price);
				list.add(new OrderDetail(orderNumber, productCode, productName, productDescription, quantity, price));
			}
		}finally{
			close(connection,statement, rs);
		}
		
		return list;
	}
	private void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
