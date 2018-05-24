/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uma.sii.mcaddss.webscouts.entities.Document;
import uma.sii.mcaddss.webscouts.entities.User_Scout;

/**
 *
 * @author Nexel
 */
@Stateless
public class Document_Management implements Document_ManagementLocal {
    
    @PersistenceContext(unitName = "WebScoutsEEPU")
    private EntityManager em;

    @Override
    public void addDocument(Document doc) {
        em.persist(doc);
    }

    @Override
    public void changeDocumentStatus(Document doc) {
        doc.setStatus(!doc.getStatus());
        em.merge(doc);
    }

    @Override
    public List<Document> getAllDocuments() {
        Query query = em.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }

    @Override
    public List<Document> getDocuments(User_Scout user, boolean status) {
        Query query = em.createQuery("SELECT d FROM Document d WHERE d.owner = :fuser AND d.status = :fstatus", Document.class);
        query.setParameter("fuser", user);
        query.setParameter("fstatus", status);
        return query.getResultList();
    }

    @Override
    public List<Document> getAllDocumentsUser(User_Scout user) {
        Query query = em.createQuery("SELECT d FROM Document d WHERE d.owner = :fuser", Document.class);
        query.setParameter("fuser", user);
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
