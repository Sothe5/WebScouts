/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author cloud
 */
@Local
public interface EventLocal {

    void addEvent(Event event);
    void addEvents(List<Event> events);
    List<Event> getGroupEvents(Group_Scout g);
    public List<Event> getAllEvents();
    void modifyEvent(Event event);
    
}
