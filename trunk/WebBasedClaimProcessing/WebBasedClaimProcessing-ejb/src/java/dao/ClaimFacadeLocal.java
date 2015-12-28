/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Claim;

/**
 *
 * @author Daniel
 */
@Local
public interface ClaimFacadeLocal {

    void create(Claim claim);

    void edit(Claim claim);

    void remove(Claim claim);

    Claim find(Object id);

    List<Claim> findAll();

    List<Claim> findRange(int[] range);

    int count();
    
}
