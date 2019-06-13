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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Okala
 */
@Entity
@Table(name = "forget_password")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForgetPassword.findAll", query = "SELECT f FROM ForgetPassword f")
    , @NamedQuery(name = "ForgetPassword.findById", query = "SELECT f FROM ForgetPassword f WHERE f.id = :id")
    , @NamedQuery(name = "ForgetPassword.findByToken", query = "SELECT f FROM ForgetPassword f WHERE f.token = :token")
    , @NamedQuery(name = "ForgetPassword.findByIsactive", query = "SELECT f FROM ForgetPassword f WHERE f.isactive = :isactive")
    , @NamedQuery(name = "ForgetPassword.findByCreateDate", query = "SELECT f FROM ForgetPassword f WHERE f.createDate = :createDate")})
public class ForgetPassword implements Serializable {

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
    @Size(min = 1, max = 5)
    @Column(name = "isactive")
    private String isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee empId;

    public ForgetPassword() {
    }

    public ForgetPassword(Integer id) {
        this.id = id;
    }

    public ForgetPassword(Integer id, String token, String isactive, Date createDate, Employee empId) {
        this.id = id;
        this.token = token;
        this.isactive = isactive;
        this.createDate = createDate;
        this.empId = empId;
    }
    
    public ForgetPassword(Integer id, String token, String isactive, Date createDate) {
        this.id = id;
        this.token = token;
        this.isactive = isactive;
        this.createDate = createDate;
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

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
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
        if (!(object instanceof ForgetPassword)) {
            return false;
        }
        ForgetPassword other = (ForgetPassword) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eval.eval.entities.ForgetPassword[ id=" + id + " ]";
    }
    
}
