/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.unmanaged;

import java.io.InputStream;
import java.sql.Date;

public class User
{
    private String username, first_name, last_name, phone, email, organization;
    private Date date_of_birth;
    private InputStream image;

    public User(String username, String first_name, String last_name, String phone, String email, String organization, Date date_of_birth, InputStream image)
    {
	this.username = username;
	this.first_name = first_name;
	this.last_name = last_name;
	this.phone = phone;
	this.email = email;
	this.organization = organization;
	this.date_of_birth = date_of_birth;
	this.image = image;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters and setters">

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getFirst_name()
    {
	return first_name;
    }

    public void setFirst_name(String first_name)
    {
	this.first_name = first_name;
    }

    public String getLast_name()
    {
	return last_name;
    }

    public void setLast_name(String last_name)
    {
	this.last_name = last_name;
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

    public Date getDate_of_birth()
    {
	return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth)
    {
	this.date_of_birth = date_of_birth;
    }

    public InputStream getImage()
    {
	return image;
    }

    public void setImage(InputStream image)
    {
	this.image = image;
    }
    
    // </editor-fold>
}
