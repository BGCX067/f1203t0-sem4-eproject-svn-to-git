/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "InsuranceType", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuranceType.findAll", query = "SELECT i FROM InsuranceType i"),
    @NamedQuery(name = "InsuranceType.findByInsuranceTypeID", query = "SELECT i FROM InsuranceType i WHERE i.insuranceTypeID = :insuranceTypeID"),
    @NamedQuery(name = "InsuranceType.findByName", query = "SELECT i FROM InsuranceType i WHERE i.name = :name"),
    @NamedQuery(name = "InsuranceType.findByDescription", query = "SELECT i FROM InsuranceType i WHERE i.description = :description"),
    @NamedQuery(name = "InsuranceType.findByMaximumReimbursement", query = "SELECT i FROM InsuranceType i WHERE i.maximumReimbursement = :maximumReimbursement")})
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
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "Description", nullable = false, length = 400)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaximumReimbursement", nullable = false)
    private double maximumReimbursement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuranceTypeID")
    private Collection<Insurance> insuranceCollection;

    public InsuranceType() {
    }

    public InsuranceType(Integer insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
    }

    public InsuranceType(Integer insuranceTypeID, String name, String description, double maximumReimbursement) {
        this.insuranceTypeID = insuranceTypeID;
        this.name = name;
        this.description = description;
        this.maximumReimbursement = maximumReimbursement;
    }

    public Integer getInsuranceTypeID() {
        return insuranceTypeID;
    }

    public void setInsuranceTypeID(Integer insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMaximumReimbursement() {
        return maximumReimbursement;
    }

    public void setMaximumReimbursement(double maximumReimbursement) {
        this.maximumReimbursement = maximumReimbursement;
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
