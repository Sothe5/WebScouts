/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscouts;

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

/**
 *
 * @author zolastro
 */
@Entity
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PermissionType type;
    private List<Resource> resources;
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiration;
    @ManyToOne
    private Set<User_Scout> users;

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
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
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
     * @return the resources
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
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

    /**
     * @return the users
     */
    public Set<User_Scout> getUsers() {
        return users;
    }
    
}
