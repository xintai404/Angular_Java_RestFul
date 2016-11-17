package com.kaichen.OrderSystem.services;

import java.util.List;

import com.kaichen.OrderSystem.dao.OrderDAO;
import com.kaichen.OrderSystem.models.FirstName;
import com.kaichen.OrderSystem.models.LastName;
import com.kaichen.OrderSystem.models.OrderDetail;
import com.kaichen.OrderSystem.models.OrderSummary;

public class OrderService {
	
	public List<OrderSummary> getOrderSummeryByName(String firstName, String lastName){
		List<OrderSummary> list=null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getOrderSummary(firstName, lastName);
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
	
	public List<OrderDetail> getOrderDetailByNumber(int orderNumber){
		List<OrderDetail> list=null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getOrderDetail(orderNumber);
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
	
	public List<FirstName> getAllFirstNames(){
		List<FirstName> list=null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getFirstNameList();
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
	
	public List<LastName> getAllLastNames(){
		List<LastName> list=null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getLastNameList();
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
}
