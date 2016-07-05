/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import beans.unmanaged.User;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import util.DB;

@ManagedBean
@RequestScoped
public class SignIn
{
    private String username, pasword;
    private String error;
    
    @ManagedProperty(value="#{global}")
    private Global global;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public Global getGlobal()
    {
	return global;
    }

    public void setGlobal(Global global)
    {
	this.global = global;
    }

    public String getError()
    {
	return error;
    }

    public void setError(String error)
    {
	this.error = error;
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPasword()
    {
	return pasword;
    }

    public void setPasword(String pasword)
    {
	this.pasword = pasword;
    }
    
    // </editor-fold>
    
    public String signIn()
    {
	Connection conn = DB.getInstance().getConnection();
	
	error = null;
	
	if (conn == null)
	{
	    error = "Database connection error";
	    return null;
	}
	
	String query = "select * from user_accounts where username=?";
	
	try
	{
	    PreparedStatement stmt = conn.prepareCall(query);
	    stmt.setString(1, username);
	    
	    ResultSet res = stmt.executeQuery();
	    
	    if (!res.next())
	    {
		error = "Username does not exist";
		return null;
	    }
	    
	    if (!res.getString("password").equals(pasword))
	    {
		error = "Wrong password";
		return null;
	    }

	    global.setSignedIn(true);
	    
	    User u = new User(
		    res.getString("username"),
		    res.getString("first_name"),
		    res.getString("last_name"),
		    res.getString("phone"),
		    res.getString("email"),
		    res.getString("organization"),
		    res.getDate("date_of_birth"),
		    res.getBinaryStream("image"));
	    
	    global.setUser(u);
	    
	    return "userHome";
	}
	catch (SQLException ex)
	{
	    System.err.println(ex.getMessage());
	    error = ex.getMessage();
	}
	return null;
    }
    
    public String signOut()
    {
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	ec.invalidateSession();
	global.setSignedIn(false);
	global.setUser(null);
	return "index";
    }
}
