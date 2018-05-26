/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.groups;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Alvaro
 */
@Named(value = "groups")
@RequestScoped
public class Groups {

    private Group_Scout group;
    private String Description;
    /**
     * Creates a new instance of Groups
     */
    public Groups() {
        group = new Group_Scout();
        group.setName("Castores");
        Description = "This is a great group.";
        List<Event> a = new ArrayList<Event>();
       
        Event b = new Event();
        b.setName("Acampada");
        b.setDate(new Date());
        b.setDescription("Vamos al monte a pasar la noche");
        
        Event c = new Event();
        c.setName("Acuario");
        c.setDate(new Date());
        c.setDescription("Vamos a descubrir el mundo marino");
        a.add(b);
        a.add(c);
        group.setEvents(a);
    }
    
    public void setGroupName(String s){
      group.setName(s);
    }
    
    public String getGroupName(){
        return group.getName();
    }
    
    public String getDescription(){
        return Description;
    }
    
    public List<Event> getGroupEvents(){
        return group.getEvents();
    }
    
}
