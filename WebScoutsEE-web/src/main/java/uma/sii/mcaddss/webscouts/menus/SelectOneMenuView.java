package uma.sii.mcaddss.webscouts.menus;


import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import uma.sii.mcaddss.webscouts.bean.Document_ManagementLocal;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
 
@ManagedBean(name = "selectOneMenuView")
@ViewScoped
public class SelectOneMenuView {
    
    @EJB
    private Document_ManagementLocal doc_manager;
    
    private String status = "Todos";

    public int getNumberDocuments(User_Scout user) {
        return doc_manager.getNumberDocuments(user, status);
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