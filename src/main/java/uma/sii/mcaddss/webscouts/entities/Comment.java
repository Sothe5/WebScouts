package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This entity represents a specific comment made by a user on an event.
 * A comment has been made by a specific user over a specific event. A comment
 * can be a response of another comment in the same event.
 * 
 * @author Carles Bordas
 */
@Entity
@Table(name = "COMMENTS")
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
    @OneToMany(mappedBy = "target")
    private List<Comment> responses;
    @ManyToOne
    private Comment target;

    public Comment() {
        
    }
    
    public Comment(User_Scout user, Event event, String message) {
        this.user = user;
        this.event = event;
        this.message = message;
        this.postDate = new Date();
        this.lastModify = this.postDate;
        this.responses = new ArrayList();
    }
    
    /**
     * 
     * @return id of the comment
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @return user who commented the event
     */
    public User_Scout getUser() {
        return user;
    }

    /**
     * 
     * @return body of the comment
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
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
    
    public Date getLastModify() {
        return lastModify;
    }

    public List<Comment> getResponses() {
        return responses;
    }
    
    public void addReply(Comment replyComment) {
        responses.add(replyComment);
    }
    
    public Comment getTarget() {
        return target;
    }

    public void setTarget(Comment target) {
        this.target = target;
    }
    
    public String getCommentDateFormatted() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("dd 'de' MMM ' de' yyyy, HH:mm");
        Date eventDate = event.getDate();
        return formatter.format(eventDate);
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
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
