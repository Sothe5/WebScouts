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
import uma.sii.mcaddss.webscouts.entities.PermissionType;
import static uma.sii.mcaddss.webscouts.entities.PermissionType.*;
import uma.sii.mcaddss.webscouts.entities.Privilege;
import uma.sii.mcaddss.webscouts.entities.Resource;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;

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
        Role_Scout r = new Role_Scout();
        us.setRole(r);
        
        User_Scout us1 = new User_Scout();
        us.setUser_name("uneducando");
        us.setPassword("pweducando");
        Role_Scout r1 = new Role_Scout();
        // Grant all privileges except grant ones
        for (PermissionType perm : PermissionType.values()) {
            if (perm.equals(GRANT)) continue;
            for (Resource res : Resource.values()) {
                r1.grantPrivilege(new Privilege(res, perm));
            }
        }
        us.setRole(r1);
        
        User_Scout us2 = new User_Scout();
        us2.setUser_name("unadmin");
        us2.setPassword("pwadmin");
        Role_Scout r2 = new Role_Scout();
        // Grant all privileges
        for (PermissionType perm : PermissionType.values()) {
            for (Resource res : Resource.values()) {
                r2.grantPrivilege(new Privilege(res, perm));
            }
        }
        us.setRole(r2);
        
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
