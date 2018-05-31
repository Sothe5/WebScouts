/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.Date;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static uma.sii.mcaddss.webscouts.entities.Comment_.message;

/**
 *
 * @author zolastro
 */
@Stateless
public class SolarRound implements SolarRoundLocal {

    private Date date;
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;
    /**
     * @return the date
     */
    @Override
    public Date getDate() {        
        return date;
    }

    /**
     * @param date the date to set
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public void saveDate(){
     //em.persist(date);
    }
}
