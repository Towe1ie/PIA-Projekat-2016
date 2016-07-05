/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.managed;

import beans.unmanaged.User;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class Global
{
    private boolean signedIn = false;
    
    private User user;

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    
    public User getUser()
    {
	return user;
    }

    public void setUser(User user)
    {
	this.user = user;
    }

    public boolean isSignedIn()
    {
	return signedIn;
    }

    public void setSignedIn(boolean signedIn)
    {
	this.signedIn = signedIn;
    }
    
    // </editor-fold>
}
