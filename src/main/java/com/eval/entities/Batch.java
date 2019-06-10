/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author sofia
 */
@Entity
@Table(name = "batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batch.findAll", query = "SELECT b FROM Batch b")
    , @NamedQuery(name = "Batch.findById", query = "SELECT b FROM Batch b WHERE b.id = :id")
    , @NamedQuery(name = "Batch.findByBatch", query = "SELECT b FROM Batch b WHERE b.batch = :batch")
    , @NamedQuery(name = "Batch.findByPeriod", query = "SELECT b FROM Batch b WHERE b.period = :period")
    , @NamedQuery(name = "Batch.findByTrainer", query = "SELECT b FROM Batch b WHERE b.trainer = :trainer")
    , @NamedQuery(name = "Batch.findByIsdelete", query = "SELECT b FROM Batch b WHERE b.isdelete = :isdelete")
    , @NamedQuery(name = "Batch.findByLastupdate", query = "SELECT b FROM Batch b WHERE b.lastupdate = :lastupdate")})
public class Batch implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "batch")
    private String batch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period")
    @Temporal(TemporalType.DATE)    
    private Date period;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trainer")
    private int trainer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isdelete")
    private String isdelete;
    @OneToMany(mappedBy = "batchclass", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "lastupdate")
    @DateTimeFormat (pattern = "YYYY-mm-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @JoinColumn(name = "classid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Class classid;

    public Batch() {
    }

    public Batch(Integer id) {
        this.id = id;
    }

    public Batch(Integer id, String batch, Date period, int trainer, String isdelete, Date lastupdate) {
        this.id = id;
        this.batch = batch;
        this.period = period;
        this.trainer = trainer;
        this.isdelete = isdelete;
        this.lastupdate = lastupdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Class getClassid() {
        return classid;
    }

    public void setClassid(Class classid) {
        this.classid = classid;
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
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eval.entities.Batch[ id=" + id + " ]";
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
    
}
