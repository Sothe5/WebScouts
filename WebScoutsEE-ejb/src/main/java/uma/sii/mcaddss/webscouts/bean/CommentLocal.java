/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Comment;

/**
 *
 * @author cloud
 */
@Local
public interface CommentLocal {

    void addComment(Comment comment);

    void addComments(List<Comment> comments);
    
}
