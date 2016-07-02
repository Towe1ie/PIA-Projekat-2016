/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.*;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class Registration
{

    private String username, password, firstName, lastName, phone, email, organization;
    private Date dateOfBirth;
    private Part image;
    private UploadedFile file;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public UploadedFile getFile()
    {
	return file;
    }

    public void setFile(UploadedFile file)
    {
	this.file = file;
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

    public Part getImage()
    {
	return image;
    }

    public void setImage(Part image)
    {
	this.image = image;
    }
    // </editor-fold>

    public void imageUploaded(FileUploadEvent e)
    {
	file = e.getFile();
    }

    public String register()
    {
	try (InputStream image_input = file.getInputstream())
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/pia",
		    "Nemanja",
		    "Olovcica1");

	    String query = "INSERT INTO user_accounts values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement ps = conn.prepareStatement(query);

	    ps.setString(1, username);
	    ps.setString(2, password);
	    ps.setString(3, firstName);
	    ps.setString(4, lastName);
	    ps.setString(5, phone);
	    ps.setString(6, email);
	    ps.setString(7, organization);
	    ps.setDate(8, new java.sql.Date(dateOfBirth.getTime()));
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
