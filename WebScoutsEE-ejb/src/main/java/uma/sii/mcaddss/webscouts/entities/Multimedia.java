package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/*
Represents a multimedia file of the database.
It has associated a file path where the element is, a name and an extension
It also is associated with the entity Events throw an one direction one-to-many 
relation from the Event to it.
*/
/**
 *
 * @author Nexel
 */
@Entity
@Table(name = "MULTIMEDIA")
public class Multimedia implements Serializable {

    @ManyToOne
    private Group_Scout group_Scout;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(nullable = false)
    private String file_path;
    @OneToOne
    @JoinColumn(name = "owner_fk")
    private User_Scout owner;
    @Column(nullable = false)
    private String name;
    private String extension;
    private String type;
    private Long file_size;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creation_date;
    @ManyToMany(mappedBy = "multimedia")
    private List<Event> events;
    
    public Multimedia (){
    }
    
    public Multimedia (String filepath, String name, String extension) {
        this.file_path = filepath;
        this.name = name;
        this.extension = extension;
        this.creation_date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    /**
     * @return the owner
     */
    public User_Scout getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(User_Scout owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * @return the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(List<Event> events) {
        this.events = events;
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
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uma.sii.mcaddss.webscouts.MULTIMEDIA[ id=" + id + " ]";
    }
    
}
