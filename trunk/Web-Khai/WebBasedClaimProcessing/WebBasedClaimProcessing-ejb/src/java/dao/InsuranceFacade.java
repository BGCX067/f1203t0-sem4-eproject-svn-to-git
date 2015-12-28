/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Insurance;

/**
 *
 * @author candy
 */
@Stateless
public class InsuranceFacade extends AbstractFacade<Insurance> implements InsuranceFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsuranceFacade() {
        super(Insurance.class);
    }
    
}
