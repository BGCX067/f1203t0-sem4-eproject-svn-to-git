/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClaimFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author candy
 */
@Named(value = "viewClaim")
@SessionScoped
public class viewClaim implements Serializable {
    @EJB
    private ClaimFacadeLocal claimFacade;
    private List claimList;
    @PostConstruct
    public void init(){
        claimList = new ArrayList<>();
        claimList = claimFacade.findAll();
    }

    public ClaimFacadeLocal getClaimFacade() {
        return claimFacade;
    }

    public void setClaimFacade(ClaimFacadeLocal claimFacade) {
        this.claimFacade = claimFacade;
    }

    public List getClaimList() {
        return claimList;
    }

    public void setClaimList(List claimList) {
        this.claimList = claimList;
    }
    
    public viewClaim() {
    }
   
}
