package uma.sii.mcaddss.webscouts.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a document uploaded by a user.
 * It's the basis for the Document Management System and the following requirements:
 * > Gestión documental (General)
 * > Gestión documental para Scouters
 * > Consultar estado de documentación
 * > Cambiar estado de documento
 * > Subir documento
 * @author kiwinut
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
@Table(name="DOCUMENTS")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable=false, unique = true)
    private String filepath;
    private String name;
    private String type;
    @Column(nullable=false, unique=false)
    private boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date upload_date;
    @Column(nullable=false)
    private Long file_size;
    private String status;
    @ManyToOne
    @JoinColumn(name="OWNER_ID", nullable=false)
    private User_Scout owner;

    public Document() {
        
    }
    
    public Document(String name, Long file_size, String status, String type) {
        this.name = name;
        this.file_size = file_size;
        this.status = status;
        this.type = type;
        this.upload_date= new Date();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the filename
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath the filename to set
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the upload_date
     */
    public Date getUploadDate() {
        return upload_date;
    }

    /**
     * @param upload_date the upload_date to set
     */
    public void setUploadDate(Date upload_date) {
        this.upload_date = upload_date;
    }

    /**
     * @return the file_size
     */
    public Long getFileSize() {
        return file_size;
    }

    /**
     * @param file_size the file_size to set
     */
    public void setFileSize(Long file_size) {
        this.file_size = file_size;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documento con identificador " + id + " de tipo " + getType();
    }
    
}
