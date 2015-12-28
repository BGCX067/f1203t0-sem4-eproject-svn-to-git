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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc
 */
@Entity
@Table(name = "InsuranceType", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"InsuranceTypeName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuranceType.findAll", query = "SELECT i FROM InsuranceType i"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeID", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeID = :insuranceTypeID"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeName", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeName = :insuranceTypeName"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeDescription", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeDescription = :insuranceTypeDescription"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeContent", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeContent = :insuranceTypeContent"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeMaximumReimbursement", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeMaximumReimbursement = :insuranceTypeMaximumReimbursement"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeCreatedDate", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeCreatedDate = :insuranceTypeCreatedDate"),
    @NamedQuery(name = "InsuranceType.findByStatus", query = "SELECT i FROM InsuranceType i WHERE i.status = :status")})
public class InsuranceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "InsuranceTypeID", nullable = false)
    private Integer insuranceTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "InsuranceTypeName", nullable = false, length = 50)
    private String insuranceTypeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "InsuranceTypeDescription", nullable = false, length = 50)
    private String insuranceTypeDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "InsuranceTypeContent", nullable = false, length = 4000)
    private String insuranceTypeContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InsuranceTypeMaximumReimbursement", nullable = false)
    private double insuranceTypeMaximumReimbursement;
    @Size(max = 10)
    @Column(name = "InsuranceTypeCreatedDate", length = 10)
    private String insuranceTypeCreatedDate;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "insuranceTypeID")
    private Collection<Insurance> insuranceCollection;

    public InsuranceType() {
    }

    public InsuranceType(Integer insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
    }

    public InsuranceType(Integer insuranceTypeID, String insuranceTypeName, String insuranceTypeDescription, String insuranceTypeContent, double insuranceTypeMaximumReimbursement) {
        this.insuranceTypeID = insuranceTypeID;
        this.insuranceTypeName = insuranceTypeName;
        this.insuranceTypeDescription = insuranceTypeDescription;
        this.insuranceTypeContent = insuranceTypeContent;
        this.insuranceTypeMaximumReimbursement = insuranceTypeMaximumReimbursement;
    }

    public Integer getInsuranceTypeID() {
        return insuranceTypeID;
    }

    public void setInsuranceTypeID(Integer insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
    }

    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName;
    }

    public String getInsuranceTypeDescription() {
        return insuranceTypeDescription;
    }

    public void setInsuranceTypeDescription(String insuranceTypeDescription) {
        this.insuranceTypeDescription = insuranceTypeDescription;
    }

    public String getInsuranceTypeContent() {
        return insuranceTypeContent;
    }

    public void setInsuranceTypeContent(String insuranceTypeContent) {
        this.insuranceTypeContent = insuranceTypeContent;
    }

    public double getInsuranceTypeMaximumReimbursement() {
        return insuranceTypeMaximumReimbursement;
    }

    public void setInsuranceTypeMaximumReimbursement(double insuranceTypeMaximumReimbursement) {
        this.insuranceTypeMaximumReimbursement = insuranceTypeMaximumReimbursement;
    }

    public String getInsuranceTypeCreatedDate() {
        return insuranceTypeCreatedDate;
    }

    public void setInsuranceTypeCreatedDate(String insuranceTypeCreatedDate) {
        this.insuranceTypeCreatedDate = insuranceTypeCreatedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (insuranceTypeID != null ? insuranceTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuranceType)) {
            return false;
        }
        InsuranceType other = (InsuranceType) object;
        if ((this.insuranceTypeID == null && other.insuranceTypeID != null) || (this.insuranceTypeID != null && !this.insuranceTypeID.equals(other.insuranceTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.InsuranceType[ insuranceTypeID=" + insuranceTypeID + " ]";
    }
    
}
