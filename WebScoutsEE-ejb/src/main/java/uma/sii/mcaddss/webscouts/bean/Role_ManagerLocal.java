/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Local
public interface Role_ManagerLocal {
    public void createRole(Role_Scout role);
    public void createRoles(List<Role_Scout> roles);
    public Role_Scout getRoleById(Long id);
    public Role_Scout getUserRole(Long id);
    public List<Role_Scout> getAllRoles();
    public void revokeUserRole(Long id);
    public void changeUserRole(Long id, String rolename);
}
