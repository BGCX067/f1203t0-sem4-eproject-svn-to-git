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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Insurance", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i"),
    @NamedQuery(name = "Insurance.findByInsuranceID", query = "SELECT i FROM Insurance i WHERE i.insuranceID = :insuranceID"),
    @NamedQuery(name = "Insurance.findByPolicyNumber", query = "SELECT i FROM Insurance i WHERE i.policyNumber = :policyNumber"),
    @NamedQuery(name = "Insurance.findByCreatedDate", query = "SELECT i FROM Insurance i WHERE i.createdDate = :createdDate"),
    @NamedQuery(name = "Insurance.findByExpiredDate", query = "SELECT i FROM Insurance i WHERE i.expiredDate = :expiredDate"),
    @NamedQuery(name = "Insurance.findByStatus", query = "SELECT i FROM Insurance i WHERE i.status = :status")})
public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "InsuranceID", nullable = false)
    private Integer insuranceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "PolicyNumber", nullable = false, length = 14)
    private String policyNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpiredDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuranceID")
    private Collection<Claim> claimCollection;
    @JoinColumn(name = "InsuranceTypeID", referencedColumnName = "InsuranceTypeID", nullable = false)
    @ManyToOne(optional = false)
    private InsuranceType insuranceTypeID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID", nullable = false)
    @ManyToOne(optional = false)
    private Employee employeeID;

    public Insurance() {
    }

    public Insurance(Integer insuranceID) {
        this.insuranceID = insuranceID;
    }

    public Insurance(Integer insuranceID, String policyNumber, Date createdDate, Date expiredDate) {
        this.insuranceID = insuranceID;
        this.policyNumber = policyNumber;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
    }

    public Integer getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(Integer insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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

    public InsuranceType getInsuranceTypeID() {
        return insuranceTypeID;
    }

    public void setInsuranceTypeID(InsuranceType insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
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
        hash += (insuranceID != null ? insuranceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
        if ((this.insuranceID == null && other.insuranceID != null) || (this.insuranceID != null && !this.insuranceID.equals(other.insuranceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Insurance[ insuranceID=" + insuranceID + " ]";
    }
    
}
