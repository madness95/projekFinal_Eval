/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.entities;

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
 * @author sofia
 */
@Entity
@Table(name = "grade_emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradeEmp.findAll", query = "SELECT g FROM GradeEmp g")
    , @NamedQuery(name = "GradeEmp.findById", query = "SELECT g FROM GradeEmp g WHERE g.id = :id")
    , @NamedQuery(name = "GradeEmp.findByIsdelete", query = "SELECT g FROM GradeEmp g WHERE g.isdelete = :isdelete")
    , @NamedQuery(name = "GradeEmp.findByLastUpdate", query = "SELECT g FROM GradeEmp g WHERE g.lastUpdate = :lastUpdate")})
public class GradeEmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isdelete")
    private String isdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "grade", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grade grade;
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee student;

    public GradeEmp() {
    }

    public GradeEmp(Integer id) {
        this.id = id;
    }

    public GradeEmp(Integer id, String isdelete, Date lastUpdate) {
        this.id = id;
        this.isdelete = isdelete;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Employee getStudent() {
        return student;
    }

    public void setStudent(Employee student) {
        this.student = student;
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
        if (!(object instanceof GradeEmp)) {
            return false;
        }
        GradeEmp other = (GradeEmp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eval.entities.GradeEmp[ id=" + id + " ]";
    }
    
}
