package com.kaichen.OrderSystem.resources;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kaichen.OrderSystem.dao.OrderDAO;
import com.kaichen.OrderSystem.db.ConnectionFactory;
import com.kaichen.OrderSystem.models.OrderDetail;
import com.kaichen.OrderSystem.models.OrderSummary;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

@Path("/")
public class OrderResources {
     
	@GET
	@Path("orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderSummary> getOrderSummery(@DefaultValue("") @QueryParam("first_name") String first_name,
			                                  @DefaultValue("") @QueryParam("last_name") String last_name)
	{
		List<OrderSummary> list=null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getOrderSummary(first_name, last_name);
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
	   
	@GET
	@Path("orders/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDetail> getOrderDetail(@PathParam("orderId") Integer orderId){
		List<OrderDetail> list = null;
		try{
			OrderDAO dao = new OrderDAO();
			list = dao.getOrderDetail(orderId);
		}catch(Exception e){
			e.printStackTrace();
		}    
		return list;
	}
}
