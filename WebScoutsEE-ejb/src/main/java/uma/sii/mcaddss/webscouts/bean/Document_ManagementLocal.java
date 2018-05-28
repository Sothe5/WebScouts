/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Local
public interface Document_ManagementLocal {
    public void addDocument(Document doc);
    public void changeDocumentStatus(Document doc);
    public List<Document> getAllDocuments();
    public List<Document> getDocuments(User_Scout user, boolean status);
    public List<Document> getAllDocumentsUser(User_Scout user);
    public int getNumberDocuments(User_Scout user, String status);
}
