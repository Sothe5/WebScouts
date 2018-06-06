package uma.sii.mcaddss.webscouts.files;

import java.io.IOException;
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
import javax.inject.Inject;
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
	
        @Inject
        private PrivilegesControl ctr;
        
        @PersistenceContext(unitName = "WebScoutsEEPU")
        private EntityManager em;
        
        @EJB
        private Document_ManagementLocal document_manager;
    
    
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
  
    public void upload() throws Exception { 
         if(file == null ){
            System.out.println("-------------------> File is null!!");
            return;
        }
        Document doc = new Document(file.getFileName(),false,"Document");
        doc.setOwner(ctr.getUserScout());
        doc.setFile_size(file.getSize());
        doc.setFilepath("C:\\Users\\Nexel\\Documents\\NetBeansProjects\\Webscouts_carles\\WebScoutsEE-web\\src\\main\\webapp\\resources");
       
        saveLocal(file);

        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
  
    public void handleFileUpload(FileUploadEvent event) throws Exception { 
        file = event.getFile();
        Document doc = new Document(file.getFileName(),false,"Document");
        doc.setOwner(ctr.getUserScout());
        if(ctr.getUserScout() == null) {
            System.out.println("------------------> User is null!");
        }
        doc.setFile_size(file.getSize());
        String path = saveLocal(file);
        doc.setFilepath(path);
        document_manager.addDocument(doc);
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }    
    
    public String saveLocal(UploadedFile file) throws IOException {
        try {
            Files.createDirectory(Paths.get("C:\\Users\\Nexel\\Documents\\NetBeansProjects\\Webscouts_carles\\WebScoutsEE-web\\src\\main\\webapp\\resources"));
        } catch (Exception e) {
        
        }
        
        Path dir = Paths.get("C:\\Users\\Nexel\\Documents\\NetBeansProjects\\Webscouts_carles\\WebScoutsEE-web\\src\\main\\webapp\\resources");
        Path fileToCreatePath = dir.resolve(file.getFileName());
        System.out.println("File to create path: " + fileToCreatePath);
        Path newFilePath = Files.createFile(fileToCreatePath);
        System.out.println("New file created: " + newFilePath);
        System.out.println("New File exits: " + Files.exists(newFilePath));

        
        
        try (InputStream input = file.getInputstream()) {
            Files.copy(input, newFilePath, StandardCopyOption.REPLACE_EXISTING);
        }
        
        System.out.println("Uploaded file successfully saved in " + newFilePath);
        System.out.println(newFilePath.toAbsolutePath().toString());
        return "resources\\" + file.getFileName();

    }
    
}