/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.BankInfo;

/**
 *
 * @author Daniel
 */
@Stateless
public class BankInfoFacade extends AbstractFacade<BankInfo> implements BankInfoFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BankInfoFacade() {
        super(BankInfo.class);
    }
    
}
