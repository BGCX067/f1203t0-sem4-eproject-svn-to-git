/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.BankInfo;

/**
 *
 * @author Daniel
 */
@Local
public interface BankInfoFacadeLocal {

    void create(BankInfo bankInfo);

    void edit(BankInfo bankInfo);

    void remove(BankInfo bankInfo);

    BankInfo find(Object id);

    List<BankInfo> findAll();

    List<BankInfo> findRange(int[] range);

    int count();
    
}
