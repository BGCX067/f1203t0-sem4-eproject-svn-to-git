/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.News;

/**
 *
 * @author Duc
 */
@Stateless
public class NewsFacade extends AbstractFacade<News> implements NewsFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }
    
}
