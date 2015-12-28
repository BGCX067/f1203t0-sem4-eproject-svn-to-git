/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhDuc;

import dao.ContactFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;

/**
 *
 * @author Duc
 */
@WebServlet(name = "contact", urlPatterns = {"/contact"})
public class contact extends HttpServlet {
    @EJB
    private ContactFacadeLocal contactFacade;

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
        try{
         String title= request.getParameter("txttitle");
         String name= request.getParameter("txtname");
         String email= request.getParameter("txtemail");
         String content= request.getParameter("txtcontent");
         Date createdDate=new Date();
         String myDate = new SimpleDateFormat("MM/dd/yyyy").format(createdDate);
        Random random = new Random();
        Contact contact= new Contact();
           contact.setContactID(random.nextInt(1000));
           contact.setContactTitle(title);
           contact.setContactName(name);
           contact.setContactEmail(email);
           contact.setContactCreatedDate(myDate);
           contact.setContactContent(content);
               contactFacade.create(contact);
          request.getRequestDispatcher("faces/guest/ui/index.xhtml").forward(request, response);
              } catch (Exception e) {
                e.printStackTrace();
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
