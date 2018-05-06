/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.authentication;

import uma.sii.mcaddss.webscouts.entities.User_Scout;
//import uma.sii.mcaddss.webscouts.entities.Role_Scout

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author dan147
 */
@RequestScoped
public class Login {
    //We are just using hardcoded users here, but the idea is to authenticate the user by database querying
    private String username;
    private String password;
    private List<User_Scout> users;
    
    @Inject 
    private PrivilegesControl ctrl;
    
    public Login (){
        users = new ArrayList<>();
        
        User_Scout us = new User_Scout();
        us.setUser_name("unscouter");
        us.setPassword("pwscouter");
        //us.setRole(new Role(..));     but Role_Scout doesnt have String role_name, otherwise we dont know what role they have
        User_Scout us1 = new User_Scout();
        us.setUser_name("uneducando");
        us.setPassword("pweducando");
        
        User_Scout us2 = new User_Scout();
        us2.setUser_name("unadmin");
        us2.setPassword("pwadmin");
        
        users.add(us);
        users.add(us1);
        users.add(us2);
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String authenticate(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        for (User_Scout u : users){
            if (u.getUser_name().equals(username)) 
            {
                if (!u.getPassword().equals(password))
                {
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Password", 
                "Invalid Password"));
                    return null;
                } else {
                   ctrl.setUserScout(u); 
                   return ctrl.home(); 
                } 
            }
        }
        
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User doesn't exist", "User doesn't exist"));
             
        return null;
    }
}
