/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.EventAttendance;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author cloud
 */
@Stateless
public class EventBusiness implements EventLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addEvent(Event event) {
        em.persist(event);
    }

    @Override
    public void addEvents(List<Event> events) {
        for (Event event : events) {
            em.persist(event);
        }
    }

    @Override
    public List<Event> getGroupEvents(Group_Scout g) {
        Query query = em.createQuery("SELECT e FROM Event e WHERE e.groupscout = :usergroup", Event.class);
        query.setParameter("usergroup", g);
        return query.getResultList();
    }
    
    @Override
    public List<Event> getAllEvents() {
        Query query = em.createQuery("SELECT e FROM Event e", Event.class);
        return query.getResultList();
    }

    @Override
    public void modifyEvent(Event event) {
        em.merge(event);
    }
    
    @Override
    public void addAttendance(EventAttendance ea) {
        em.persist(ea);
    }
    
    @Override
    public EventAttendance findAttendance(User_Scout u, Event e) {
        try {
            Query query = em.createQuery("SELECT e FROM EventAttendance e WHERE e.user = :user AND e.event = :event", EventAttendance.class);
            query.setParameter("user", u);
            query.setParameter("event", e);
            return (EventAttendance) query.getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
    public Event getEventById(Long id) {
        return em.find(Event.class, id);
    }
}
