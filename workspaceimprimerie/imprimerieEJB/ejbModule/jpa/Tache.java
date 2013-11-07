/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcel
 */
@Entity
@Table(name = "tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findByIdtache", query = "SELECT t FROM Tache t WHERE t.idtache = :idtache"),
    @NamedQuery(name = "Tache.findByLibele", query = "SELECT t FROM Tache t WHERE t.libele = :libele"),
    @NamedQuery(name = "Tache.findByEtat", query = "SELECT t FROM Tache t WHERE t.etat = :etat")})
public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtache")
    private Integer idtache;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "libele")
    private String libele;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "etat")
    private String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tache")
    private List<Affecter> affecterList;

    public Tache() {
    }

    public Tache(Integer idtache) {
        this.idtache = idtache;
    }

    public Tache(Integer idtache, String libele, String etat) {
        this.idtache = idtache;
        this.libele = libele;
        this.etat = etat;
    }

    public Integer getIdtache() {
        return idtache;
    }

    public void setIdtache(Integer idtache) {
        this.idtache = idtache;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Affecter> getAffecterList() {
        return affecterList;
    }

    public void setAffecterList(List<Affecter> affecterList) {
        this.affecterList = affecterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtache != null ? idtache.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.idtache == null && other.idtache != null) || (this.idtache != null && !this.idtache.equals(other.idtache))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Tache[ idtache=" + idtache + " ]";
    }
    
}