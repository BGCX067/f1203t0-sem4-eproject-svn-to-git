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
import model.Employee;

/**
 *
 * @author Duc
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "WebClaim-ejbPU")
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
        Query query = em.createNamedQuery("Account.findByAccountUsernamePassword");
        query.setParameter("accountUsername", user);
        query.setParameter("accountPassword", pass);
        List<Account> list = query.getResultList();
        if(list.isEmpty()){
            return false;
        }else
        {
            return true;
        }
    }
   

    @Override
    public Integer getAccountID(String user) {
        Query query = em.createNamedQuery("Account.findByAccountUsername");
        query.setParameter("accountUsername", user);      
        Account list = (Account) query.getSingleResult();
        if(list==null){
            return 0;
        }else
        {
            return list.getAccountID();
        }
    
    }

    @Override
    public String getPass(String user) {
        Query query = em.createNamedQuery("Account.findByAccountUsername");
        query.setParameter("accountUsername", user);      
        Account list = (Account) query.getSingleResult();
        if(list==null){
            return null;
        }else
        {
            return list.getAccountPassword();
        }
    }

    @Override
    public Employee getEmployee(String user) {
           Query query = em.createNamedQuery("Account.findByAccountUsername");
        query.setParameter("accountUsername", user);      
        Account list = (Account) query.getSingleResult();
        if(list==null){
            return null;
        }else
        {
            return list.getEmployeeID();
        }
    }
     
}
