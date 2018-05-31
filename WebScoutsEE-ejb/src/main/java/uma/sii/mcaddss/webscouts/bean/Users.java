/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.security.acl.Group;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Stateless
public class Users implements UsersLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;

    @Override
    public List<User_Scout> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User_Scout u", User_Scout.class);
        return query.getResultList();
    }

    @Override
    public List<User_Scout> getAllUsersEvent(Event event) {
        Query query = em.createQuery("SELECT ev.user FROM EventAttendance ev WHERE ev.event = :fevent AND ev.attendance_status = 'yes'", User_Scout.class);
        query.setParameter("fevent", event);
        return query.getResultList();    
    }

    @Override
    public List<User_Scout> getAllUsersGroup(Group_Scout group) {
        Query query = em.createQuery("SELECT u FROM User_Scout u WHERE u.groupscout = :fgroup", User_Scout.class);
        query.setParameter("fgroup", group);
        return query.getResultList();
    }
    
    @Override
    public List<User_Scout> getAllUsersGroup(String group_id) {
        Group_Scout ac_group = em.find(Group_Scout.class, Long.parseLong(group_id));
        Query query = em.createQuery("SELECT u FROM User_Scout u WHERE u.groupscout = :fgroup", User_Scout.class);
        query.setParameter("fgroup", ac_group);
        return query.getResultList();
    }
    
    @Override
    public List<User_Scout> getAllUsersRole(Role_Scout role) {
        Query query = em.createQuery("SELECT u FROM User_Scout u WHERE u.role = :frole", User_Scout.class);
        query.setParameter("frole", role);
        return query.getResultList();
    }
    
    @Override
    public List<User_Scout> getAllUsersRole(String role_id) {
        Role_Scout ac_role = em.find(Role_Scout.class,Long.parseLong(role_id));
        Query query = em.createQuery("SELECT u FROM User_Scout u WHERE u.role = :frole", User_Scout.class);
        query.setParameter("frole", ac_role);
        return query.getResultList();
    }
    
    @Override
    public List<User_Scout> getAllUsersGroupRole(String group_id,String role_id){
        Group_Scout ac_group = em.find(Group_Scout.class, Long.parseLong(group_id));
        Role_Scout ac_role = em.find(Role_Scout.class,Long.parseLong(role_id));
        Query query = em.createQuery("SELECT u FROM User_Scout u WHERE u.groupscout = :fgroup AND u.role = :frole", User_Scout.class);
        query.setParameter("fgroup", ac_group);
        query.setParameter("frole", ac_role);
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addUser(User_Scout user) {
        em.persist(user);
    }
    
    @Override
    public void addUsers(List<User_Scout> users) {
        for (User_Scout user : users) {
            em.persist(user);
        }            
    }
}
