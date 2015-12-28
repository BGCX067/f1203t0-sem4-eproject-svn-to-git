/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Faq;

/**
 *
 * @author candy
 */
@Local
public interface FaqFacadeLocal {

    void create(Faq faq);

    void edit(Faq faq);

    void remove(Faq faq);

    Faq find(Object id);

    List<Faq> findAll();

    List<Faq> findRange(int[] range);

    int count();
    
}
