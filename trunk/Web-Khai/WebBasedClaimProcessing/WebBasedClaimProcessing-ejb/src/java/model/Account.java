/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author candy
 */
@Entity
@Table(name = "Account", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"AccountUsername"}),
    @UniqueConstraint(columnNames = {"AccountEmail"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountID", query = "SELECT a FROM Account a WHERE a.accountID = :accountID"),
    @NamedQuery(name = "Account.findByAccountUsername", query = "SELECT a FROM Account a WHERE a.accountUsername = :accountUsername"),
    @NamedQuery(name = "Account.findByAccountPassword", query = "SELECT a FROM Account a WHERE a.accountPassword = :accountPassword"),
    @NamedQuery(name = "Account.findByUsernamePassword", query = "SELECT a FROM Account a WHERE a.accountUsername = :username AND a.accountPassword = :password"),
    @NamedQuery(name = "Account.findByUsernameEmail", query = "SELECT a FROM Account a WHERE a.accountUsername = :username AND a.accountEmail = :email"),
    @NamedQuery(name = "Account.findByAccountEmail", query = "SELECT a FROM Account a WHERE a.accountEmail = :accountEmail"),
    @NamedQuery(name = "Account.findByAccountAddress", query = "SELECT a FROM Account a WHERE a.accountAddress = :accountAddress"),
    @NamedQuery(name = "Account.findByAccountPhoneNumber", query = "SELECT a FROM Account a WHERE a.accountPhoneNumber = :accountPhoneNumber"),
    @NamedQuery(name = "Account.findByAccountImage", query = "SELECT a FROM Account a WHERE a.accountImage = :accountImage"),
    @NamedQuery(name = "Account.findByAccountCreatedDate", query = "SELECT a FROM Account a WHERE a.accountCreatedDate = :accountCreatedDate"),
    @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "AccountID", nullable = false)
    private Integer accountID;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    
    @Column(name = "AccountUsername", nullable = false, length = 50)
    
    private String accountUsername;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    
    
    @Column(name = "AccountPassword", nullable = false, length = 50)
    
    private String accountPassword;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    
    
    @Column(name = "AccountEmail", nullable = false, length = 50)
    private String accountEmail;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    
    
    @Column(name = "AccountAddress", nullable = false, length = 50)
    private String accountAddress;
    @Size(max = 10)
    @Column(name = "AccountPhoneNumber", length = 10)
    private String accountPhoneNumber;
    @Size(max = 50)
    @Column(name = "AccountImage", length = 50)
    private String accountImage;
    @Size(max = 10)
    @Column(name = "AccountCreatedDate", length = 10)
    private String accountCreatedDate;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "accountID")
    private Collection<Claim> claimCollection;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employee employeeID;

    public Account() {
    }

    public Account(Integer accountID) {
        this.accountID = accountID;
    }

    public Account(Integer accountID, String accountUsername, String accountPassword, String accountEmail, String accountAddress) {
        this.accountID = accountID;
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountEmail = accountEmail;
        this.accountAddress = accountAddress;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountPhoneNumber() {
        return accountPhoneNumber;
    }

    public void setAccountPhoneNumber(String accountPhoneNumber) {
        this.accountPhoneNumber = accountPhoneNumber;
    }

    public String getAccountImage() {
        return accountImage;
    }

    public void setAccountImage(String accountImage) {
        this.accountImage = accountImage;
    }

    public String getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(String accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Account[ accountID=" + accountID + " ]";
    }
    
}
