/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.solar_round;

import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uma.sii.mcaddss.webscouts.bean.SolarRoundLocal;
import static uma.sii.mcaddss.webscouts.entities.Comment_.message;

/**
 *
 * @author zolastro
 */
@Named(value = "solarRoundManager")
@Dependent
public class SolarRoundManager {

    @EJB
    private SolarRoundLocal solarRound;
    private Date date;
    /**
     * Creates a new instance of SolarRoundManager
     */
    public SolarRoundManager() {
      
    }
    
    
    public void saveDate() {
           
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ronda solar correctamente guardada",  "Your message: " + message) );

        solarRound.setDate(date);
        solarRound.saveDate();
    }

    /**
     * @return the date
     */
    public Date getDate() {
        date = solarRound.getDate();
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
