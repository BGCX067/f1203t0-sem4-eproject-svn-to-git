/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Account;
import model.Faq;

/**
 *
 * @author Duc
 */
@Stateless
public class FaqFacade extends AbstractFacade<Faq> implements FaqFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaqFacade() {
        super(Faq.class);
    }

    @Override
    public List getFAQList() {
        Query query = em.createQuery("SELECT f FROM Faq f ORDER BY f.faqid DESC");
        List<Faq> list = query.getResultList();
        if(list.isEmpty()){
            return null;
        }else
        {
            return list;
        }
    }
 
}
