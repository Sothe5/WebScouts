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
import uma.sii.mcaddss.webscouts.bean.Group_Manager;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_Manager;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "filterView")
@Dependent
public class FilterView {
    
    private String selection;
    private String search;
    
    @EJB
    private Role_ManagerLocal role_manager;
    @EJB
    private Group_ManagerLocal group_manager;

    /**
     * Creates a new instance of SelectOneMenuView_Filter
     */
    public FilterView() {
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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
        hash = 59 * hash + Objects.hashCode(this.selection);
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
        if (!Objects.equals(this.selection, other.selection)) {
            return false;
        }
        return true;
    }

    
}
