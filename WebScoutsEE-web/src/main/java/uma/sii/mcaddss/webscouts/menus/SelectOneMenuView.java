
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.ToggleEvent;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
 
@ManagedBean(name = "selectOneMenuView")
public class SelectOneMenuView {
    
    private String status = "Todos";

    public int getNumberDocuments(User_Scout user) {
        List<String> documents = new ArrayList<>();
        List<Document> documents_user = user.getDocuments();
        for(Document doc : documents_user){
            if(status != null){
                if(status.equals("Todos")){
                    documents.add(doc.getName());  
                }else{
                    if(status.equals(doc.getStatus() ? "Validado" : "Pendiente")){
                        documents.add(doc.getName());
                    }   
                }
            }
        }
        return documents.size();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SelectOneMenuView other = (SelectOneMenuView) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }  
}