/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Employee;

/**
 *
 * @author Duc
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
}
