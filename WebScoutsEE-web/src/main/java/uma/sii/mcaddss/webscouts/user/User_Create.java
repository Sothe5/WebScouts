/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Carles Bordas
 */
@ManagedBean
public class User_Create {

    @EJB
    private Role_ManagerLocal rm;
    
    @EJB
    private Group_ManagerLocal gm;
    
    @EJB
    private UsersLocal um;
    
    private String name;
    private String surname1;
    private String surname2;

    
    private String password;
    private String email;
    private Date birthdate;
    private Group_Scout group;
    private Role_Scout role;

    public User_Create() {
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }
    
    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Group_Scout getGroup() {
        return group;
    }

    public void setGroup(Group_Scout group) {
        this.group = group;
    }

    public Role_Scout getRole() {
        return role;
    }

    public void setRole(Role_Scout role) {
        this.role = role;
    }

    public List<Role_Scout> getAllRoles() {
        return rm.getAllRoles();
    }
    
    public List<Group_Scout> getAllGroups() {
        return gm.getAllGroups();
    }
    
    public void submit() {
        User_Scout newUser = new User_Scout();
        newUser.setUser_name(name);
        newUser.setFirst_name(surname1);
        newUser.setLast_name(surname2);
        newUser.setPassword(password);
        newUser.setBirthdate(birthdate);
        newUser.setGroupscout(group);
        newUser.setRole(role);
        um.addUser(newUser);
    }
    
}
