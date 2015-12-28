/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.News;

/**
 *
 * @author candy
 */
@Stateless
public class NewsFacade extends AbstractFacade<News> implements NewsFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }

    @Override
    public News findByName(String name) {
        Query query =   em.createNamedQuery("News.findByNewsTitle");
         query.setParameter("newsTitle", name);
         News n = (News) query.getSingleResult();
         return n;
    }
    
    
    
}
