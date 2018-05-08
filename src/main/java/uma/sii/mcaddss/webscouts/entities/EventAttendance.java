package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Represents the attendance of a user to a specific event.
 * Fulfills the requirement: "Gestión de pagos de inscripciones de eventos"
 * @author kiwinut
 */
@Entity
@Table(name="EVENT_ATTENDANCE")
public class EventAttendance implements Serializable {

    @EmbeddedId
    private EventAttendanceId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("event_id")
    private Event event;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    private User_Scout user;
    
    @Column(nullable = false, length = 16)
    private String attendance_status; // yes, no, no_answer
    
    public EventAttendance() {
        
    }
    
    private EventAttendance(Event event, User_Scout user) {
        this.event = event;
        this.user = user;
        this.id = new EventAttendanceId(event.getId(), user.getId());
    }
    
    public EventAttendanceId getId() {
        return id;
    }

    public void setId(EventAttendanceId id) {
        this.id = id;
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
     * @return the user
     */
    public User_Scout getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User_Scout user) {
        this.user = user;
    }

    /**
     * @return the attendance_status
     */
    public String getAttendanceStatus() {
        return attendance_status;
    }

    /**
     * @param attendance_status the attendance_status to set
     */
    public void setAttendanceStatus(String attendance_status) {
        this.attendance_status = attendance_status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        EventAttendance that = (EventAttendance) o;
        return Objects.equals(event, that.event) &&
               Objects.equals(user, that.user);
    }

    @Override
    public String toString() {
        return "uma.sii.mcaddss.webscouts.EventAttendance[ event_id=" + event + ", user_id=" + user + " ]";
    }
    
}
