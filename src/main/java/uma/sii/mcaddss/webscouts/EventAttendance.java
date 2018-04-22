/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author kiwinut
 */
@Entity
public class EventAttendance implements Serializable {

    @EmbeddedId
    private EventAttendanceId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("event_id")
    private Event event;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    private User_Scout user;

    private Boolean paid;
    
    public EventAttendance() {
        
    }
    
    private EventAttendance(Event event, User_Scout user, Boolean paid) {
        this.event = event;
        this.user = user;
        this.paid = paid;
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
     * @return the paid
     */
    public Boolean getPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(Boolean paid) {
        this.paid = paid;
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
