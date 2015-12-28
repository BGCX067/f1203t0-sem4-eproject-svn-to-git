/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.InsuranceType;

/**
 *
 * @author Daniel
 */
@Local
public interface InsuranceTypeFacadeLocal {

    void create(InsuranceType insuranceType);

    void edit(InsuranceType insuranceType);

    void remove(InsuranceType insuranceType);

    InsuranceType find(Object id);

    List<InsuranceType> findAll();

    List<InsuranceType> findRange(int[] range);

    int count();
    
}
