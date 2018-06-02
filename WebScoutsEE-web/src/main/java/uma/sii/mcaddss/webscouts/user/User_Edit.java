/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
import uma.sii.mcaddss.webscouts.entities.Multimedia;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;


/**
 *
 * @author dan147
 */
@Named(value = "userEdit") 
@RequestScoped
public class User_Edit {
    
    @Inject
    private PrivilegesControl ctrl;
    @EJB
    private UsersLocal user_bean;
    
    private User_Scout us;
    
    private String nusername;
    private String npassword;
    private String npassword1;
    private String nemail;
    private Multimedia nphoto;
    
    public String getNewUsername(){
        return nusername;
    }
    
    public void setNewUsername(String nusername){
        this.nusername = nusername;
    }
    
    public String getNewPassword(){
        return npassword;
    }
    
    public void setNewPassword(String npassword){
        this.npassword = npassword;
    }
    
    public String getNewPassword1(){
        return npassword1;
    }
    
    public void setNewPassword1(String npassword1){
        this.npassword1 = npassword1;
    }
    
    public String getNewEmail(){
        return nemail;
    }
    
    public void setNewEmail(String nemail){
        this.nemail = nemail;
    }
    
    public Multimedia getNewPhoto(){
        return nphoto;
    }
    
    public void setNewPhoto(Multimedia nphoto){
        this.nphoto = nphoto;
    }
    
    public String confirmChanges(){
        us = ctrl.getUserScout();
        
        if (!nusername.isEmpty())
        {
            us.setUser_name(nusername);
        }
        
        if (!npassword.isEmpty() && !npassword1.isEmpty() && npassword.equals(npassword1))
        {
            us.setPassword(npassword);
        }
        
        if (!nemail.isEmpty())
        {
            us.setEmail(nemail);
        }
        
        if (nphoto != null)
        {
            us.setPhoto(nphoto);
        }
        
        user_bean.editUser(us);
        
        return "user_profile.xhtml";  
    }
}
