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
import uma.sii.mcaddss.webscouts.entities.Event;
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
    @Override
    public void createGroup(Group_Scout group){
        em.persist(group);
    }
    
    @Override
    public void createGroups(List<Group_Scout> groups){
        for (Group_Scout group : groups) {
            em.persist(group);
        }
    }
    
    @Override
    public Group_Scout getGroupScoutById(Long id){
        return em.find(Group_Scout.class, id);
    }
    
    @Override
    public List<Group_Scout> getAllGroups(){
        Query query = em.createQuery("SELECT g FROM Group_Scout g");
        List<Group_Scout> groups = query.getResultList();
        return groups;
    }
    
    @Override
    public String getDescription(String name){
       Query query = em.createQuery("SELECT c.description FROM Group_Scout c WHERE c.name = :nombre");
       query.setParameter("nombre", name);
       return query.getResultList().get(0).toString();
    }
    
    @Override
    public List<Event> getEvents(String name){
        
       Query groupQuery = em.createQuery("SELECT d from Group_Scout d where d.name = :nombre"); 
       groupQuery.setParameter("nombre", name);
      
       Query query = em.createQuery("SELECT c FROM Event c WHERE c.groupscout = :grupo", Event.class);    
       query.setParameter("grupo", groupQuery.getResultList().get(0));

       return query.getResultList();
    }
}
