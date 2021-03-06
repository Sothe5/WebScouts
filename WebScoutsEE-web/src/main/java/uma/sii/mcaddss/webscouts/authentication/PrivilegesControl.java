/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.authentication;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author dan147
 */
@Named(value = "privilegesControl")
@SessionScoped
public class PrivilegesControl implements Serializable{
    private User_Scout userscout;
    private String user_role;
    
    
    public String home(){
        if (userscout == null) 
        {
            return "login.xhtml";
        } else {
            user_role = userscout.getRole().getRoleName();
            return "index.xhtml";
        }
    }
    
    /**
     * Calcula el hash de un String mediante el algoritmo SHA-256 en caso de 
     * estar soportado
     * @param password La contraseña a calcular su hash
     * @return Array de bytes con el hash de la contraseña
     */
    private static byte[] hashPassword(String password) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            hash = password.getBytes();
        }
        return hash;
    }
    
    private static boolean checkPassword(String password, byte[] hashB) {
        byte[] hashA = hashPassword(password);
        if (hashA.length != hashB.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < hashA.length; i++) {
          result |= hashA[i] ^ hashB[i];
        }
        return result == 0;

    }
    
    public User_Scout getUserScout(){
        return userscout;
    }
    
    public void setUserScout(User_Scout u){
        this.userscout = u;
    }
    
    public String getUserScoutName(){
        return this.userscout.getUser_name();
    }
    
    public String getRole(){
        return this.user_role;
    }
}
