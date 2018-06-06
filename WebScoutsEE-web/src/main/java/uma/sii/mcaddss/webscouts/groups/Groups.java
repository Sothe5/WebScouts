package uma.sii.mcaddss.webscouts.groups;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Alvaro
 */
@Named(value = "groups")
@RequestScoped
public class Groups {
    @EJB
    private Group_ManagerLocal group_manager;
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

        switch (name){
            case "Castores":
                gr.setName("Castores");
                gr.setDescription(group_manager.getDescription(name)); 
                gr.setEvents(group_manager.getEvents(name));
            
                break;
            case "Manada":
                gr.setName("Manada");
                gr.setDescription(group_manager.getDescription(name)); 
                gr.setEvents(group_manager.getEvents(name));
                break;
            case "Tropa":
                 gr.setName("Tropa");
                 gr.setDescription(group_manager.getDescription(name)); 
                
                gr.setEvents(group_manager.getEvents(name));
                break;
            case "Unidad":
                gr.setName("Unidad");
                gr.setDescription(group_manager.getDescription(name)); 

               gr.setEvents(group_manager.getEvents(name));
                break;
            case "Clan":
                gr.setName("Clan");
                gr.setDescription(group_manager.getDescription(name)); 

              gr.setEvents(group_manager.getEvents(name));
                break;
            case "Scouters":
                gr.setName("Scouters");
                gr.setDescription(group_manager.getDescription(name)); 

              gr.setEvents(group_manager.getEvents(name));
                break;
            default:
                gr.setName("Er");
                gr.setDescription(group_manager.getDescription(name)); 
                
              gr.setEvents(group_manager.getEvents(name));
                break;
            } 
        return gr;
        }
    
    
    }
