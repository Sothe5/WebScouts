/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.authentication;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author dan147
 */
@SessionScoped
public class PrivilegesControl implements Serializable{
    private User_Scout userscout;
    
    
    public String home(){
        if (userscout == null) return "login.xhtml";
        
        //TODO: We need to get the userscout's role so we can redirect to the proper page
        //
        
        return null;
    }
    
    public User_Scout getUserScout(){
        return userscout;
    }
    
    public void setUserScout(User_Scout u){
        this.userscout = u;
    }
}
