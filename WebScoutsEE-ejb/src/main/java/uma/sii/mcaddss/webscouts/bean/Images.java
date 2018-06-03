/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uma.sii.mcaddss.webscouts.entities.Multimedia;

/**
 *
 * @author dan147
 */

@Stateless
public class Images implements ImagesLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;
    
    @Override
    public void addImage(Multimedia photo){
        em.persist(photo);
    }
}
