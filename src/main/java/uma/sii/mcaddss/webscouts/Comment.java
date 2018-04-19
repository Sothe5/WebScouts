package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carles Bordas
 */
@Entity
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User_Scout user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Event event;
    @Column(nullable = false, length = 2048)
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date postDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModify;

    public Comment() {
        
    }
    
    public Comment(User_Scout user, Event event, String message) {
        this.user = user;
        this.event = event;
        this.message = message;
        this.postDate = new Date();
    }
    
    public Long getId() {
        return id;
    }

    /**
     * @return user who commented the event
     */
    public User_Scout getUser() {
        return user;
    }

    /**
     * @return body of the comment
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message body of the comment
     */
    public void setMessage(String message) {
        this.message = message;
        lastModify = new Date();
    }

    /**
     * 
     * @return event that the comment refers to
     */
    public Event getEvent() {
        return event;
    }

    public Date getPostDate() {
        return postDate;
    }
    
    public Date getLastModifyDate() {
        return lastModify;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * 
     * @param object Object to compare to
     * @return True if both comments refer to the same event, where made by the 
     * same user and were posted on the exact same moment, False otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Comment)) return false;
        Comment other = (Comment) object;
        return this.event.equals(other.event) &&
               this.user.equals(other.user) &&
               this.postDate.equals(other.postDate);
    }

    /**
     * 
     * @return string representation of the comment, which contains the name of
     * the user who posted it, the event that it refers and the date it was
     * posted.
     */
    @Override
    public String toString() {
        return "user " + user + " comment on event " + event + ": " + this.message.substring(0, 32);
    }
    
}
