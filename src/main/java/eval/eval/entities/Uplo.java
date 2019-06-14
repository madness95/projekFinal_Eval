/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Okala
 */
@Entity
@Table(name = "uplo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uplo.findAll", query = "SELECT u FROM Uplo u")
    , @NamedQuery(name = "Uplo.findById", query = "SELECT u FROM Uplo u WHERE u.id = :id")
    , @NamedQuery(name = "Uplo.findByFile", query = "SELECT u FROM Uplo u WHERE u.file = :file")})
public class Uplo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "file")
    private String file;

    public Uplo() {
    }

    public Uplo(Integer id) {
        this.id = id;
    }

    public Uplo(Integer id, String file) {
        this.id = id;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
        if (!(object instanceof Uplo)) {
            return false;
        }
        Uplo other = (Uplo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eval.eval.entities.Uplo[ id=" + id + " ]";
    }
    
}
