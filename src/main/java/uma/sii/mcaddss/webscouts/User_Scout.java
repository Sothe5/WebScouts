/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
    private String surname;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String password;
    private String address;
    private String email;
    private String civil_status;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthdate;
    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    private Group_Scout groupscout;
    @ManyToOne
    private Role_Scout role; 
    @OneToOne
    private Multimedia photo;
    @OneToMany(mappedBy = "owner")
    @ElementCollection
    private List<Document> documents;
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    @ElementCollection
    private List<EventAttendance> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCivilStatus() {
        return civil_status;
    }

    public void setCivilStatus(String civil_status) {
        this.civil_status = civil_status;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Role_Scout getRoles() {
        return role;
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
    
    public boolean hasPrivileges(Set<Privilege> privileges) {
        return role.getPermissions().containsAll(privileges);
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
        return "webscouts.Usuario[" + user_name + " identificado por número de id " + id +" (" + surname + " " + last_name +")]";
    }
}
