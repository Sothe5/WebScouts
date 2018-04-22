/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zolastro
 */
@Entity
@Table(name = "ROLES")
public class Role_Scout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "role")
    private Set<Privilege> privileges;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiration;
    @OneToMany(mappedBy="role")
    private Set<User_Scout> users;
    
    public Long getId() {
        return id;
    }

    public void grantPermission(Privilege permission) {
        getPermissions().add(permission);
    }
    
    public void revokePermission(Privilege permission) {
        getPermissions().remove(permission);
    }
    
    public boolean hasPermission(Privilege permission) {
        return getPermissions().contains(permission);
    }

    @Override
    public String toString() {
        return "webscouts.Role[ id=" + id + " ]";
    }

    /**
     * @return the pprivileges     */
    public Set<Privilege> getPermissions() {
        return privileges;
    }

    /**
     * @param permissions the perprivileges set
     */
    public void setPermissions(Set<Privilege> permissions) {
        this.privileges = permissions;
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
        if (!(object instanceof Role_Scout)) {
            return false;
        }
        Role_Scout other = (Role_Scout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
