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

/**
 *
 * @author candy
 */
@Entity
@Table(name = "Employee", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EmployeeAccountCode"}),
    @UniqueConstraint(columnNames = {"EmployeeIDNumber"}),
    @UniqueConstraint(columnNames = {"EmployeeAccountNumber"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employee.findByEmployeeFirstName", query = "SELECT e FROM Employee e WHERE e.employeeFirstName = :employeeFirstName"),
    @NamedQuery(name = "Employee.findByEmployeeMiddleName", query = "SELECT e FROM Employee e WHERE e.employeeMiddleName = :employeeMiddleName"),
    @NamedQuery(name = "Employee.findByEmployeeLastName", query = "SELECT e FROM Employee e WHERE e.employeeLastName = :employeeLastName"),
    @NamedQuery(name = "Employee.findByEmployeeDateOfBirth", query = "SELECT e FROM Employee e WHERE e.employeeDateOfBirth = :employeeDateOfBirth"),
    @NamedQuery(name = "Employee.findByEmployeeIDNumber", query = "SELECT e FROM Employee e WHERE e.employeeIDNumber = :employeeIDNumber"),
    @NamedQuery(name = "Employee.findByEmployeeAccountCode", query = "SELECT e FROM Employee e WHERE e.employeeAccountCode = :employeeAccountCode"),
    @NamedQuery(name = "Employee.findByEmployeeAccountNumber", query = "SELECT e FROM Employee e WHERE e.employeeAccountNumber = :employeeAccountNumber"),
    @NamedQuery(name = "Employee.findByEIDAccCode", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID AND e.employeeAccountCode = :accountCode"),
    @NamedQuery(name = "Employee.findByEmployeeCreatedDate", query = "SELECT e FROM Employee e WHERE e.employeeCreatedDate = :employeeCreatedDate"),
    @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EmployeeID", nullable = false, length = 10)
    private String employeeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EmployeeFirstName", nullable = false, length = 20)
    private String employeeFirstName;
    @Size(max = 20)
    @Column(name = "EmployeeMiddleName", length = 20)
    private String employeeMiddleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EmployeeLastName", nullable = false, length = 20)
    private String employeeLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EmployeeDateOfBirth", nullable = false, length = 10)
    private String employeeDateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EmployeeIDNumber", nullable = false, length = 10)
    private String employeeIDNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EmployeeAccountCode", nullable = false, length = 10)
    private String employeeAccountCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "EmployeeAccountNumber", nullable = false, length = 16)
    private String employeeAccountNumber;
    @Size(max = 10)
    @Column(name = "EmployeeCreatedDate", length = 10)
    private String employeeCreatedDate;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "employeeID")
    private Collection<Account> accountCollection;
    @JoinColumn(name = "EmployeeBankID", referencedColumnName = "BankID")
    @ManyToOne
    private BankInfo employeeBankID;
    @OneToMany(mappedBy = "employeeID")
    private Collection<Insurance> insuranceCollection;

    public Employee() {
    }

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(String employeeID, String employeeFirstName, String employeeLastName, String employeeDateOfBirth, String employeeIDNumber, String employeeAccountCode, String employeeAccountNumber) {
        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeIDNumber = employeeIDNumber;
        this.employeeAccountCode = employeeAccountCode;
        this.employeeAccountNumber = employeeAccountNumber;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeIDNumber() {
        return employeeIDNumber;
    }

    public void setEmployeeIDNumber(String employeeIDNumber) {
        this.employeeIDNumber = employeeIDNumber;
    }

    public String getEmployeeAccountCode() {
        return employeeAccountCode;
    }

    public void setEmployeeAccountCode(String employeeAccountCode) {
        this.employeeAccountCode = employeeAccountCode;
    }

    public String getEmployeeAccountNumber() {
        return employeeAccountNumber;
    }

    public void setEmployeeAccountNumber(String employeeAccountNumber) {
        this.employeeAccountNumber = employeeAccountNumber;
    }

    public String getEmployeeCreatedDate() {
        return employeeCreatedDate;
    }

    public void setEmployeeCreatedDate(String employeeCreatedDate) {
        this.employeeCreatedDate = employeeCreatedDate;
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

    public BankInfo getEmployeeBankID() {
        return employeeBankID;
    }

    public void setEmployeeBankID(BankInfo employeeBankID) {
        this.employeeBankID = employeeBankID;
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
