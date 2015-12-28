/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
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
    @NamedQuery(name = "Claim.findByAttachment", query = "SELECT c FROM Claim c WHERE c.attachment = :attachment"),
    @NamedQuery(name = "Claim.findByHospitalName", query = "SELECT c FROM Claim c WHERE c.hospitalName = :hospitalName"),
    @NamedQuery(name = "Claim.findByHospitalAddress", query = "SELECT c FROM Claim c WHERE c.hospitalAddress = :hospitalAddress"),
    @NamedQuery(name = "Claim.findByHospitalPhone", query = "SELECT c FROM Claim c WHERE c.hospitalPhone = :hospitalPhone"),
    @NamedQuery(name = "Claim.findByHospitalFax", query = "SELECT c FROM Claim c WHERE c.hospitalFax = :hospitalFax"),
    @NamedQuery(name = "Claim.findByHospitalEmail", query = "SELECT c FROM Claim c WHERE c.hospitalEmail = :hospitalEmail"),
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClaimDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date claimDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "ClaimReason", nullable = false, length = 400)
    private String claimReason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Attachment", nullable = false, length = 250)
    private String attachment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HospitalName", nullable = false, length = 50)
    private String hospitalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HospitalAddress", nullable = false, length = 50)
    private String hospitalAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HospitalPhone", nullable = false, length = 50)
    private String hospitalPhone;
    @Size(max = 50)
    @Column(name = "HospitalFax", length = 50)
    private String hospitalFax;
    @Size(max = 50)
    @Column(name = "HospitalEmail", length = 50)
    private String hospitalEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ClaimStatus", nullable = false, length = 10)
    private String claimStatus;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "InsuranceID", referencedColumnName = "InsuranceID", nullable = false)
    @ManyToOne(optional = false)
    private Insurance insuranceID;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
    @ManyToOne(optional = false)
    private Account accountID;

    public Claim() {
    }

    public Claim(Integer claimID) {
        this.claimID = claimID;
    }

    public Claim(Integer claimID, double claimAmount, Date claimDate, String claimReason, String attachment, String hospitalName, String hospitalAddress, String hospitalPhone, String claimStatus) {
        this.claimID = claimID;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimReason = claimReason;
        this.attachment = attachment;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.hospitalPhone = hospitalPhone;
        this.claimStatus = claimStatus;
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

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    public String getHospitalFax() {
        return hospitalFax;
    }

    public void setHospitalFax(String hospitalFax) {
        this.hospitalFax = hospitalFax;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
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
