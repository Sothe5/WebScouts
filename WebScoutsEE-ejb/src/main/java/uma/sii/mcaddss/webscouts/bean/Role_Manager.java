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
import uma.sii.mcaddss.webscouts.entities.Role_Scout;

/**
 *
 * @author Nexel
 */
@Stateless
public class Role_Manager implements Role_ManagerLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void createRole(Role_Scout role){
        em.persist(role);
    }
    
    @Override
    public void createRoles(List<Role_Scout> roles) {
        for (Role_Scout role : roles) {
            em.persist(role);
        }
    }
    
    @Override
    public List<Role_Scout> getAllRoles(){
        Query query = em.createQuery("SELECT r FROM Role_Scout r");
        List<Role_Scout> roles = query.getResultList();
        return roles;
    }
}
