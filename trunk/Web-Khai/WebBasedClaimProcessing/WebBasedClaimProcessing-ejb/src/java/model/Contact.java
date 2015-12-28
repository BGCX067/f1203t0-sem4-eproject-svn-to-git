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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author candy
 */
@Entity
@Table(name = "Contact", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ContactTitle"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactID", query = "SELECT c FROM Contact c WHERE c.contactID = :contactID"),
    @NamedQuery(name = "Contact.findByContactTitle", query = "SELECT c FROM Contact c WHERE c.contactTitle = :contactTitle"),
    @NamedQuery(name = "Contact.findByContactName", query = "SELECT c FROM Contact c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "Contact.findByContactEmail", query = "SELECT c FROM Contact c WHERE c.contactEmail = :contactEmail"),
    @NamedQuery(name = "Contact.findByContactContent", query = "SELECT c FROM Contact c WHERE c.contactContent = :contactContent"),
    @NamedQuery(name = "Contact.findByContactCreatedDate", query = "SELECT c FROM Contact c WHERE c.contactCreatedDate = :contactCreatedDate"),
    @NamedQuery(name = "Contact.findByStatus", query = "SELECT c FROM Contact c WHERE c.status = :status")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactID", nullable = false)
    private Integer contactID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ContactTitle", nullable = false, length = 50)
    private String contactTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ContactName", nullable = false, length = 50)
    private String contactName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ContactEmail", nullable = false, length = 50)
    private String contactEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "ContactContent", nullable = false, length = 400)
    private String contactContent;
    @Size(max = 10)
    @Column(name = "ContactCreatedDate", length = 10)
    private String contactCreatedDate;
    @Column(name = "Status")
    private Boolean status;

    public Contact() {
    }

    public Contact(Integer contactID) {
        this.contactID = contactID;
    }

    public Contact(Integer contactID, String contactTitle, String contactName, String contactEmail, String contactContent) {
        this.contactID = contactID;
        this.contactTitle = contactTitle;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactContent = contactContent;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactContent() {
        return contactContent;
    }

    public void setContactContent(String contactContent) {
        this.contactContent = contactContent;
    }

    public String getContactCreatedDate() {
        return contactCreatedDate;
    }

    public void setContactCreatedDate(String contactCreatedDate) {
        this.contactCreatedDate = contactCreatedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contact[ contactID=" + contactID + " ]";
    }
    
}
