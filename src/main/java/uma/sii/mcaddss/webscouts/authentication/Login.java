/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.authentication;

import uma.sii.mcaddss.webscouts.entities.User_Scout;
//import uma.sii.mcaddss.webscouts.entities.Role_Scout
import static uma.sii.mcaddss.webscouts.entities.PermissionType.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.data.Data;
import uma.sii.mcaddss.webscouts.entities.PermissionType;
import uma.sii.mcaddss.webscouts.entities.Privilege;
import uma.sii.mcaddss.webscouts.entities.Resource;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;

/**
 *
 * @author dan147
 */
@Named(value = "login") 
@RequestScoped
public class Login implements Serializable {
    
    private Data data;
    private List<User_Scout> users;
    private boolean initialized = false;
    
    private String username;
    private String password;
    
    @Inject 
    private PrivilegesControl ctrl;
        
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
        
        if (!initialized)
        {
            init();
        }
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        for (User_Scout u : users){
            if (u.getUser_name().equals(username)) 
            {
                if (!u.getPassword().equals(password))
                {
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Invalid Password", "Invalid Password"));
                    return null;
                } else 
                {
                   ctrl.setUserScout(u); 
                   return ctrl.home(); 
                } 
            }
        }
        
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "User does not exist", "User does not exist"));
             
        return null;
    }
     
    public void logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        
        try 
        {
            ctx.getExternalContext().redirect("index.xhtml");
        } 
        catch (IOException e) {e.printStackTrace();} 
        
    }
    
    private void init(){
        data = new Data();
        users = new ArrayList(data.getUsuarios());
        initialized = true;
    }
}
