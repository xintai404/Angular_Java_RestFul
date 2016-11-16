package com.kaichen.OrderSystem.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost/classicmodels";
	public static final String USER = "root";
	public static final String PASSWORD = "111110";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	  
	private ConnectionFactory(){
		try{
			Class.forName(DRIVER_CLASS);
		}catch(ClassNotFoundException e){
			e.printStackTrace();   
		}
	}
	private static Connection createConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(SQLException e){
			System.out.println(e.getMessage());  
		}
		return connection;
	}  
	public static Connection getConnection(){
		return instance.createConnection();
	}
}
   