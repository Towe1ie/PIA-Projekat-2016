/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.*;
import util.DB;

@ManagedBean
@RequestScoped
public class RegisterNewWork
{

    private String title;
    private String[] keywords;
    private String error;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public String getError()
    {
	return error;
    }

    public void setError(String error)
    {
	this.error = error;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public String[] getKeywords()
    {
	return keywords;
    }

    public void setKeywords(String[] keywords)
    {
	this.keywords = keywords;
    }

    // </editor-fold>
    public ArrayList<String> completeKeyword(String keyword)
    {
	ArrayList<String> keywords = new ArrayList();

	Connection conn = DB.getInstance().getConnection();

	if (conn == null)
	{
	    error = "Database connection problem";
	    return null;
	}

	String query = "select keyword from keyword where keyword like \"%" + keyword + "%\"";
	try
	{
	    Statement stmt = conn.createStatement();
	    ResultSet res = stmt.executeQuery(query);

	    while (res.next())
	    {
		keywords.add(res.getString("keyword"));
	    }
	}
	catch (SQLException ex)
	{
	    error = ex.getMessage();
	    System.err.println(ex.getMessage());
	}

	DB.getInstance().putConnection(conn);

	return keywords;
    }

    public ArrayList<String> fields(String field_query)
    {
	ArrayList<String> fields = new ArrayList();

	Connection conn = DB.getInstance().getConnection();

	if (conn == null)
	{
	    error = "Database connection problem";
	    return null;
	}

	String query = "select name from field where name like \"%" + field_query + "%\"";
	try
	{
	    Statement stmt = conn.createStatement();
	    ResultSet res = stmt.executeQuery(query);

	    while (res.next())
	    {
		fields.add(res.getString("name"));
	    }
	}
	catch (SQLException ex)
	{
	    error = ex.getMessage();
	    System.err.println(ex.getMessage());
	}

	DB.getInstance().putConnection(conn);

	return fields;
    }
}
