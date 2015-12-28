/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Insurance;

/**
 *
 * @author Duc
 */
@Local
public interface InsuranceFacadeLocal {

    void create(Insurance insurance);

    void edit(Insurance insurance);

    void remove(Insurance insurance);

    Insurance find(Object id);

    List<Insurance> findAll();

    List<Insurance> findRange(int[] range);

    int count();

    Integer getInsuranceID(String policyNumber);


    
}
