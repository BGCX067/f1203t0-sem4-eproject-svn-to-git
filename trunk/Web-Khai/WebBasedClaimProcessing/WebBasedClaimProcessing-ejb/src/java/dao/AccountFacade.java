/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Account;

/**
 *
 * @author candy
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public boolean checkLogin(String user, String pass) {
        Query query =   em.createNamedQuery("Account.findByUsernamePassword");
        query.setParameter("username", user);
        query.setParameter("password", pass);
        List<Account> list = query.getResultList();
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public Account findByUsername(String username) {
        Query query =   em.createNamedQuery("Account.findByAccountUsername");
         query.setParameter("accountUsername", username);
         Account a = (Account) query.getSingleResult();
         return a;
    }

    @Override
    public boolean checkUserEmail(String username, String email) {
        Query query =   em.createNamedQuery("Account.findByUsernameEmail");
        query.setParameter("username", username);
        query.setParameter("email", email);
         List<Account> list = query.getResultList();
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    
    
}
