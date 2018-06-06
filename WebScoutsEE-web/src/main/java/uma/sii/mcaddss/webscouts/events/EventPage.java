package uma.sii.mcaddss.webscouts.events;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
import uma.sii.mcaddss.webscouts.bean.EventLocal;
import uma.sii.mcaddss.webscouts.data.Data;
import uma.sii.mcaddss.webscouts.entities.Comment;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.EventAttendance;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Carles Bordas
 */
@Named(value = "eventPage")
@RequestScoped
public class EventPage implements Serializable {
    
    @EJB
    private EventLocal eventB;
    @Inject
    private PrivilegesControl ctrl;
    private Long event_id;
    
    private Event event;

    public EventPage() {
        
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event e) {
        this.event = e;
    }

    /**
     * @return the event_id
     */
    public Long getEventId() {
        return event_id;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEventId(Long event_id) {
        this.event_id = event_id;
        event = getEventById(event_id);
    }
    
    public Event getEventById(Long l) {
        return eventB.getEventById(l);
    }
    
    public String showAttendees() {
        return "event_attendees.xhtml";
    }
    
    public String renderPage(Event e) {
        setEvent(e);
        return "event.xhtml";
    }
    
    public EventAttendance getAttendance() {
        return eventB.findAttendance(ctrl.getUserScout(), event);
    }
    
    public void setAttendance(String attendanceStatus) throws IOException {
        EventAttendance ea = new EventAttendance();
        User_Scout user = ctrl.getUserScout();
        ea.setAttendanceStatus(attendanceStatus);
        ea.setEvent(event);
        ea.setUser(user);
        eventB.addAttendance(ea);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/faces/event.xhtml");
    }

    public boolean isEnroled() {
        /// TODO
        return false;
    }

    /* Comments */ 
    
}
