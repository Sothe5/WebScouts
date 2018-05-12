package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
This entity represents the invoices of the database.
It is a class that extends from document as it is an special case of Document.
*/
/**
 *
 * @author dan147
 */

@Entity
@Table(name = "INVOICES")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Invoice extends Document implements Serializable {
    
    private int invoiceNum;
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    private String invoicingAddress;
    
    public Invoice (String name, boolean status, String type, int ivnum, Date ivdate, String ivaddress) {
        super(name, status, type);  
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
