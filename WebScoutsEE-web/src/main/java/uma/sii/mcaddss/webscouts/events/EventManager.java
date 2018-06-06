/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
import uma.sii.mcaddss.webscouts.bean.EventLocal;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

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
    @EJB
    private Group_ManagerLocal groupB;
    
    FacesContext ctx = FacesContext.getCurrentInstance();
    
    private Event event;
    private Long id;
    private String name;
    private String description;
    private Date date;
    private Group_Scout group;
    private Long group_id;
    
    public List<Event> getEvents()
    {
        return eventB.getAllEvents();
    }
    
    public String renderEditPage(Event e) {
        event = e;
        id = e.getId();
        name = e.getName();
        description = e.getDescription();
        date = e.getDate();
        setGroup_id(e.getGroupscout().getId());
        return "edit_event.xhtml";
    }
    
    public void createEvent() {
        try {
            event = new Event();
            event.setName(name);
            event.setDate(date);
            event.setDescription(description);
            event.setGroupscout(getGroup());
            eventB.addEvent(event);
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Evento creado", "El evento ha sido añadido correctamente"));
        }
        catch (Exception e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
        }
    }
    
    public void removeEvent(Event e) {
        eventB.removeEvent(e);
    }
        
    public void editEvent() {
        try {
            event = new Event();
            event.setId(id);
            event.setName(name);
            event.setDate(date);
            event.setGroupscout(groupB.getGroupScoutById(group_id));
            event.setDescription(description);
            eventB.modifyEvent(event);
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Evento modificado", "El evento ha sido modificado correctamente"));
        }
        catch (Exception e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
        }
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the group
     */
    public Group_Scout getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group_Scout group) {
        this.group = group;
    }

    /**
     * @return the group_id
     */
    public Long getGroup_id() {
        return group_id;
    }

    /**
     * @param group_id the group_id to set
     */
    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}
