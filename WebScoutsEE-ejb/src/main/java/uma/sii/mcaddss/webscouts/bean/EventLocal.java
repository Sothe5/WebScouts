/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Event;

/**
 *
 * @author cloud
 */
@Local
public interface EventLocal {

    void addEvents(List<Event> events);

    void addEvent(Event event);
    
}
