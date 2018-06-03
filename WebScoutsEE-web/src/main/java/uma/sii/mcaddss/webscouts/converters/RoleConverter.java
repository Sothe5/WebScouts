package uma.sii.mcaddss.webscouts.converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;

/**
 *
 * @author Carles Bordas
 */
@ManagedBean
public class RoleConverter implements Converter{

    @EJB
    private Role_ManagerLocal rm;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (Role_Scout r : rm.getAllRoles()) {
            if (r.getRoleName().equals(value)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Role_Scout) value).getRoleName();
    }
}

