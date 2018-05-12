package uma.sii.mcaddss.webscouts.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.entities.Comment;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.EventAttendance;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Carles Bordas
 */
@Named(value = "eventPage")
@RequestScoped
public class EventPage implements Serializable {

    private int eventId;
    private Event event;

    public EventPage() {
        event = new Event();
        event.setName("Salida a los montes de Málaga");
        event.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus ex massa, id commodo mi gravida non. Proin eu sapien vitae ligula malesuada ultricies. Nullam et suscipit sem, eu porttitor ex. Morbi porttitor faucibus leo vel tempor. Aliquam et euismod purus, sed porttitor enim. Praesent egestas est eu varius tempus. Praesent varius felis diam, sed hendrerit mauris ultricies sit amet. Fusce interdum elit a nisl aliquam fermentum.\n" +
"\n" +
"                    Quisque non enim eros. Integer fringilla, dolor a luctus feugiat, quam nisi pellentesque nibh, et congue arcu ligula sodales arcu. Praesent sem arcu, viverra tristique felis at, tempor pretium sem. Suspendisse potenti. Aenean ornare vehicula diam. Phasellus cursus scelerisque quam, in ultricies dui dictum vehicula. Sed gravida consectetur turpis, at ullamcorper urna pulvinar. ");
        event.setGroupscout(new Group_Scout());
        event.getGroupscout().setName("Manada");
        event.setDate(new Date());
        
        // Build users for comments:
        User_Scout pablo = new User_Scout(Long.MIN_VALUE, "pablo", event.getGroupscout(), "pablo", "test@test.com", "test aa", new Date(2002,11,21));
        User_Scout manuel = new User_Scout(Long.MIN_VALUE, "manuel", event.getGroupscout(), "manuel", "test2@test.com", "test aa", new Date(2004,10,21));
        User_Scout elisa = new User_Scout(Long.MIN_VALUE, "elisa", event.getGroupscout(), "elisa", "test3@test.com", "test aa oo", new Date(2006,9,14));
        
        // Build comments
        Comment comment1 = new Comment(pablo, event, "Hola a todos, yo no podré ir");
        Comment comment2 = new Comment(manuel, event, "Vale");
        Comment comment3 = new Comment(elisa, event, "Aaaa bieeen");
        comment2.setTarget(comment1);
        comment1.addReply(comment2);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        event.setComments(commentList);
    }
    
    public Event getEvent() {
        return event;
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
        formatter = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
        Date eventDate = event.getDate();
        return formatter.format(eventDate);
    }

    public List<Document> getNecessaryDocuments() {
        return event.getDocuments();
    }
    
    public List<EventAttendance> getEventAttendees() {
        return event.getAttendees();
    }
    
    public int getAtendeesCount() {
        return event.getAttendees().size();
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
