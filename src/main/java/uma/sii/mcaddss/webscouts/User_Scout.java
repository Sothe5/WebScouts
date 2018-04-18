/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nexel
 */
@Entity
<<<<<<< HEAD
public class User_Scout implements PrivilegeHolder, Serializable {
=======
public class User_Scout implements PrivilegesHolder, Serializable {
>>>>>>> d62f85cd05948bddefb57496100b51aca340312e

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String user_name;
    private String surname;
    private String last_name;
    private String password;
    private String address;
    private String email;
    private String civil_status;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @ManyToMany(mappedBy="users")
    private Set<Role_Scout> roles;
    @OneToMany(mappedBy="users")
    private Set<Privilege> temporal_privileges;  


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Role_Scout> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role_Scout> roles) {
        this.roles = roles;
    }
    
    public void addRole(Role_Scout role, User_Scout user){
        user.roles.add(role);
    }
    
    public void removeRole(Role_Scout role, User_Scout user){
        if(user.roles.contains(role)){
            user.roles.remove(role);
        }
    }

    public Set<Privilege> getTemporalPrivileges() {
        return temporal_privileges;
    }

    public void setTemporalPrivileges(Set<Privilege> temporal_privileges) {
        this.temporal_privileges = temporal_privileges;
    }
    
    public void addTemporalPrivilege(Privilege privilege, User_Scout user){
        user.temporal_privileges.add(privilege);
    }
    
    public void addTemporalPrivilege(Set<Privilege> privileges, User_Scout user){
        user.temporal_privileges.addAll(privileges);
    }
    
    public void removePrivilege(Privilege privilege, User_Scout user){
        if(user.temporal_privileges.contains(privilege)){
            user.temporal_privileges.remove(privilege);
        }
    }
    
    public void removePrivilege(Set<Privilege> privileges, User_Scout user){
        if(user.temporal_privileges.containsAll(privileges)){
            user.temporal_privileges.removeAll(privileges);
        }
    }
    
    public Set<Privilege> getAllPrivileges() {
        Set<Privilege> privileges = new HashSet<>();
        for(Role_Scout role : roles){
            privileges.addAll(role.getPermissions());
        }
        return privileges;
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
        if (!(object instanceof User_Scout)) {
            return false;
        }
        User_Scout other = (User_Scout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Usuario[" + user_name + " identificado por número de id " + id +" (" + surname + " " + last_name +")]";
    }

    @Override
    public boolean addPrivilege(Privilege privilege) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removePrivilege(Privilege privilege) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
