package uma.sii.mcaddss.webscouts.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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

    private Data data;
    private int eventId;
    private Event event;

    public EventPage() {
        data = new Data();
        this.event = data.getEvent();
    }
    
    public Event getEvent() {
        return event;
    }
    
    public String showAttendees() {
        return "event_attendees.xhtml";
    }
    
    public void setEventId(String eventId) {
        this.eventId = Integer.parseInt(eventId);
    }

    public String getEventName() {
        return event.getName();
    }

    public String getEventDescription() {
        return event.getDescription();
    }
    
    public Group_Scout getEventGroup() {
        return event.getGroupscout();
    }

    public List<Comment> getEventComments() {
        return event.getComments();
    }

    public String getEventDateFormatted() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("dd 'de' MMM ' de' yyyy, HH:mm");
        Date eventDate = event.getDate();
        return formatter.format(eventDate);
    }

    public List<Document> getNecessaryDocuments() {
        return event.getDocuments();
    }
    
    public List<EventAttendance> getEventAttendees() {
        return event.getAttendees();
    }
    
    public void markAssistence() {
        EventAttendance ea = new EventAttendance();
        ea.setAttendanceStatus("YES");
        ea.setEvent(event);
        //ea.setUser(user); // Get current user
        event.getAttendees().add(ea);
    }
    
    public void markNoAssistence() {
        EventAttendance ea = new EventAttendance();
        ea.setAttendanceStatus("NO");
        ea.setEvent(event);
        //ea.setUser(user); // Get current user
        event.getAttendees().add(ea);
    }

    public boolean isEnroled() {
        /// TODO
        return false;
    }

    /* Comments */ 
    
}
