/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "user_Manager")
@Dependent
public class User_Manager {
    
    @EJB
    private UsersLocal user_bean;

    /**
     * Creates a new instance of User_Manager
     */
    public User_Manager() {
    }
    
    public List<User_Scout> getUsuarios() {
        List<User_Scout> users = user_bean.getAllUsers();
        return users;
    }
    
    public List<User_Scout> getUsuariosGrupo(Group_Scout group) {
        List<User_Scout> users_group = user_bean.getAllUsersGroup(group);
        return users_group;
    }
    
    public List<User_Scout> getUsuariosEvento(Event event) {
        List<User_Scout> users_event = user_bean.getAllUsersEvent(event);
        return users_event;
    }
    
    public List<User_Scout> getUsuariosRol(Role_Scout role) {
        List<User_Scout> users_role = user_bean.getAllUsersRole(role);
        return users_role;
    }
    
}
