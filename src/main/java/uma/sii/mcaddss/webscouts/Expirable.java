/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.util.Date;

/**
 *
 * @author Carles Bordas
 */
public interface Expirable {
    
    public Date getExpiration();
    public void setExpiration(Date expiration);
    public boolean hasExpired();
    
}
