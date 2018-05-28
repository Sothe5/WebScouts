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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
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
    /**
     * Creates a new instance of Groups
     */
    public Groups() {  
       // chooseGroup("Tropa"); // esta sentencia es la del action en el navbar (la que deberia estar)
    }
    
    public String chooseGroup(String name){ 
        group = choose(name); 
   /*   HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      String url = request.getRequestURI();
       if(url.equals("http://localhost:8080/WebScouts/faces/group.xhtml")){
           return null;
       }*/
        return "/faces/group.xhtml";
    }
    
    public void setGroupName(String s){
      group.setName(s);
    }
    
    public String getGroupName(){
        return group.getName();
    }
    
    public String getDescription(){
        return group.getDescription();
    }
    
    public List<Event> getGroupEvents(){
        return group.getEvents();
    }
    
    private Group_Scout choose(String name){
        Group_Scout gr = new Group_Scout();
        List<Event> a = new ArrayList<>();
        Event b = new Event();
        Event c = new Event();
        switch (name){
            case "Castores":
                gr.setName("Castores");
                gr.setDescription("This is a great group.");
                
                
                b.setName("Acampada");
                b.setDate(new Date());
                b.setDescription("Vamos al monte a pasar la noche");

                c.setName("Acuario");
                c.setDate(new Date());
                c.setDescription("Vamos a descubrir el mundo marino");
                a.add(b);
                a.add(c);
                gr.setEvents(a);
                break;
            case "Manada":
                gr.setName("Manada");
                gr.setDescription("Not too bad as a group");

                b.setName("Parque");
                b.setDate(new Date());
                b.setDescription("Vamos al parque");
                
                a.add(b);
                gr.setEvents(a);
                break;
            case "Tropa":
                 gr.setName("Tropa");
                gr.setDescription("un, dos, tres, cuatro.");
                
                b.setName("Acampada");
                b.setDate(new Date());
                b.setDescription("Vamos al monte a pasar la noche");

                c.setName("Acuario");
                c.setDate(new Date());
                c.setDescription("Vamos a descubrir el mundo marino");
                a.add(b);
                a.add(c);
                gr.setEvents(a);
                break;
            case "Unidad":
                gr.setName("Unidad");
                gr.setDescription("Scouters unidos jamas seran vencidos");

                b.setName("Parque");
                b.setDate(new Date());
                b.setDescription("Vamos al parque");
                
                a.add(b);
                gr.setEvents(a);
                break;
            case "Clan":
                gr.setName("Clan");
                gr.setDescription("Tenemos un canal de TV");

                b.setName("Parque");
                b.setDate(new Date());
                b.setDescription("Vamos al parque");
                
                a.add(b);
                gr.setEvents(a);
                break;
            default:
                gr.setName("Er");
                gr.setDescription("This is a great group.");
                
                
                b.setName("Acampada");
                b.setDate(new Date());
                b.setDescription("Vamos al monte a pasar la noche");

                c.setName("Acuario");
                c.setDate(new Date());
                c.setDescription("Vamos a descubrir el mundo marino");
                a.add(b);
                a.add(c);
                gr.setEvents(a);
                break;
            } 
        return gr;
        }
    
    
    }
