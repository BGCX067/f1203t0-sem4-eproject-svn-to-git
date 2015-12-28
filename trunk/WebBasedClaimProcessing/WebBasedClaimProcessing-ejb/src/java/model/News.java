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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "News", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByContent", query = "SELECT n FROM News n WHERE n.content = :content"),
    @NamedQuery(name = "News.findByCreatedDate", query = "SELECT n FROM News n WHERE n.createdDate = :createdDate"),
    @NamedQuery(name = "News.findByStatus", query = "SELECT n FROM News n WHERE n.status = :status")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewsID", nullable = false)
    private Integer newsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "Content", nullable = false, length = 4000)
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "Status")
    private Boolean status;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public News(Integer newsID, String title, String content, Date createdDate) {
        this.newsID = newsID;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.News[ newsID=" + newsID + " ]";
    }
    
}
