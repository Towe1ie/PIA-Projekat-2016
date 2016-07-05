/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB
{

    private static final int NUM = 5;
    private static final String USERNAME = "Nemanja";
    private static final String PASSWORD = "Olovcica1";
    private static final String DATABASE = "pia";

    private static DB instance = null;
    
    private int head = NUM, tail = 0;
    private Connection[] connections = new Connection[NUM];

    private DB()
    {
	try
	{
	    Class.forName("com.mysql.jdbc.Driver");

	    for (int i = 0; i < NUM; ++i)
	    {
		connections[i] = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/" + DATABASE,
			USERNAME,
			PASSWORD);
	    }
	}
	catch (Exception ex)
	{
	    System.out.println(ex.getMessage());
	}
    }
    
    public static DB getInstance()
    {
	if (instance == null)
	{
	    instance = new DB();
	}
	
	return instance;
    }
    
    public Connection getConnection()
    {
	if (tail != head)
	{
	    Connection ret = connections[tail];
	    tail = (tail + 1) % NUM;
	    
	    return ret;
	}
	
	return null;
    }
    
    public void putConnection(Connection conn)
    {
	int next = (head + 1) % NUM;
	
	if (next != tail)
	{
	    connections[next] = conn;
	    head = next;
	}
    }
}
