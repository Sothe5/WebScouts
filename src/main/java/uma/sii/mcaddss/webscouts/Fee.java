/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Las cuotas recogen el pago de eventos por los educandos
 * 
 * @author Alvaro
 */
@Entity
@Table(name = "FEES")
public class Fee implements Serializable {
    
    @EmbeddedId
    private FeeId  id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("event")
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userscout")
    private User_Scout userscout;
    
    private Double amount;   
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;
    
    /**
     * 
     * @return amount
     */
    public Double getAmount(){
        return amount;
    }
    /**
     * 
     * @param amount to set new amount
     */
    public void setAmount(Double amount){
        this.amount = amount;
    }
    
    /**
     * 
     * @return date
     */
    public Date getDate(){
        return date;
    }
    
    /**
     * 
     * @param date to set new date
     */
    public void setDate(Date date){
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Fee)) return false;
      
        Fee other = (Fee) object;
        return Objects.equals(this.userscout, other.userscout) &&
                Objects.equals(this.event, other.event);
    }

    @Override
    public String toString() {
        return "uma.sii.mcaddss.webscouts.Fee[ id=" + id + " + user= " + userscout + "event= " + event + "]";
    }
        
}
