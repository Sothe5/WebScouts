package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Controla los miembros de un grupo, los eventos que tienen pendientes 
 * y han tenido y la edad minima y máxima que pueden tener los miembros del grupo
 * @author Alvaro
 */
@Entity
@Table(name = "GROUPS")
public class Group_Scout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int maxAge;
    @Column(nullable = false)
    private int minAge;
    @OneToMany
    private Set<User_Scout> members;
    @OneToMany(mappedBy = "group_Scout")
    private List<Multimedia> multimediaContents;
    @OneToOne(fetch = FetchType.LAZY)
    private Fee fee;
    @OneToMany(mappedBy = "groupscout")
    private Set<Event> events;
    
    public Long getId() {
        return id;
    }
    
    public void addMember(User_Scout user){
        members.add(user);
    }
    
    public void removeMember(User_Scout user){
        members.remove(user);
    }
    
     public void addMultimedia(Multimedia multimedia){
        multimediaContents.add(multimedia);
    }
    
    public void deleteMultimedia(Multimedia multimedia){
        multimediaContents.remove(multimedia);
    }
    
     public void addEvent(Event event){
        events.add(event);
    }
    
    public void removeEvent(Event event){
        events.remove(event);
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
        if (!(object instanceof Group_Scout)) {
            return false;
        }
        Group_Scout other = (Group_Scout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Grupo[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge the maxAge to set
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
        checkAges(true);
    }

    /**
     * @return the minAge
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * @param minAge the minAge to set
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
        checkAges(true);
    }
    
    /**
     * @throws RuntimeException if param remove is set to false and there is
     * a member of the group whose age overpasses the specified max and min ages.
     * @param remove 
     * @return True if all members are in the age range, False otherwise.
     */
    private boolean checkAges(boolean remove) {
        Iterator<User_Scout> it = members.iterator();
        boolean correct = true;
        while (it.hasNext()) {
            User_Scout member = it.next();
            if (member.getAge() < minAge || member.getAge() > maxAge) {
                if (remove) it.remove();
                else throw new RuntimeException("Member " + member + " cannot be in group " + name+ " by age");
                correct = false;
            }
        }
        return correct;
    }

    /**
     * @return the members
     */
    public Set<User_Scout> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(Set<User_Scout> members) {
        this.members = members;
    }

    /**
     * @return the multimedia
     */
    public List<Multimedia> getMultimedia() {
        return multimediaContents;
    }

    /**
     * @param multimedia the multimedia to set
     */
    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimediaContents = multimedia;
    }

    /**
     * @return the fee
     */
    public Fee getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Fee fee) {
        this.fee = fee;
    }

    /**
     * @return the events
     */
    public Set<Event> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
    
}
