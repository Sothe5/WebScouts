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
import uma.sii.mcaddss.webscouts.entities.Event;

/**
 *
 * @author cloud
 */
@Stateless
public class EventBusiness implements EventLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;

    @Override
    public void addEvents(List<Event> events) {
        for (Event event : events) {
            em.persist(event);
        }
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addEvent(Event event) {
        em.persist(event);
    }
    
}
