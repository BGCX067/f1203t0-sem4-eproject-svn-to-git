/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.InsuranceType;

/**
 *
 * @author Daniel
 */
@Stateless
public class InsuranceTypeFacade extends AbstractFacade<InsuranceType> implements InsuranceTypeFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsuranceTypeFacade() {
        super(InsuranceType.class);
    }
    
}
