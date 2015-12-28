/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Contact;

/**
 *
 * @author Duc
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> implements ContactFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }
    
}
