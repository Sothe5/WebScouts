package uma.sii.mcaddss.webscouts.files;

import java.io.Serializable;
import javax.ejb.EJB;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
 
import org.primefaces.model.UploadedFile;
import uma.sii.mcaddss.webscouts.bean.Document_ManagementLocal;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.authentication.PrivilegesControl;
 
@ManagedBean
@ViewScoped
public class FileUploadBean implements Serializable{
	
	private static final long serialVersionUID = 4352236420460919694L;
	
	private UploadedFile file;  
        
        private PrivilegesControl ctr;
        
        @EJB
        private Document_ManagementLocal document_manager;
    
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() { 
        Document doc = new Document(file.getFileName(),false,file.getContentType());
        doc.setOwner(ctr.getUserScout());
        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
  
    public void handleFileUpload(FileUploadEvent event) { 
        Document doc = new Document(file.getFileName(),false,file.getContentType());
        doc.setOwner(ctr.getUserScout());
        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }    
    
}