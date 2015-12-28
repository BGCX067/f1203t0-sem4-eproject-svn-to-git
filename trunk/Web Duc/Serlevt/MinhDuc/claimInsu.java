/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhDuc;

import dao.AccountFacadeLocal;
import dao.ClaimFacadeLocal;
import dao.InsuranceFacadeLocal;
import dao.InsuranceTypeFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Claim;
import model.Employee;
import model.Insurance;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Duc
 */
@WebServlet(name = "claimInsu", urlPatterns = {"/claimInsu"})
public class claimInsu extends HttpServlet {
    @EJB
    private ClaimFacadeLocal claimFacade;
    @EJB
    private AccountFacadeLocal accountFacade;
    @EJB
    private InsuranceFacadeLocal insuranceFacade;
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
      
      
           String action = request.getParameter("action");
           String sessionuser= request.getParameter("ssuser");
           int accountID =   accountFacade.getAccountID(sessionuser);
            Employee emp = accountFacade.getEmployee(sessionuser);
            Insurance insurance= insuranceFacade.find(Integer.parseInt(emp.getEmployeeID()));
           
              
             String reason = request.getParameter("txtreason");
             Double amount = Double.parseDouble(request.getParameter("txtamount"));
              String hospitalName = request.getParameter("txthospitalName");
             String hospitalAddress= request.getParameter("txthospitaladdress");
             String hospitalPhone= request.getParameter("txthospitalPhone");
             String hospitalFax = request.getParameter("txthospitalFax");
              String hospitalEmail = request.getParameter("txthospitalEmail");
              Date createdDate=new Date();
             String myDate = new SimpleDateFormat("MM/dd/yyyy").format(createdDate);
              Random random=new Random();
              String attach = request.getParameter("attachment");
      
            

              if(action.equals("Submit")){                
                  Claim claim = new Claim();
                  claim.setClaimID(String.valueOf(random.nextInt(1000)));
                  Account account=accountFacade.find(accountID);
                 claim.setAccountID(account);
                  claim.setInsuranceID(insurance);
                  claim.setClaimReason(reason);
                  claim.setClaimAmount(amount);
                  claim.setClaimDate(myDate);
                  
                  claim.setClaimAttachment(attach);
                  claim.setClaimHospitalName(hospitalName);              
                  claim.setClaimHospitalAddress(hospitalAddress);
                 claim.setClaimHospitalPhone(hospitalPhone);
                 claim.setClaimHospitalFax(hospitalFax);
                  claim.setClaimHospitalEmail(hospitalEmail);
                  claimFacade.create(claim);
                  request.setAttribute("result", "Send Insu Successfully");
                request.getRequestDispatcher("faces/guest/ui/employeeMenu.xhtml").forward(request, response);
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
