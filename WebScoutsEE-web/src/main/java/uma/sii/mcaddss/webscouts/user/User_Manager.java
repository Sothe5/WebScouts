/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
import uma.sii.mcaddss.webscouts.bean.Document_Management;
import uma.sii.mcaddss.webscouts.bean.Document_ManagementLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Document;
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
    
    @Inject
    private PrivilegesControl ctrl;
    @EJB
    private UsersLocal user_bean;
    @EJB
    private Document_ManagementLocal document_manager;

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
    
    public List<User_Scout> getUsuariosGrupo(String group) {
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
    
    public List<User_Scout> getUsuariosRol(String role) {
        List<User_Scout> users_role = user_bean.getAllUsersRole(role);
        return users_role;
    }
    
    
    public List<User_Scout> getUsuariosGrupoRol(String group, String role) {
        List<User_Scout> users_group_role = user_bean.getAllUsersGroupRole(group, role);
        return users_group_role;
    }
    
    public List<User_Scout> filterUsers(String group, String role){
        List<User_Scout> users = new ArrayList<>();
        if(!group.equals("") && !role.equals("")){
            users.addAll(getUsuariosGrupoRol(group, role));
        }else if(!group.equals("")){
            users.addAll(getUsuariosGrupo(group));
        }else if(!role.equals("")){
            users.addAll(getUsuariosRol(role));
        }
        else{
            users.addAll(getUsuarios());
        }
        return users;
    }
    
    public List<Document> getDocumentsUserLoged(){
        return document_manager.getAllDocumentsUser(ctrl.getUserScout());
    }
    
    public List<Document> getDocumentsUser(User_Scout user){
        return document_manager.getAllDocumentsUser(user);
    }
    
    public void changeDocumentStatus(Document doc){
        document_manager.changeDocumentStatus(doc);
    }
}
