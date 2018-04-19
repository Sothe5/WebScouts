/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscouts;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alvaro
 */
@Entity
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    private int cost;
    private String category;
    
    private Events (String name, Date date, int cost, String category){
        this.name = name;
        this.date = date;
        this.cost = cost;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void createEvent(String nom, Date fe, int co, String cat) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventData");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Events event = new Events(nom,fe,co,cat);
        
        tx.begin();
        em.persist(event);
        tx.commit();
        em.close();
        
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Events[ id=" + id + "Event(" + name + ", " + category + ", " + date + ", " + cost + ") ]";
    }
    
}
