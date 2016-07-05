/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.unmanaged;

import java.sql.Date;
import javax.faces.event.ActionEvent;

public class Conference
{
    private int id;
    private String name, location;
    private Date conf_date, subm_start, subm_end;
    private int max_subm;

    public Conference(int id, String name, String location, Date conf_date, Date subm_start, Date subm_end, int max_subm)
    {
	this.id = id;
	this.name = name;
	this.location = location;
	this.conf_date = conf_date;
	this.subm_start = subm_start;
	this.subm_end = subm_end;
	this.max_subm = max_subm;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public int getId()
    {
	return id;
    }

    public String getName()
    {
	return name;
    }

    public String getLocation()
    {
	return location;
    }

    public Date getConf_date()
    {
	return conf_date;
    }

    public Date getSubm_start()
    {
	return subm_start;
    }

    public Date getSubm_end()
    {
	return subm_end;
    }

    public int getMax_subm()
    {
	return max_subm;
    }
    // </editor-fold>
    
    public String pick()
    {
	return "registerNewWork";
    }
}
