/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author cloud
 */
@Named(value = "signup") 
@RequestScoped
public class User_Signup {
    
    @EJB
    private UsersLocal user_bean;
    @EJB 
    private Role_ManagerLocal role_bean;
    @EJB
    private Group_ManagerLocal group_bean;
    
    private List<Group_Scout> groups;
    
    private String username;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String email;
    private String address;
    private Group_Scout group;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordConfirm
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * @param passwordConfirm the passwordConfirm to set
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public Group_Scout getGroup(){
        return group;
    }
    
    public void setGroup(Group_Scout group){
        this.group = group;
    }
    
    public List<Group_Scout> getGroups(){
        return groups;
    }
    
    public void setGroups(List<Group_Scout> groups){
        this.groups = groups;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void register() {
        if (!validatePassword())
        {
            return;
        }
        
        init();
        
        Long id = user_bean.getLastUserId() + 1;
        Role_Scout role = role_bean.getRoleById((long)0);
        
        User_Scout user = new User_Scout(id, username, group, password, 
                firstName, lastName, email, address, birthdate, role);
        user_bean.addUser(user);
    }
    
    public Boolean validatePassword() {
        return password.equals(passwordConfirm);
    }
    
    @PostConstruct
    public void init(){
        groups = group_bean.getAllGroups();
    }
}