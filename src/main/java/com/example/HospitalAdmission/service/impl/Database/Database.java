package com.example.HospitalAdmission.service.impl.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	//This is method
	//This method is used for initiating a Database Connection
public static Connection getConnection()
{   //Variable
	Connection con=null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/empmgm", "root", "root");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
}
public static void main(String[] args)
{
	Connection conn=getConnection();
	try
	{
		if(conn!=null)
		{
			System.out.println("Connection Successful");
		}
		else
		{
			System.out.println("Connection not successful");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
