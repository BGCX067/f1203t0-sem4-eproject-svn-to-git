/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Admin;

/**
 *
 * @author Trims
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

    @Override
    public boolean Login(String username, String password) {
        ConnectionDB con = new ConnectionDB();
        con.query = "select * from [Admin] where AdminUsername=? and AdminPassword=?";
        try {
            con.connect();
            con.preparedStatement = con.connection.prepareStatement(con.query);
            con.preparedStatement.setString(1, username);
            con.preparedStatement.setString(2, password);
            con.rs=con.preparedStatement.executeQuery();
            if (con.rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            con.disconnect();
        }
    }

    @Override
    public boolean changePass(String oldPass, String newPass) {
        ConnectionDB con = new ConnectionDB();
        con.query = "select * from [Admin] where AdminPassword=?";
        try {
            con.connect();
            con.preparedStatement = con.connection.prepareStatement(con.query);
            con.preparedStatement.setString(1, oldPass);
            con.rs=con.preparedStatement.executeQuery();
            if (con.rs.next()) {
                con.query = "UPDATE [Admin] SET AdminPassword=? where AdminUsername=?";
                con.connect();
                con.preparedStatement = con.connection.prepareStatement(con.query);
                con.preparedStatement.setString(1, newPass);
                con.preparedStatement.setString(2, con.rs.getString(1));
                con.preparedStatement.executeUpdate();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            con.disconnect();
        }
    }
    
    
    
}
