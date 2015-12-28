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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Contact", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactID", query = "SELECT c FROM Contact c WHERE c.contactID = :contactID"),
    @NamedQuery(name = "Contact.findByTitle", query = "SELECT c FROM Contact c WHERE c.title = :title"),
    @NamedQuery(name = "Contact.findByName", query = "SELECT c FROM Contact c WHERE c.name = :name"),
    @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email"),
    @NamedQuery(name = "Contact.findByContent", query = "SELECT c FROM Contact c WHERE c.content = :content"),
    @NamedQuery(name = "Contact.findByCreatedDate", query = "SELECT c FROM Contact c WHERE c.createdDate = :createdDate"),
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
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "Content", nullable = false, length = 400)
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "Status")
    private Boolean status;

    public Contact() {
    }

    public Contact(Integer contactID) {
        this.contactID = contactID;
    }

    public Contact(Integer contactID, String title, String name, String email, String content, Date createdDate) {
        this.contactID = contactID;
        this.title = title;
        this.name = name;
        this.email = email;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
