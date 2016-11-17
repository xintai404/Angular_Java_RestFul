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
import com.kaichen.OrderSystem.models.FirstName;
import com.kaichen.OrderSystem.models.LastName;
import com.kaichen.OrderSystem.models.OrderDetail;
import com.kaichen.OrderSystem.models.OrderSummary;
import com.kaichen.OrderSystem.services.OrderService;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

@Path("/")
public class OrderResources {
    
	private OrderService orderService = new OrderService();
    
	@GET
	@Path("firstnames")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FirstName> getAllFirstNames()
	{
		return orderService.getAllFirstNames();
	}
	
	@GET
	@Path("lastnames")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LastName> getAllLastNames()
	{
		return orderService.getAllLastNames();
	}
	
	
	@GET
	@Path("orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderSummary> getOrderSummery(@DefaultValue("") @QueryParam("first_name") String firstName,
			                                  @DefaultValue("") @QueryParam("last_name") String lastName)
	{
		return orderService.getOrderSummeryByName(firstName, lastName);
	}
	   
	@GET
	@Path("orders/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDetail> getOrderDetail(@PathParam("orderId") Integer orderNumber){
		return orderService.getOrderDetailByNumber(orderNumber);
	}
}
