package uma.sii.mcaddss.webscouts.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import uma.sii.mcaddss.webscouts.entities.Comment;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;

/**
 *
 * @author Carles Bordas
 */
@Named(value = "eventPage")
@RequestScoped
public class EventPage implements Serializable {

    private final String eventId;
    private Event event;

    public EventPage() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        eventId = params.get("id");
        
        // TODO get Event from List of Events
    }

    public String getEventName() {
        return event.getName();
    }

    public String getEventDescription() {
        return event.getDescription();
    }

    public List<Comment> getEventComments() {
        return event.getComments();
    }

    public String getEventDateFormatted(String format) {
        SimpleDateFormat formatter;
        try {
            formatter = new SimpleDateFormat(format);
        } catch (Exception e) {
            formatter = new SimpleDateFormat("dd.MM.yyyy a las HH:mm");
        }
        Date eventDate = event.getDate();
        return formatter.format(eventDate);
    }

    public List<Document> getNecessaryDocuments() {
        return event.getDocuments();
    }

    public boolean isEnroled() {
        /// TODO
        return false;
    }

}
