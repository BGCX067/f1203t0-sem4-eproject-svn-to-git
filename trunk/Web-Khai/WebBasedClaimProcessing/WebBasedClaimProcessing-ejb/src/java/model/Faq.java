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
@Table(name = "FAQ", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"FAQQuestion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
    @NamedQuery(name = "Faq.findByFaqid", query = "SELECT f FROM Faq f WHERE f.faqid = :faqid"),
    @NamedQuery(name = "Faq.findByFAQQuestion", query = "SELECT f FROM Faq f WHERE f.fAQQuestion = :fAQQuestion"),
    @NamedQuery(name = "Faq.findByFAQAnswer", query = "SELECT f FROM Faq f WHERE f.fAQAnswer = :fAQAnswer"),
    @NamedQuery(name = "Faq.findByFAQCreatedDate", query = "SELECT f FROM Faq f WHERE f.fAQCreatedDate = :fAQCreatedDate"),
    @NamedQuery(name = "Faq.findByStatus", query = "SELECT f FROM Faq f WHERE f.status = :status")})
public class Faq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAQID", nullable = false)
    private Integer faqid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "FAQQuestion", nullable = false, length = 400)
    private String fAQQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "FAQAnswer", nullable = false, length = 4000)
    private String fAQAnswer;
    @Size(max = 10)
    @Column(name = "FAQCreatedDate", length = 10)
    private String fAQCreatedDate;
    @Column(name = "Status")
    private Boolean status;

    public Faq() {
    }

    public Faq(Integer faqid) {
        this.faqid = faqid;
    }

    public Faq(Integer faqid, String fAQQuestion, String fAQAnswer) {
        this.faqid = faqid;
        this.fAQQuestion = fAQQuestion;
        this.fAQAnswer = fAQAnswer;
    }

    public Integer getFaqid() {
        return faqid;
    }

    public void setFaqid(Integer faqid) {
        this.faqid = faqid;
    }

    public String getFAQQuestion() {
        return fAQQuestion;
    }

    public void setFAQQuestion(String fAQQuestion) {
        this.fAQQuestion = fAQQuestion;
    }

    public String getFAQAnswer() {
        return fAQAnswer;
    }

    public void setFAQAnswer(String fAQAnswer) {
        this.fAQAnswer = fAQAnswer;
    }

    public String getFAQCreatedDate() {
        return fAQCreatedDate;
    }

    public void setFAQCreatedDate(String fAQCreatedDate) {
        this.fAQCreatedDate = fAQCreatedDate;
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
        hash += (faqid != null ? faqid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.faqid == null && other.faqid != null) || (this.faqid != null && !this.faqid.equals(other.faqid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Faq[ faqid=" + faqid + " ]";
    }
    
}
