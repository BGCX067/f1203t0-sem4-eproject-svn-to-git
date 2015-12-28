/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author candy
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @EJB
    private AccountFacadeLocal accountFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("Login"))
        {
           String user = request.getParameter("user");
            if (user.equals("")) {
                request.setAttribute("usernameError","Username can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response);
            }
           String pass = request.getParameter("pass");
           if(pass.equals(""))
           {
               request.setAttribute("passwordError","Password can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response); 
           }
           if(accountFacade.checkLogin(user, pass))
           {
              session.setAttribute("user",request.getParameter("user") );
             
               request.getRequestDispatcher("faces/guest/ui/employeeMenu.xhtml").forward(request, response);
           }else{
              request.setAttribute("userpassError","Username or password is not correct " );
              request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response);
           }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
