/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.security.acl.Group;
import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Local
public interface UsersLocal {
    public List<User_Scout> getAllUsers();
    public List<User_Scout> getAllUsersEvent(Event event);
    public List<User_Scout> getAllUsersGroup(Group_Scout group);
    public List<User_Scout> getAllUsersGroup(String group_id);
    public List<User_Scout> getAllUsersRole(Role_Scout role);
    public List<User_Scout> getAllUsersRole(String role_id);
    public List<User_Scout> getAllUsersGroupRole(String group_id,String role_id);
    public void addUser(User_Scout user);
}
