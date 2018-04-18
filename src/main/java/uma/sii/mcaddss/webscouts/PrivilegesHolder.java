
package uma.sii.mcaddss.webscouts;

import java.util.Set;

/**
 *
 * @author Carles Bordas
 */
public interface PrivilegesHolder {
    
    public boolean addPrivilege(Privilege privilege);
    
    public boolean removePrivilege(Privilege privilege);
    
    public Set<Privilege> getAllPrivileges();
    
}
