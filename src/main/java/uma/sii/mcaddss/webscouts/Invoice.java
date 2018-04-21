/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dan147
 */

@Entity
@Table(name = "Invoices")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Invoice extends Document implements Serializable {
    
    private int invoiceNum;
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    private String invoicingAddress;
    
    public Invoice (String name, Long size, String status, String type, int ivnum, Date ivdate, String ivaddress) {
        super(name, size, status, type);  
        this.invoiceNum = ivnum;
        this.invoiceDate = ivdate;
        this.invoicingAddress = ivaddress;
    }
    
    public Invoice () {
        super();
    }
    
    public int getInvoiceNum() {
        return  invoiceNum;
    }
    
    public void setInvoiceNum(int ivnum) {
        invoiceNum = ivnum;
    }
    
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Date ivdate) {
        invoiceDate = ivdate;
    }
    
    public String getInvoicingAddress(){
        return invoicingAddress;
    }
    
    public void setInvoicingAddress(String ivaddress) {
        invoicingAddress = ivaddress;
    }
        
    //orderRef is of type String on the diagram, shouldnt it be a reference of Order?
    public Invoice getByRef(String orderRef) {
        //TODO:
        return null;
    }
    
    @Override
    public int hashCode() {
        return (id != null ? id.hashCode() : 0);
    }
    
    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Invoice)){
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "webscouts.Invoice[Id= " + id + ", Invoice Number= " + invoiceNum + " ]";  
    }
    
}
