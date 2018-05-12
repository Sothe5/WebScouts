package uma.sii.mcaddss.webscouts.entities;

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

/*
This entity represents the roles of the users in the database.
These roles has some privileges associated with them and implements some methods
to grant or revoke those privileges.
It has associated many users, but just one role can be assigned to each user.
*/
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
    private String role_name;
    @OneToMany(mappedBy = "role")
    private Set<Privilege> privileges;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiration;
    @OneToMany(mappedBy="role")
    private Set<User_Scout> users;
    
    public Role_Scout(){
    }
    
    public Role_Scout(String role){
        this.setRole_name(role);
    }
    
    public Long getId() {
        return id;
    }

    public void grantPrivilege(Privilege permission) {
        getPermissions().add(permission);
    }
    
    public void revokePrivilege(Privilege permission) {
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
     * @return the privileges     */
    public Set<Privilege> getPermissions() {
        return privileges;
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

    public String getRole_name() {
        return role_name;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
    
    public String getRoleName(){
        return role_name;
    }
    
    public void setRole_name(String rname){
        if (rname.equalsIgnoreCase("ADMIN") || rname.equalsIgnoreCase("SCOUTER") || rname.equalsIgnoreCase("EDUCANDO"))
        {
           this.role_name = rname; 
        }
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
