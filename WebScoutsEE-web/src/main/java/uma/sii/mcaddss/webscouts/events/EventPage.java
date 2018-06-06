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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@SessionScoped
public class EventPage implements Serializable {
    
    @EJB
    private EventLocal eventB;
    @Inject
    private PrivilegesControl ctrl;
    
    private Event event;
    private String message;

    public EventPage() {
        
    }
    
    public void refreshEvent() {
        this.event = eventB.getEventById(event.getId());
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event e) {
        this.event = e;
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
    
    public String setAttendance(String attendanceStatus) throws IOException {
        EventAttendance ea = new EventAttendance();
        User_Scout user = ctrl.getUserScout();
        ea.setAttendanceStatus(attendanceStatus);
        ea.setEvent(event);
        ea.setUser(user);
        eventB.addAttendance(ea);
        refreshEvent();
        return "event.xhtml";
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String sendComment() {
        Comment comment = new Comment(ctrl.getUserScout(), event, message);
        eventB.addComment(comment);
        setMessage("");
        refreshEvent();
        return "event.xhtml";
    }
    
   /* public String deleteComment(Comment comment) {
        eventB.deleteComment(comment);
        refreshEvent();
        return "event.xhtml";
    }*/

    /* Comments */ 
    
}
