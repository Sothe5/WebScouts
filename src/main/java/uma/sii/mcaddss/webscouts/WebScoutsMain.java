package uma.sii.mcaddss.webscouts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author zolastro
 */
public class WebScoutsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uma.sii.mcaddss.WebScouts.jar_PU");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();
    }
    
}
