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
import model.Employee;

/**
 *
 * @author candy
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {
    @PersistenceContext(unitName = "WebBasedClaimProcessing-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public boolean checkIDCode(String empID, String accCode) {
        Query query =   em.createNamedQuery("Employee.findByEIDAccCode");
        query.setParameter("employeeID", empID);
        query.setParameter("accountCode", accCode);
        List<Employee> list = query.getResultList();
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }

    }
    
}
