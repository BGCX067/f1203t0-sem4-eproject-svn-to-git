/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountFacadeLocal;
import dao.EmployeeFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Employee;

/**
 *
 * @author candy
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    @EJB
    private EmployeeFacadeLocal employeeFacade;
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
          
        try {
            String user = request.getParameter("username");
             if (user.equals("")) {
                request.setAttribute("usernameError","Username can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response);
            }
            String password = request.getParameter("password");
            if(password.equals(""))
           {
               request.setAttribute("passwordError","Password can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }
            String eid = request.getParameter("EID");
            if(eid.equals(""))
           {
               request.setAttribute("eidError","EmployeeID can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }
            String accCode = request.getParameter("accountCode");
            if(accCode.equals(""))
           {
               request.setAttribute("codeError","AccountCode can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }
            String email = request.getParameter("email");
            if(email.equals(""))
           {
               request.setAttribute("emailError","Email can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }
           // Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
           // Matcher matcher3 = replace.matcher(request.getParameter("email"));
            String address = request.getParameter("address");
            if(address.equals(""))
           {
               request.setAttribute("addressError","Address can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }
            String phone = request.getParameter("phoneNumber");
           /* if(phone.equals(""))
           {
               request.setAttribute("phoneError","Phone number can not be blank " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response); 
           }*/
           Pattern replace = Pattern.compile("\\d{10,11}");
           Matcher matcher2 = replace.matcher(request.getParameter("phoneNumber"));
           if (!matcher2.matches()) {
               request.setAttribute("phoneError","Phone must be 10~11 numbers!" );
               request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response);
           }

            if(employeeFacade.checkIDCode(eid, accCode))
            {
                
                    Account acc = new Account();
                acc.setAccountID(2);
                acc.setAccountUsername(user);
                acc.setAccountPassword(password);
                
               
                
                acc.setAccountEmail(email);
                acc.setAccountAddress(address);
                acc.setAccountPhoneNumber(phone);
                Employee emp = employeeFacade.find(eid);
                acc.setEmployeeID(emp);
                 accountFacade.create(acc);
                 request.getRequestDispatcher("faces/guest/ui/login.xhtml").forward(request, response);
                
                
               
            }else
            {
                request.setAttribute("eidcodeError","EmployeeID or Account Code is not correct " );
                request.getRequestDispatcher("faces/guest/ui/register.xhtml").forward(request, response);
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
