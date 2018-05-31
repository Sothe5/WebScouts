/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uma.sii.mcaddss.webscouts.entities.Comment;

/**
 *
 * @author cloud
 */
@Stateless
public class CommentBusiness implements CommentLocal {

    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;
    
    @Override
    public void addComment(Comment comment) {
        em.persist(comment);
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    
    public void addComments(List<Comment> comments) {
        for(Comment comment : comments) {
            em.persist(comment);
        }
    }
}
