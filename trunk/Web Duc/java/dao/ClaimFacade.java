/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Claim;

/**
 *
 * @author Duc
 */
@Stateless
public class ClaimFacade extends AbstractFacade<Claim> implements ClaimFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaimFacade() {
        super(Claim.class);
    }
    
}
