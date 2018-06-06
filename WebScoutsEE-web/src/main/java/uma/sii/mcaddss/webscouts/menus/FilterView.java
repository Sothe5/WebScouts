/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.RowEditEvent;
import uma.sii.mcaddss.webscouts.bean.Group_Manager;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_Manager;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@ManagedBean(name = "filterView")
@SessionScoped
public class FilterView {
    
    private String selection_group;
    private String selection_role;
    
    private Group_Scout selectedGroup;
    private Role_Scout selectedRole;
    
    @EJB
    private Role_ManagerLocal role_manager;
    @EJB
    private Group_ManagerLocal group_manager;
    
    @EJB
    private UsersLocal user_manager;

    /**
     * Creates a new instance of SelectOneMenuView_Filter
     */
    public FilterView() {
    }

    public String getSelection_group() {
        return selection_group;
    }

    public void setSelection_group(String selection_group) {
        this.selection_group = selection_group;
    }

    public String getSelection_role() {
        return selection_role;
    }

    public void setSelection_role(String selection_role) {
        this.selection_role = selection_role;
    }
    
    public List<Role_Scout> getAllRoles(){
        return role_manager.getAllRoles();
    }
    
    public List<Group_Scout> getAllGroups(){
        return group_manager.getAllGroups();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.role_manager);
        hash = 17 * hash + Objects.hashCode(this.group_manager);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilterView other = (FilterView) obj;
        if (!Objects.equals(this.role_manager, other.role_manager)) {
            return false;
        }
        if (!Objects.equals(this.group_manager, other.group_manager)) {
            return false;
        }
        return true;
    }
    
    public void selectedGroup(ValueChangeEvent event) {
        this.selectedGroup = (Group_Scout) event.getNewValue();
    }
    
    public void selectedRole(ValueChangeEvent event) {
        this.selectedRole = (Role_Scout) event.getNewValue();
    }
    
    public void onRowEdit(RowEditEvent event) {
        User_Scout user = (User_Scout) event.getObject();
        if (selectedGroup != null) {
            user.setGroupscout(selectedGroup);
            selectedGroup = null;
        }
        if (selectedRole != null) {
            user.setRole(selectedRole);
            selectedRole = null;
        }
        user_manager.editUser(user);
    }
    
}
