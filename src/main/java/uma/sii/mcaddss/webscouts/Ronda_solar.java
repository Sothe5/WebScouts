/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscouts;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elmau
 */
public class Ronda_solar {
    
    private static Ronda_solar this_round;
    @Temporal(TemporalType.DATE)
    private Date endOfRound;
    @Temporal(TemporalType.DATE)
    private Date startOfRound;
    
    public boolean init_Ronda_solar(Date sDate, Date fDate) {
        
        boolean res = false;
        
        if (this_round == null) {
            res = true;
            this_round = new Ronda_solar(sDate, fDate);
        }             
        
        return res;
        
    }

    private Ronda_solar(Date sDate, Date fDate) {
        
        this.endOfRound = fDate;
        this.startOfRound = sDate;
        
    }
    
    /**
     * @return the endOfRound
     */
    public Date getEndOfRound() {
        return this_round.endOfRound;
    }

    /**
     * @param endOfRound the endOfRound to set
     */
    public void setEndOfRound(Date endOfRound) {
        this_round.endOfRound = endOfRound;
    }

    /**
     * @return the startOfRound
     */
    public Date getStartOfRound() {
        return this_round.startOfRound;
    }

    /**
     * @param startOfRound the startOfRound to set
     */
    public void setStartOfRound(Date startOfRound) {
        this_round.startOfRound = startOfRound;
    }
    
    public void end_Round(Date date) {
        
        this_round.startOfRound = this_round.endOfRound;
        this_round.endOfRound = date;
        
    }

    /*
        In case user set the wrong dates when setting the round
    */
    
    public void correct_Round(Date sDate, Date fDate) {
        
        this.startOfRound = sDate;
        this.endOfRound = fDate;
        
    }    
    
}
