/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
import uma.sii.mcaddss.webscouts.files.FileUploadBean;

/**
 *
 * @author cloud
 */
@Named(value = "signup") 
@RequestScoped
public class User_Signup {
    
    private static final String USERS = "users";
    
    //@Inject
    //private FileUploadBean fu;
    
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
    private UploadedFile photo;

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
    
    public UploadedFile getPhoto(){
        return photo;
    }
    
    public void setPhoto(UploadedFile photo){
        this.photo = photo;
    }
    
    public void register() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if (!validatePassword())
        {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Passwords don't match", "Passwords don't match"));
            return;
        }
        
        int age = getAge(birthdate);
        group = groupByAge(age);
        
        Long id = getMaxUserId() + 1;
        
        Role_Scout role = role_bean.getRoleById((long)0);
        
        User_Scout user = new User_Scout(id, username, group, password, 
                firstName, lastName, email, address, birthdate, role);
        
        user_bean.addUser(user);
        
        //fu.imageUpload(photo, USERS);          
    }
    
    public Boolean validatePassword() {
        return password.equals(passwordConfirm);
    }
    
    private int getAge(Date date){
        
        //TODO add throws.. if birthdate is null
        LocalDate birthdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now(); 
        
        return Period.between(birthdate, currentDate).getYears();    
    }
    
    private Group_Scout groupByAge(int age){
        groups = group_bean.getAllGroups();
        
        for (Group_Scout g : groups){
            if (g.getMinAge() < age && age < g.getMaxAge())
            {
                return g;
            }     
        }

        return null;
    }
    
    public Long getMaxUserId(){
        Long id = 0L;
        List<User_Scout>  users = user_bean.getAllUsers();
        
        for(User_Scout u : users){
            if (id < u.getId())
            {
                id = u.getId();
            }
                
        }
        
        return id;
    }
    
}
