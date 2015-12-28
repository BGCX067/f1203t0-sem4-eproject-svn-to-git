/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.InsuranceType;

/**
 *
 * @author candy
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

    @Override
    public InsuranceType findByName(String name) {
         Query query =   em.createNamedQuery("InsuranceType.findByInsuranceTypeName");
         query.setParameter("insuranceTypeName", name);
         InsuranceType in = (InsuranceType) query.getSingleResult();
         
         return in;
         
        
    }
    
}
