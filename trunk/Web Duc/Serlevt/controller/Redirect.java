/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountFacadeLocal;
import dao.FaqFacadeLocal;
import dao.InsuranceTypeFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Faq;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Redirect", urlPatterns = {"/Redirect"})
public class Redirect extends HttpServlet {
    @EJB
    private AccountFacadeLocal accountFacade;
    @EJB
    private FaqFacadeLocal faqFacade;
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
                request.getRequestDispatcher("faces/guest/ui/newsList.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("guestMenu")) {
                request.getRequestDispatcher("faces/guest/ui/guestMenu.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("insuranceList")) {
                request.getRequestDispatcher("faces/guest/ui/insuranceList.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("contact")) {
                request.getRequestDispatcher("faces/guest/ui/contact.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("editProfile")) {
                request.getRequestDispatcher("faces/guest/ui/editUserProfile.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("changePass")) {
                
                String sessionuser = (String) session.getAttribute("user");
                request.setAttribute("pass", accountFacade.getPass(sessionuser));
                request.getRequestDispatcher("faces/guest/ui/changePassword.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("claimInsu")) {
                request.setAttribute("list", insuranceTypeFacade.findAll() );
                request.getRequestDispatcher("faces/guest/ui/claimInsurance.xhtml").forward(request, response);
            }
            if (page.equalsIgnoreCase("viewClaim")) {
                request.getRequestDispatcher("faces/guest/ui/viewClaims.xhtml").forward(request, response);
            } 
            if (page.equalsIgnoreCase("FAQs")) {
                
               request.setAttribute("list", faqFacade.getFAQList() );
               request.getRequestDispatcher("faces/guest/ui/faqs.xhtml").forward(request, response);
            }
             if (page.equalsIgnoreCase("register")) {
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response);
            }
              if (page.equalsIgnoreCase("login")) {
                request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response);
            }  if (page.equalsIgnoreCase("employeeMenu")) {
                request.getRequestDispatcher("faces/guest/ui/employeeMenu.xhtml").forward(request, response);
            }
            if(page.equalsIgnoreCase("Logout"))
            {
               session.removeAttribute("user");
               session.removeAttribute("pass");
               request.getRequestDispatcher("faces/guest/ui/index.xhtml").forward(request, response);
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
