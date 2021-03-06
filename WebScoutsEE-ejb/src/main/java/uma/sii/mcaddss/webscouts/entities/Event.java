package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a meet-up event.
 * Provides a basis for the Event System and the following requirements:
 * > Registrarse en un evento
 * > CRUD Eventos
 * > Gestión de eventos
 * > Generar Excel de asistencia a eventos
 * @author Alvaro
 */
@Entity
@Table(name = "EVENTS")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String category;
    @Column
    @Lob
    private String description;
    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList();
    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL)
    private List<EventAttendance> attendees = new ArrayList();
    @ManyToOne
    @JoinColumn(name="GROUP_ID", nullable = false)
    private Group_Scout groupscout;
    @ManyToMany
    @JoinTable(name = "event_multimedia",
            joinColumns = @JoinColumn(name="event_fk"),
            inverseJoinColumns = @JoinColumn(name="multimedia_fk"))
    private List<Multimedia> multimedia = new ArrayList();
    @OneToMany(mappedBy = "event",
            cascade = CascadeType.PERSIST)
    private List<Document> documents = new ArrayList();

    public Event() {
        
    }
    
    public Event(String name, String description, Date date, String category) {
        this();
        this.name = name;
        this.description = description;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("dd 'de' MMM ' de' yyyy, HH:mm");
        return formatter.format(date);
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }
    
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the attendees
     */
    public List<EventAttendance> getAttendees() {
        return attendees;
    }
    
    public int getAttendeesCount() {
        return this.getAttendees().size();
    }

    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(List<EventAttendance> attendees) {
        this.attendees = attendees;
    }

    public void addAttendee(EventAttendance attendee) {
        this.attendees.add(attendee);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Events[ id=" + id + "Event(" + name + ", " + category + ", " + date + ") ]";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the groupscout
     */
    public Group_Scout getGroupscout() {
        return groupscout;
    }

    /**
     * @param groupscout the groupscout to set
     */
    public void setGroupscout(Group_Scout groupscout) {
        this.groupscout = groupscout;
    }

    /**
     * @return the multimedia
     */
    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    /**
     * @param multimedia the multimedia to set
     */
    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
