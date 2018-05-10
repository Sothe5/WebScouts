/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.userBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Named(value = "userBean")
@Dependent
public class userBean {
    
//    Currently mocked      
//    @PersistenceContext(unitName = "webScoutsPU")
//    private EntityManager em;
    
    /**
     * Creates a new instance of userBean
     */
    public userBean() {
    }

    public List<User_Scout> getUsers(){
//        String qlString = "select u from USERS";
//        Query users_query = em.createQuery(qlString);
//        return users_query.getResultList();
          List<User_Scout> mockedList = new ArrayList<>();
          return mockedList;
    }
    
}
