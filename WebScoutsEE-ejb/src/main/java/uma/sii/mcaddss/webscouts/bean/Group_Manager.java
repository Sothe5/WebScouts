/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Nexel
 */
@Stateless
public class Group_Manager implements Group_ManagerLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void createGroup(Group_Scout group){
        em.persist(group);
    }
    
    public List<Group_Scout> getAllGroups(){
        Query query = em.createQuery("SELECT g FROM Group_Scout g");
        List<Group_Scout> groups = query.getResultList();
        return groups;
    }
}
