/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Okala
 */
@Entity
@Table(name = "validation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Validation.findAll", query = "SELECT v FROM Validation v")
    , @NamedQuery(name = "Validation.findById", query = "SELECT v FROM Validation v WHERE v.id = :id")
    , @NamedQuery(name = "Validation.findByToken", query = "SELECT v FROM Validation v WHERE v.token = :token")
    , @NamedQuery(name = "Validation.findByEmpId", query = "SELECT v FROM Validation v WHERE v.empId = :empId")
    , @NamedQuery(name = "Validation.findByIsactive", query = "SELECT v FROM Validation v WHERE v.isactive = :isactive")
    , @NamedQuery(name = "Validation.findByCreatedDate", query = "SELECT v FROM Validation v WHERE v.createdDate = :createdDate")})
public class Validation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 230)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_id")
    private int empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isactive")
    private String isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Validation() {
    }

    public Validation(Integer id) {
        this.id = id;
    }

    public Validation(Integer id, String token, int empId, String isactive, Date createdDate) {
        this.id = id;
        this.token = token;
        this.empId = empId;
        this.isactive = isactive;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Validation)) {
            return false;
        }
        Validation other = (Validation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eval.eval.entities.Validation[ id=" + id + " ]";
    }
    
}
