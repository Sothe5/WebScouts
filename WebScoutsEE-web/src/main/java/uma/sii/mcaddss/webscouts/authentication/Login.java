/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.authentication;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author dan147
 */
@Named(value = "login") 
@RequestScoped
public class Login implements Serializable {
    
    private String username;
    private String password;
    
    private User_Scout userscout;
    
    @Inject 
    private PrivilegesControl ctrl;
    @EJB
    private UsersLocal user_bean;
        
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
        
        try 
        {
            userscout = user_bean.getUser(username);
            if (!userscout.getPassword().equals(password))
            {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Invalid Password", "Invalid Password"));
                return null;
            } else 
            {
               ctrl.setUserScout(userscout); 
               return ctrl.home();  
            }
        }
        catch (NoResultException e)
        {   
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "User does not exist", "User does not exist")); 
            return null;
        }        
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

}
