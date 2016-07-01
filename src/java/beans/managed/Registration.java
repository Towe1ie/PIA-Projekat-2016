/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import java.util.Date;
import javax.faces.bean.*;

@ManagedBean
@RequestScoped
public class Registration
{
    private String username, password, firstName, lastName, phone, email, organization;
    private Date dateOfBirth;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
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

    public Date getDateOfBirth()
    {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
	this.dateOfBirth = dateOfBirth;
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
    
    // </editor-fold>
    
    public String register()
    {
	
	return null;
    }
}
