package uma.sii.mcaddss.webscouts.files;

import java.io.Serializable;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
 
import org.primefaces.model.UploadedFile;
 
@ManagedBean
@ViewScoped
public class FileUploadBean implements Serializable{
	
	private static final long serialVersionUID = 4352236420460919694L;
	
	private UploadedFile file;  
    
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() {  
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
  
    public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }    
    
}