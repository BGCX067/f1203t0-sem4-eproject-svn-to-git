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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author candy
 */
@Entity
@Table(name = "Admin", catalog = "ClaimProcessing", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdminUsername", query = "SELECT a FROM Admin a WHERE a.adminUsername = :adminUsername"),
    @NamedQuery(name = "Admin.findByAdminPassword", query = "SELECT a FROM Admin a WHERE a.adminPassword = :adminPassword")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AdminUsername", nullable = false, length = 50)
    private String adminUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AdminPassword", nullable = false, length = 50)
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminUsername != null ? adminUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminUsername == null && other.adminUsername != null) || (this.adminUsername != null && !this.adminUsername.equals(other.adminUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Admin[ adminUsername=" + adminUsername + " ]";
    }
    
}
