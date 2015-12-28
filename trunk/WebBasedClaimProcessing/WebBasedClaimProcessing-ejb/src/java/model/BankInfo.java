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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "BankInfo", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankInfo.findAll", query = "SELECT b FROM BankInfo b"),
    @NamedQuery(name = "BankInfo.findByBankID", query = "SELECT b FROM BankInfo b WHERE b.bankID = :bankID"),
    @NamedQuery(name = "BankInfo.findByBankName", query = "SELECT b FROM BankInfo b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "BankInfo.findByBankAddress", query = "SELECT b FROM BankInfo b WHERE b.bankAddress = :bankAddress")})
public class BankInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BankID", nullable = false)
    private Integer bankID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BankName", nullable = false, length = 50)
    private String bankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BankAddress", nullable = false, length = 50)
    private String bankAddress;
    @OneToMany(mappedBy = "bankID")
    private Collection<Employee> employeeCollection;

    public BankInfo() {
    }

    public BankInfo(Integer bankID) {
        this.bankID = bankID;
    }

    public BankInfo(Integer bankID, String bankName, String bankAddress) {
        this.bankID = bankID;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public Integer getBankID() {
        return bankID;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankID != null ? bankID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankInfo)) {
            return false;
        }
        BankInfo other = (BankInfo) object;
        if ((this.bankID == null && other.bankID != null) || (this.bankID != null && !this.bankID.equals(other.bankID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BankInfo[ bankID=" + bankID + " ]";
    }
    
}
