/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.faces.bean.*;
import javax.servlet.http.Part;


@ManagedBean
@SessionScoped
public class Registration
{

    private String username, password, firstName, lastName, phone, email, organization;
    private int day, month, year;
    private Part image;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public int getDay()
    {
	return day;
    }

    public void setDay(int day)
    {
	this.day = day;
    }

    public int getMonth()
    {
	return month;
    }

    public void setMonth(int month)
    {
	this.month = month;
    }

    public int getYear()
    {
	return year;
    }

    public void setYear(int year)
    {
	this.year = year;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getPhone()
    {
	return phone;
    }

    public void setPhone(String phone)
    {
	this.phone = phone;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public String getOrganization()
    {
	return organization;
    }

    public void setOrganization(String organization)
    {
	this.organization = organization;
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public Part getImage()
    {
	return image;
    }

    public void setImage(Part image)
    {
	this.image = image;
    }
    // </editor-fold>

    public String register()
    {
	try (InputStream image_input = image.getInputStream())
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/pia",
		    "Nemanja",
		    "Olovcica1");

	    String query = "INSERT INTO user_accounts values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement ps = conn.prepareStatement(query);

	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, day);
	    
	    ps.setString(1, username);
	    ps.setString(2, password);
	    ps.setString(3, firstName);
	    ps.setString(4, lastName);
	    ps.setString(5, phone);
	    ps.setString(6, email);
	    ps.setString(7, organization);
	    ps.setDate(8, new java.sql.Date(cal.getTimeInMillis()));
	    ps.setBinaryStream(9, image_input);
	    
	    ps.executeUpdate();
	}
	catch (Exception ex)
	{
	    String msg = ex.getMessage();
	    System.out.println(msg);
	}

	return null;
    }
}
