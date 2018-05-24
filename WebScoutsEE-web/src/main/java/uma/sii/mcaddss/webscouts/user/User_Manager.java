/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uma.sii.mcaddss.webscouts.bean.Users;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "user_Manager")
@Dependent
public class User_Manager {
    
    @EJB
    private Users user_bean;

    /**
     * Creates a new instance of User_Manager
     */
    public User_Manager() {
    }
    
    public List<User_Scout> getUsuarios() {
        return user_bean.getAllUsers();
    }
    
    public List<User_Scout> getUsuariosGrupo(Group_Scout group) {
        return user_bean.getAllUsersGroup(group);
    }
    
    public List<User_Scout> getUsuariosEvento(Event event) {
        List<User_Scout> user_events = user_bean.getAllUsersEvent(event);
        return user_events;
    }
    
}
