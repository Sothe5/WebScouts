package uma.sii.mcaddss.webscouts.converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Carles Bordas
 */
@ManagedBean
public class GroupConverter implements Converter{

    @EJB
    private Group_ManagerLocal gm;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (Group_Scout g : gm.getAllGroups()) {
            if (g.getName().equals(value)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Group_Scout) value).getName();
    }
}

