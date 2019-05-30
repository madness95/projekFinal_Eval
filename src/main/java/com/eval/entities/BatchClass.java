/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sofia
 */
@Entity
@Table(name = "batch_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchClass.findAll", query = "SELECT b FROM BatchClass b")
    , @NamedQuery(name = "BatchClass.findById", query = "SELECT b FROM BatchClass b WHERE b.id = :id")
    , @NamedQuery(name = "BatchClass.findByTrainer", query = "SELECT b FROM BatchClass b WHERE b.trainer = :trainer")
    , @NamedQuery(name = "BatchClass.findByIsdelete", query = "SELECT b FROM BatchClass b WHERE b.isdelete = :isdelete")
    , @NamedQuery(name = "BatchClass.findByLastUpdate", query = "SELECT b FROM BatchClass b WHERE b.lastUpdate = :lastUpdate")})
public class BatchClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trainer")
    private int trainer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private Character isdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchClass", fetch = FetchType.LAZY)
    private List<Exam> examList;
    @JoinColumn(name = "class", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Class class1;
    @JoinColumn(name = "batch", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Batch batch;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchclass", fetch = FetchType.LAZY)
    private List<Employees> employeesList;

    public BatchClass() {
    }

    public BatchClass(Integer id) {
        this.id = id;
    }

    public BatchClass(Integer id, int trainer, Character isdelete, Date lastUpdate) {
        this.id = id;
        this.trainer = trainer;
        this.isdelete = isdelete;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

    public Character getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Character isdelete) {
        this.isdelete = isdelete;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public Class getClass1() {
        return class1;
    }

    public void setClass1(Class class1) {
        this.class1 = class1;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
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
        if (!(object instanceof BatchClass)) {
            return false;
        }
        BatchClass other = (BatchClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eval.entities.BatchClass[ id=" + id + " ]";
    }
    
}
