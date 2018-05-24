package uma.sii.mcaddss.webscouts.entities;

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
