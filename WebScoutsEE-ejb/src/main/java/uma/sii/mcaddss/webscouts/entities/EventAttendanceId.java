package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 * Embeddable class for the EventAttendance composite ID.
 * @author kiwinut
 */
@Embeddable
public class EventAttendanceId implements Serializable {

    private Long event_id;
    private Long user_id;
    
    public EventAttendanceId() {
        
    }
    
    public EventAttendanceId(Long event_id, Long user_id) {
        this.event_id = event_id;
        this.user_id = user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(event_id, user_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        EventAttendanceId that = (EventAttendanceId) o;
        return Objects.equals(event_id, that.event_id) && 
               Objects.equals(user_id, that.user_id);
    }

    @Override
    public String toString() {
        return "uma.sii.mcaddss.webscouts.EventAttendanceId[ event_id=" + event_id + ", user_id=" + user_id + " ]";
    }
    
}
