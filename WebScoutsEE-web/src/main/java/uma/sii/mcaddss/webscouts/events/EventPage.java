package uma.sii.mcaddss.webscouts.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
    
    private Event event;

    public EventPage() {
        
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event e) {
        this.event = e;
    }
    
    public String showAttendees(Event e) {
        setEvent(e);
        return "event_attendees.xhtml";
    }
    
    public String renderPage(Event e) {
        setEvent(e);
        return "event.xhtml";
    }
    
    public void markAssistence() {
        EventAttendance ea = new EventAttendance();
        ea.setAttendanceStatus("YES");
        ea.setEvent(event);
        //ea.setUser(user); // Get current user
        event.getAttendees().add(ea);
        eventB.modifyEvent(event);
    }
    
    public void markNoAssistence() {
        EventAttendance ea = new EventAttendance();
        ea.setAttendanceStatus("NO");
        ea.setEvent(event);
        //ea.setUser(user); // Get current user
        event.getAttendees().add(ea);
        eventB.modifyEvent(event);
    }

    public boolean isEnroled() {
        /// TODO
        return false;
    }

    /* Comments */ 
    
}
