package uma.sii.mcaddss.webscouts.entities;

import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elmau
 */
@Table(name = "SOLAR_ROUND")
public class Solar_round {
    
    private static Solar_round this_round;
    @Temporal(TemporalType.DATE)
    private Date endOfRound;
    @Temporal(TemporalType.DATE)
    private Date startOfRound;
    
    public static boolean init_SOLAR_ROUND(Date sDate, Date fDate) {
        
        boolean res = false;
        
        if (this_round == null) {
            res = true;
            this_round = new Solar_round(sDate, fDate);
        }             
        
        return res;
        
    }

    private Solar_round(Date sDate, Date fDate) {
        
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
