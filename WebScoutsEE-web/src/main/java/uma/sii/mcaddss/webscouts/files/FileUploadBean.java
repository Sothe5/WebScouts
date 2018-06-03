package uma.sii.mcaddss.webscouts.files;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.ejb.EJB;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.event.FileUploadEvent;
 
import org.primefaces.model.UploadedFile;
import uma.sii.mcaddss.webscouts.bean.Document_ManagementLocal;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
 
@ManagedBean(name = "fileUploadBean")
@ViewScoped
public class FileUploadBean implements Serializable{
	
	private static final long serialVersionUID = 4352236420460919694L;
	
	private UploadedFile file;  
        
        private PrivilegesControl ctr;
        
        @PersistenceContext(unitName = "WebScoutsEEPU")
        private EntityManager em;
        
        @EJB
        private Document_ManagementLocal document_manager;
    
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() throws Exception { 
        Document doc = new Document(file.getFileName(),false,"Document");
        doc.setOwner(ctr.getUserScout());
        doc.setFile_size(file.getSize());
        doc.setFilepath("/resources");
        Path folder = Paths.get("/resources");
        String filename = file.getFileName(); 
        Path filePath = Files.createTempFile(folder, filename, "");
        
        try (InputStream input = file.getInputstream()) {
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        
        System.out.println("Uploaded file successfully saved in " + filePath);

        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
  
    public void handleFileUpload(FileUploadEvent event) throws Exception { 
        Document doc = new Document(file.getFileName(),false,"Document");
        doc.setOwner(ctr.getUserScout());
        doc.setFile_size(file.getSize());
        doc.setFilepath("\\resources");
        file.write("\\resources");
        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }    
    
}