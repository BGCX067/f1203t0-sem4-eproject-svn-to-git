/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Employee", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"AccountCode"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByMiddleName", query = "SELECT e FROM Employee e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByDateOfBirth", query = "SELECT e FROM Employee e WHERE e.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Employee.findByIDNumber", query = "SELECT e FROM Employee e WHERE e.iDNumber = :iDNumber"),
    @NamedQuery(name = "Employee.findByAccountCode", query = "SELECT e FROM Employee e WHERE e.accountCode = :accountCode"),
    @NamedQuery(name = "Employee.findByAccountNumber", query = "SELECT e FROM Employee e WHERE e.accountNumber = :accountNumber"),
    @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "EmployeeID", nullable = false, length = 6)
    private String employeeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;
    @Size(max = 20)
    @Column(name = "MiddleName", length = 20)
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDNumber", nullable = false, length = 10)
    private String iDNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AccountCode", nullable = false, length = 10)
    private String accountCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "AccountNumber", nullable = false, length = 16)
    private String accountNumber;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Account> accountCollection;
    @JoinColumn(name = "BankID", referencedColumnName = "BankID")
    @ManyToOne
    private BankInfo bankID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Insurance> insuranceCollection;

    public Employee() {
    }

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(String employeeID, String firstName, String lastName, Date dateOfBirth, String iDNumber, String accountCode, String accountNumber) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.iDNumber = iDNumber;
        this.accountCode = accountCode;
        this.accountNumber = accountNumber;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    public BankInfo getBankID() {
        return bankID;
    }

    public void setBankID(BankInfo bankID) {
        this.bankID = bankID;
    }

    @XmlTransient
    public Collection<Insurance> getInsuranceCollection() {
        return insuranceCollection;
    }

    public void setInsuranceCollection(Collection<Insurance> insuranceCollection) {
        this.insuranceCollection = insuranceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Employee[ employeeID=" + employeeID + " ]";
    }
    
}
