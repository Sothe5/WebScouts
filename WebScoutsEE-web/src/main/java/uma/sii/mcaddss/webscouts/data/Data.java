/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uma.sii.mcaddss.webscouts.entities.Comment;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.EventAttendance;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.Multimedia;
import uma.sii.mcaddss.webscouts.entities.Role_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;
import uma.sii.mcaddss.webscouts.bean.CommentLocal;
import uma.sii.mcaddss.webscouts.bean.Document_ManagementLocal;
import uma.sii.mcaddss.webscouts.bean.EventLocal;
import uma.sii.mcaddss.webscouts.bean.Group_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.Role_ManagerLocal;
import uma.sii.mcaddss.webscouts.bean.UsersLocal;

/**
 *
 * @author Nexel
 */
@Named(value = "data")
@RequestScoped
public class Data {
    
    @EJB
    private CommentLocal commentB;
    @EJB
    private UsersLocal userB;
    @EJB
    private Group_ManagerLocal groupB;
    @EJB
    private EventLocal eventB;
    @EJB
    private Role_ManagerLocal roleB;
    @EJB
    private Document_ManagementLocal docB;
    
    private static final String FILE_PATH = "./resources/images/users";
    FacesContext ctx = FacesContext.getCurrentInstance();
    private List<Event> events = new ArrayList<>();
    private List<Comment> commentList = new ArrayList<>();
    private List<Document> documents = new ArrayList<>();
    private List<Group_Scout> groups = new ArrayList<>();    
    private ArrayList<User_Scout> usuarios = new ArrayList<>();
    
    /**
     * Creates a new instance of Data
     */
    public Data() {
        
    }

    public void initData() {
        // Build groups
        Group_Scout tropa = new Group_Scout("Tropa de Kim","Tropa de Kim",13,15);
        Group_Scout esculta = new Group_Scout("Unidad Esculta Siryu","Unidad Esculta Siryu",10,13);
        Group_Scout otro = new Group_Scout("Otro Grupo", "Otro Grupo",18,21);    
        Group_Scout manada = new Group_Scout("Manada","Grupo de manada",15,18);
        groups.add(tropa);
        groups.add(esculta);
        groups.add(otro);
        groups.add(manada);
        
        // Build roles
        Role_Scout admin = roleB.getRoleById(1L);
        Role_Scout scouter = roleB.getRoleById(2L);
        Role_Scout educando = roleB.getRoleById(3L);
        
        // Build users for event and comments:
        User_Scout manolo = new User_Scout(new Long(1),"Manolo",tropa,"manolo", "manolo", "gonzalez", new Date(2017, 9, 14),"manolo@gmail.com","Calle manolos", new Date(1997, 1, 2), educando);
        User_Scout pepe = new User_Scout(new Long(2),"Pepe",esculta,"pepe", "pepe", "gutierres", new Date(2017, 9, 15), "pepe@gmail.com","Calle pepes", new Date(1997, 1, 1), new Multimedia(FILE_PATH, "bob", "jpg"), educando);
        User_Scout unscouter = new User_Scout(new Long(5), "unscouter",otro,"wan", "wan", "li", "wan@gmail.com", "Wan Street", new Date(1999, 9, 9), scouter);
        User_Scout pablo = new User_Scout(new Long(9), "pablo", manada, "pablo", "pablo", "piedra", "test@test.com", "test aa", new Date(2002,11,21), educando);
        User_Scout manuel = new User_Scout(new Long(14), "manuel", manada, "manuel", "manuel", "roca", "test2@test.com", "test aa", new Date(2004,10,21), educando);
        User_Scout rosa = new User_Scout(new Long(17), "rosa", manada, "rosa", "rosa", "carrion", "test7@test.com", "test aa", new Date(2001,6,21), educando);
        User_Scout elisa = new User_Scout(new Long(55), "elisa", manada, "elisa", "elisa", "norman", "test3@test.com", "test aa oo", new Date(2006,9,14), educando);
        usuarios.add(manolo);
        usuarios.add(pepe);
        usuarios.add(unscouter);
        usuarios.add(elisa);
        usuarios.add(manuel);
        usuarios.add(pablo);
        usuarios.add(rosa);
       
        // Build event
        Event event = new Event();
        event.setName("Salida a los montes de Málaga");
        event.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus ex massa, id commodo mi gravida non. Proin eu sapien vitae ligula malesuada ultricies. Nullam et suscipit sem, eu porttitor ex. Morbi porttitor faucibus leo vel tempor. Aliquam et euismod purus, sed porttitor enim. Praesent egestas est eu varius tempus. Praesent varius felis diam, sed hendrerit mauris ultricies sit amet. Fusce interdum elit a nisl aliquam fermentum.\n" +
"\n" +
"                    Quisque non enim eros. Integer fringilla, dolor a luctus feugiat, quam nisi pellentesque nibh, et congue arcu ligula sodales arcu. Praesent sem arcu, viverra tristique felis at, tempor pretium sem. Suspendisse potenti. Aenean ornare vehicula diam. Phasellus cursus scelerisque quam, in ultricies dui dictum vehicula. Sed gravida consectetur turpis, at ullamcorper urna pulvinar. ");
        event.setGroupscout(manada);
        event.setDate(new Date());
        
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
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        event.setComments(commentList);
        events.add(event);
        
        // Build documents
        Document doc1 = new Document("Pepe_doc","Pepe_doc",false,"Formulario",new Long(1252345),pepe,null);
        Document doc2 = new Document("Manolo_doc1","Manolo_doc1",true,"Formulario",new Long(1748932),manolo,null);
        Document doc3 = new Document("Manolo_doc2","Manolo_doc2",true,"PDF",new Long(17435932),manolo,null);
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);
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
    public List<Event> getEvents() {
        return events;
    }

    /**
     * @param events the event to set
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
     /**
     * @return the event
     */
    public Event getEvent() {
        return events.get(0);
    }
    
    public void persistData() {
        try {
            initData();
            groupB.createGroups(groups);
            userB.addUsers(usuarios);
            eventB.addEvents(events);
            docB.addDocuments(documents);
            //FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha añadido correctamente", null);
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Datos añadidos", "Los datos han sido añadidos correctamente a la base de datos."));
        }
        catch (Exception e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
        }
    }
}
