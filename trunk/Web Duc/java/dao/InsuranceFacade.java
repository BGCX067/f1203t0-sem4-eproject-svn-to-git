/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Account;
import model.Insurance;

/**
 *
 * @author Duc
 */
@Stateless
public class InsuranceFacade extends AbstractFacade<Insurance> implements InsuranceFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsuranceFacade() {
        super(Insurance.class);
    }

    @Override
    public Integer getInsuranceID(String policyNumber) {
         Query query = em.createNamedQuery("Insurance.findByInsurancePolicyNumber");
        query.setParameter("insurancePolicyNumber", policyNumber);      
        Insurance list = ( Insurance) query.getSingleResult();
        if(list==null){
            return null;
        }else
        {
            return list.getInsuranceID();
        }
    }

    
}
