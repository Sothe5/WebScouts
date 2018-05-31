package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
It represent all the users of the database.
It has associated a role, which provides it with the proper privileges.
Also, it has a Group to which it belongs, as well as the events the belongs to
and the documents and the photo it has associated.
*/
/**
 *
 * @author Nexel
 */
@Entity
@Table(name = "USERS")
public class User_Scout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true,nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String password;
    private Date pledge_date;
    private String address;
    private String email;
    private String civil_status;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthdate;
    @ManyToOne
    private Group_Scout groupscout;
    @ManyToOne
    private Role_Scout role; 
    @OneToOne
    private Multimedia photo;
    @OneToMany(mappedBy = "owner")
    private List<Document> documents;
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<EventAttendance> events;
    @ManyToOne
    private Fee fee;

    public User_Scout() {
    }

    public User_Scout(Long id, String user_name, Group_Scout groupscout, String password, String email, String address, Date birthdate, Role_Scout role) {
        this.id = id;
        this.user_name = user_name;
        this.groupscout = groupscout;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.role = role;
        this.documents = new ArrayList<>();
    }

    public User_Scout(Long id, String user_name, Group_Scout groupscout, String password, Date pledge_date, String email, String address, Date birthdate, Role_Scout role, List<Document> documents) {
        this.id = id;
        this.user_name = user_name;
        this.groupscout = groupscout;
        this.password = password;
        this.pledge_date = pledge_date;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.role = role;
        this.documents = documents;
    }
    
    public User_Scout(Long id, String user_name, Group_Scout groupscout, String password, Date pledge_date, String email, String address, Date birthdate, Multimedia photo, Role_Scout role, List<Document> documents) {
        this(id, user_name, groupscout, password, pledge_date, email, address, birthdate, role, documents);
        this.photo = photo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String surname) {
        this.first_name = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getPledgeDate(){
        return pledge_date;
    }
    
    public void setPledgeDate(Date pledge_date){
        this.pledge_date = pledge_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setRole(Role_Scout role) {
        this.role = role;
    }

    /**
     * @return the photo
     */
    public Multimedia getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(Multimedia photo) {
        this.photo = photo;
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

    /**
     * @return the events
     */
    public List<EventAttendance> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(List<EventAttendance> events) {
        this.events = events;
    }
    
    public int getAge() {
        LocalDate bd = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        return Period.between(bd, now).getYears();
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
        if (!(object instanceof User_Scout )) {
            return false;
        }
        User_Scout  other = (User_Scout ) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webscouts.Usuario[" + getUser_name() + " identificado por número de id " + id +" (" + first_name + " " + getLast_name() +")]";
    }
    
    public String getPledgeDateFormatted() {
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        return formatter.format(pledge_date);
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the civil_status
     */
    public String getCivil_status() {
        return civil_status;
    }

    /**
     * @param civil_status the civil_status to set
     */
    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
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
     * @return the role
     */
    public Role_Scout getRole() {
        return role;
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
}
