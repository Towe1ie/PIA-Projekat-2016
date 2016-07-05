/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import beans.unmanaged.Conference;
import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.*;
import util.DB;

@ManagedBean
@RequestScoped
public class UserHome
{

    private ArrayList<Conference> conferences;
    private String error;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public ArrayList<Conference> getConferences()
    {
	return conferences;
    }

    public void setConferences(ArrayList<Conference> conferences)
    {
	this.conferences = conferences;
    }

    public String getError()
    {
	return error;
    }

    public void setError(String error)
    {
	this.error = error;
    }

    // </editor-fold>
    public UserHome()
    {
	Connection conn = DB.getInstance().getConnection();

	if (conn == null)
	{
	    error = "Database connection problem";
	}

	conferences = new ArrayList();
	
	try
	{
	    String query = "select * from conference where NOW() >= subm_start and NOW() < subm_end";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    ResultSet res = stmt.executeQuery();
	    
	    while(res.next())
	    {
		Conference c = new Conference(
			res.getInt("id"),
			res.getString("name"),
			res.getString("location"),
			res.getDate("conf_date"),
			res.getDate("subm_start"),
			res.getDate("subm_end"),
			res.getInt("max_subm"));
		
		conferences.add(c);
	    }
	    
	}
	catch (SQLException ex)
	{
	    error = ex.getMessage();
	    System.err.println(ex.getMessage());
	}
	
	
    }
}
