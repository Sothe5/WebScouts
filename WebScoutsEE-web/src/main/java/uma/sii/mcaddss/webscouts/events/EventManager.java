/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
import uma.sii.mcaddss.webscouts.bean.EventLocal;
import uma.sii.mcaddss.webscouts.entities.Event;

/**
 *
 * @author cloud
 */
@Named(value = "eventManager")
@RequestScoped
public class EventManager {
    
    @Inject
    private PrivilegesControl ctrl;
    @EJB
    private EventLocal eventB;
    
    public List<Event> getEvents()
    {
        return eventB.getAllEvents();
    }
    
}
