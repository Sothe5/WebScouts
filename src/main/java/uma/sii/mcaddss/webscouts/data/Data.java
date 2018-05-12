/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "data")
@Dependent
public class Data {
    
    private ArrayList<User_Scout> usuarios = new ArrayList<>
        (Arrays.asList(new User_Scout(new Long(1),"Manolo",new Group_Scout("Marmota"),"manolo","manolo@gmail.com","Calle manolos", new Date(1997, 1, 2), new ArrayList<>(Arrays.asList(new Document("Manolo_doc1",true,"Formulario"),new Document("Manolo_doc2", false,"Formulario"))))
                , new User_Scout(new Long(2),"Pepe",new Group_Scout("Castor"),"pepe","pepe@gmail.com","Calle pepes", new Date(1997, 1, 1), new ArrayList<>(Arrays.asList(new Document("Pepe_doc",false,"Formulario"))))));

    /**
     * Creates a new instance of Data
     */
    public Data() {
    }

    public ArrayList<User_Scout> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<User_Scout> usuarios) {
        this.usuarios = usuarios;
    }
    
}
