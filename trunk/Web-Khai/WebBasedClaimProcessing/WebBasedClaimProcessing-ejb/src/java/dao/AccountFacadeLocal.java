/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Account;

/**
 *
 * @author candy
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    int count();

    boolean checkLogin(String user, String pass);

    Account findByUsername(String username);

    boolean checkUserEmail(String username, String email);
    
}
