package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
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
    private Double cost;
    private String category;
    @OneToMany(mappedBy = "event")
    private List<Comment> comments;
    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL)
    private List<EventAttendance> attendees;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="GROUP_ID", nullable = false)
    private Group_Scout groupscout;

    public Event() {
        
    }
    
    private Event(String name, Date date, Double cost, String category) {
        this.name = name;
        this.date = date;
        this.cost = cost;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(List<EventAttendance> attendees) {
        this.attendees = attendees;
    }

    public void createEvent(String nom, Date fe, Double co, String cat) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventData");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Event event = new Event(nom, fe, co, cat);

        tx.begin();
        em.persist(event);
        tx.commit();
        em.close();

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
        return "webscouts.Events[ id=" + id + "Event(" + name + ", " + category + ", " + date + ", " + cost + ") ]";
    }

}
