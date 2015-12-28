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
 * @author Duc
 */
@Entity
@Table(name = "News", catalog = "ClaimProcessing", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NewsTitle"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByNewsTitle", query = "SELECT n FROM News n WHERE n.newsTitle = :newsTitle"),
    @NamedQuery(name = "News.findByNewsDescription", query = "SELECT n FROM News n WHERE n.newsDescription = :newsDescription"),
    @NamedQuery(name = "News.findByNewsContent", query = "SELECT n FROM News n WHERE n.newsContent = :newsContent"),
    @NamedQuery(name = "News.findByNewsCreatedDate", query = "SELECT n FROM News n WHERE n.newsCreatedDate = :newsCreatedDate"),
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
    @Column(name = "NewsTitle", nullable = false, length = 50)
    private String newsTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NewsDescription", nullable = false, length = 50)
    private String newsDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "NewsContent", nullable = false, length = 4000)
    private String newsContent;
    @Size(max = 10)
    @Column(name = "NewsCreatedDate", length = 10)
    private String newsCreatedDate;
    @Column(name = "Status")
    private Boolean status;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public News(Integer newsID, String newsTitle, String newsDescription, String newsContent) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContent = newsContent;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsCreatedDate() {
        return newsCreatedDate;
    }

    public void setNewsCreatedDate(String newsCreatedDate) {
        this.newsCreatedDate = newsCreatedDate;
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
