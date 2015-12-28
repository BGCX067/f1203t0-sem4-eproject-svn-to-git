/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author candy
 */
@Entity
@Table(name = "Claim", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claim.findAll", query = "SELECT c FROM Claim c"),
    @NamedQuery(name = "Claim.findByClaimID", query = "SELECT c FROM Claim c WHERE c.claimID = :claimID"),
    @NamedQuery(name = "Claim.findByClaimAmount", query = "SELECT c FROM Claim c WHERE c.claimAmount = :claimAmount"),
    @NamedQuery(name = "Claim.findByClaimDate", query = "SELECT c FROM Claim c WHERE c.claimDate = :claimDate"),
    @NamedQuery(name = "Claim.findByClaimReason", query = "SELECT c FROM Claim c WHERE c.claimReason = :claimReason"),
    @NamedQuery(name = "Claim.findByClaimAttachment", query = "SELECT c FROM Claim c WHERE c.claimAttachment = :claimAttachment"),
    @NamedQuery(name = "Claim.findByClaimHospitalName", query = "SELECT c FROM Claim c WHERE c.claimHospitalName = :claimHospitalName"),
    @NamedQuery(name = "Claim.findByClaimHospitalAddress", query = "SELECT c FROM Claim c WHERE c.claimHospitalAddress = :claimHospitalAddress"),
    @NamedQuery(name = "Claim.findByClaimHospitalPhone", query = "SELECT c FROM Claim c WHERE c.claimHospitalPhone = :claimHospitalPhone"),
    @NamedQuery(name = "Claim.findByClaimHospitalFax", query = "SELECT c FROM Claim c WHERE c.claimHospitalFax = :claimHospitalFax"),
    @NamedQuery(name = "Claim.findByClaimHospitalEmail", query = "SELECT c FROM Claim c WHERE c.claimHospitalEmail = :claimHospitalEmail"),
    @NamedQuery(name = "Claim.findByClaimStatus", query = "SELECT c FROM Claim c WHERE c.claimStatus = :claimStatus"),
    @NamedQuery(name = "Claim.findByStatus", query = "SELECT c FROM Claim c WHERE c.status = :status")})
public class Claim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClaimID", nullable = false)
    private Integer claimID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClaimAmount", nullable = false)
    private double claimAmount;
    @Size(max = 10)
    @Column(name = "ClaimDate", length = 10)
    private String claimDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "ClaimReason", nullable = false, length = 400)
    private String claimReason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ClaimAttachment", nullable = false, length = 250)
    private String claimAttachment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ClaimHospitalName", nullable = false, length = 50)
    private String claimHospitalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ClaimHospitalAddress", nullable = false, length = 50)
    private String claimHospitalAddress;
    @Size(max = 50)
    @Column(name = "ClaimHospitalPhone", length = 50)
    private String claimHospitalPhone;
    @Size(max = 50)
    @Column(name = "ClaimHospitalFax", length = 50)
    private String claimHospitalFax;
    @Size(max = 50)
    @Column(name = "ClaimHospitalEmail", length = 50)
    private String claimHospitalEmail;
    @Size(max = 10)
    @Column(name = "ClaimStatus", length = 10)
    private String claimStatus;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "InsuranceID", referencedColumnName = "InsuranceID")
    @ManyToOne
    private Insurance insuranceID;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne
    private Account accountID;

    public Claim() {
    }

    public Claim(Integer claimID) {
        this.claimID = claimID;
    }

    public Claim(Integer claimID, double claimAmount, String claimReason, String claimAttachment, String claimHospitalName, String claimHospitalAddress) {
        this.claimID = claimID;
        this.claimAmount = claimAmount;
        this.claimReason = claimReason;
        this.claimAttachment = claimAttachment;
        this.claimHospitalName = claimHospitalName;
        this.claimHospitalAddress = claimHospitalAddress;
    }

    public Integer getClaimID() {
        return claimID;
    }

    public void setClaimID(Integer claimID) {
        this.claimID = claimID;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getClaimAttachment() {
        return claimAttachment;
    }

    public void setClaimAttachment(String claimAttachment) {
        this.claimAttachment = claimAttachment;
    }

    public String getClaimHospitalName() {
        return claimHospitalName;
    }

    public void setClaimHospitalName(String claimHospitalName) {
        this.claimHospitalName = claimHospitalName;
    }

    public String getClaimHospitalAddress() {
        return claimHospitalAddress;
    }

    public void setClaimHospitalAddress(String claimHospitalAddress) {
        this.claimHospitalAddress = claimHospitalAddress;
    }

    public String getClaimHospitalPhone() {
        return claimHospitalPhone;
    }

    public void setClaimHospitalPhone(String claimHospitalPhone) {
        this.claimHospitalPhone = claimHospitalPhone;
    }

    public String getClaimHospitalFax() {
        return claimHospitalFax;
    }

    public void setClaimHospitalFax(String claimHospitalFax) {
        this.claimHospitalFax = claimHospitalFax;
    }

    public String getClaimHospitalEmail() {
        return claimHospitalEmail;
    }

    public void setClaimHospitalEmail(String claimHospitalEmail) {
        this.claimHospitalEmail = claimHospitalEmail;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Insurance getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(Insurance insuranceID) {
        this.insuranceID = insuranceID;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claimID != null ? claimID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) object;
        if ((this.claimID == null && other.claimID != null) || (this.claimID != null && !this.claimID.equals(other.claimID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Claim[ claimID=" + claimID + " ]";
    }
    
}
