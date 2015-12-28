/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.News;

/**
 *
 * @author Duc
 */
@Local
public interface NewsFacadeLocal {

    void create(News news);

    void edit(News news);

    void remove(News news);

    News find(Object id);

    List<News> findAll();

    List<News> findRange(int[] range);

    int count();
    
}
