/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uma.sii.mcaddss.webscouts.Grantable;

/**
 *
 * @author zolastro
 */
@Entity
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Grantable resource;
    private PermissionType type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiration;

    public Privilege(Grantable resource, PermissionType type) {
        this(resource, type, null);
    }
    
    public Privilege(Grantable resource, PermissionType type, Date expiration) {
        this.resource = resource;
        this.type = type;
        this.expiration = expiration;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Permission[ id=" + id + " ]";
    }

    /**
     * @return the type
     */
    public PermissionType getType() {
        return type;
    }

    /**
     * @param resources the resources to set
     */
    public void setResource(Grantable resources) {
        this.resource = resource;
    }

    /**
     * @return the expiration
     */
    public Date getExpiration() {
        return expiration;
    }

    /**
     * @param expiration the expiration to set
     */
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
    
}
