/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountFacadeLocal;
import dao.ClaimFacadeLocal;
import dao.InsuranceTypeFacadeLocal;
import dao.NewsFacade;
import dao.NewsFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author candy
 */
@WebServlet(name = "Redirect", urlPatterns = {"/Redirect"})
public class Redirect extends HttpServlet {
    @EJB
    private ClaimFacadeLocal claimFacade;
    @EJB
    private AccountFacadeLocal accountFacade;
    @EJB
    private NewsFacadeLocal newsFacade;
    @EJB
    private InsuranceTypeFacadeLocal insuranceTypeFacade;
    
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
        try {
            String page=request.getParameter("page");
            if (page.equalsIgnoreCase("index")) {
                request.getRequestDispatcher("faces/guest/ui/index.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("newsList")) {
                session.setAttribute("list", newsFacade.findAll());
                request.getRequestDispatcher("faces/guest/ui/newsList.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("guestMenu")) {
                request.getRequestDispatcher("faces/guest/ui/guestMenu.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("insuranceList")) {
                session.setAttribute("list", insuranceTypeFacade.findAll());
                request.getRequestDispatcher("faces/guest/ui/insuranceList.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("contact")) {
                request.getRequestDispatcher("faces/guest/ui/contact.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("insuranceDetails")) {
                String name = request.getParameter("name");
                session.setAttribute("list", insuranceTypeFacade.findByName(name));
                session.setAttribute("all", insuranceTypeFacade.findAll());
                request.getRequestDispatcher("faces/guest/ui/insuranceDetails.xhtml").forward(request, response);
            }
             if (page.equalsIgnoreCase("newsContent")) {
                 String title = request.getParameter("title");
                session.setAttribute("list", newsFacade.findByName(title));
                session.setAttribute("all", newsFacade.findAll());
                request.getRequestDispatcher("faces/guest/ui/newsContent.xhtml").forward(request, response);
            }
             if (page.equalsIgnoreCase("viewClaims")) {
                String username = request.getParameter("username");
                Account acc = accountFacade.findByUsername(username);
                session.setAttribute("list", claimFacade.find(acc.getAccountID()) );
                request.getRequestDispatcher("faces/guest/ui/viewClaims.xhtml").forward(request, response);
            } if (page.equalsIgnoreCase("login")) {
                request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response);
            }
        } finally {            
            out.close();
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
