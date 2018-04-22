/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zolastro
 */
@Entity
@Table(name = "PRIVILEGES")
public class Privilege implements Serializable, Expirable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Resource resource;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionType type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date expiration;
    @ManyToOne
    private Role_Scout role;

    public Privilege() {
        
    }
    
    public Privilege(Resource resource, PermissionType type) {
        this(resource, type, null);
    }
    
    public Privilege(Resource resource, PermissionType type, Date expiration) {
        this.resource = resource;
        this.type = type;
        this.expiration = expiration;
    }
    
    public Long getId() {
        return id;
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
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     * 
     * @return a string representing a privilege
     */
    @Override
    public String toString() {
        return "Privilege to " + type + " " + resource + " until " + expiration + ".";
    }

    /**
     * @return the type
     */
    public PermissionType getType() {
        return type;
    }

    /**
     * @param resource the resources to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @return the expiration
     */
    @Override
    public Date getExpiration() {
        return expiration;
    }

    /**
     * @param expiration the expiration to set
     */
    @Override
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    /**
     * 
     * @return true if object has overpassed its expiration date
     */
    @Override
    public boolean hasExpired() {
        return new Date().after(expiration);
    }
    
}
