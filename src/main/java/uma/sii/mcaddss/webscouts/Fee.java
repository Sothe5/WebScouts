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
import java.util.List;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Las cuotas recogen el pago de eventos por los educandos
 * 
 * @author Alvaro
 */
@Entity
@Table(name = "FEES")
public class Fee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fee")
    private List<User_Scout> userscouts;
    private Double amount;   
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;
       
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userscouts
     */
    public List<User_Scout> getUserscouts() {
        return userscouts;
    }

    /**
     * @param userscouts the userscouts to set
     */
    public void setUserscouts(List<User_Scout> userscouts) {
        this.userscouts = userscouts;
    }
    
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


    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fee other = (Fee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uma.sii.mcaddss.webscouts.Fee[ id=" + getId() + "]";
    }
        
}
