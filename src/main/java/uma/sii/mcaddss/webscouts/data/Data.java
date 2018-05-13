/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uma.sii.mcaddss.webscouts.entities.Comment;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.EventAttendance;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Multimedia;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "data")
@Dependent
public class Data {
    
    private Event event;
    private ArrayList<User_Scout> usuarios = new ArrayList<>
        (Arrays.asList(new User_Scout(new Long(1),"Manolo",new Group_Scout("Manada"),"manolo","manolo@gmail.com","Calle manolos", new Date(1997, 1, 2), new Role_Scout("EDUCANDO"),new ArrayList<>(Arrays.asList(new Document("Manolo_doc1",true,"Formulario"),new Document("Manolo_doc2", false,"Formulario"))))
                , new User_Scout(new Long(2),"Pepe",new Group_Scout("Castor"),"pepe","pepe@gmail.com","Calle pepes", new Date(1997, 1, 1), new Role_Scout("EDUCANDO"),new ArrayList<>(Arrays.asList(new Document("Pepe_doc",false,"Formulario"))))
                , new User_Scout(new Long(5), "unscouter",new Group_Scout("Castor"),"wan", "wan@gmail.com", "Wan Street", new Date(1999, 9, 9), new Role_Scout("SCOUTER"))
                , new User_Scout(new Long(7),"soiadmin",null,"soi", "soi@gmail.com", "Calle de los admin", new Date(1995, 5, 5), new Role_Scout("ADMIN"))));

    /**
     * Creates a new instance of Data
     */
    public Data() {
        event = new Event();
        event.setName("Salida a los montes de Málaga");
        event.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus ex massa, id commodo mi gravida non. Proin eu sapien vitae ligula malesuada ultricies. Nullam et suscipit sem, eu porttitor ex. Morbi porttitor faucibus leo vel tempor. Aliquam et euismod purus, sed porttitor enim. Praesent egestas est eu varius tempus. Praesent varius felis diam, sed hendrerit mauris ultricies sit amet. Fusce interdum elit a nisl aliquam fermentum.\n" +
"\n" +
"                    Quisque non enim eros. Integer fringilla, dolor a luctus feugiat, quam nisi pellentesque nibh, et congue arcu ligula sodales arcu. Praesent sem arcu, viverra tristique felis at, tempor pretium sem. Suspendisse potenti. Aenean ornare vehicula diam. Phasellus cursus scelerisque quam, in ultricies dui dictum vehicula. Sed gravida consectetur turpis, at ullamcorper urna pulvinar. ");
        event.setGroupscout(new Group_Scout());
        event.getGroupscout().setName("Manada");
        event.setDate(new Date());
        
        // Build users for event and comments:
        User_Scout pablo = new User_Scout(new Long(9), "pablo", event.getGroupscout(), "pablo", "test@test.com", "test aa", new Date(2002,11,21), new Role_Scout("EDUCANDO"));
        User_Scout manuel = new User_Scout(new Long(14), "manuel", event.getGroupscout(), "manuel", "test2@test.com", "test aa", new Date(2004,10,21), new Role_Scout("EDUCANDO"));
        User_Scout rosa = new User_Scout(new Long(14), "rosa", event.getGroupscout(), "rosa", "test7@test.com", "test aa", new Date(2001,6,21), new Role_Scout("EDUCANDO"));
        User_Scout elisa = new User_Scout(new Long(55), "elisa", event.getGroupscout(), "elisa", "test3@test.com", "test aa oo", new Date(2006,9,14), new Role_Scout("EDUCANDO"));
        usuarios.add(elisa);
        usuarios.add(manuel);
        usuarios.add(pablo);
        usuarios.add(rosa);
       
        // Add attendants
        event.addAttendee(new EventAttendance(event, pablo, "yes"));
        event.addAttendee(new EventAttendance(event, elisa, "yes"));
        event.addAttendee(new EventAttendance(event, manuel, "yes"));
        
        // Build comments
        Comment comment1 = new Comment(pablo, event, "Hola a todos, yo podré ir");
        Comment comment2 = new Comment(manuel, event, "Vale");
        Comment comment3 = new Comment(elisa, event, "Aaaa bieeen");
        comment2.setTarget(comment1);
        comment1.addReply(comment2);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        event.setComments(commentList);
    }

    public ArrayList<User_Scout> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<User_Scout> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }
    
}
