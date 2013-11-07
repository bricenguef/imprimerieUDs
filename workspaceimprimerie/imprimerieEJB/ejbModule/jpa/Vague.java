/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcel
 */
@Entity
@Table(name = "vague")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vague.findAll", query = "SELECT v FROM Vague v"),
    @NamedQuery(name = "Vague.findByIdvague", query = "SELECT v FROM Vague v WHERE v.idvague = :idvague"),
    @NamedQuery(name = "Vague.findByIntitule", query = "SELECT v FROM Vague v WHERE v.intitule = :intitule"),
    @NamedQuery(name = "Vague.findByDatedebut", query = "SELECT v FROM Vague v WHERE v.datedebut = :datedebut"),
    @NamedQuery(name = "Vague.findByDatefin", query = "SELECT v FROM Vague v WHERE v.datefin = :datefin"),
    @NamedQuery(name = "Vague.findByActive", query = "SELECT v FROM Vague v WHERE v.active = :active")})
public class Vague implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvague")
    private Integer idvague;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "intitule")
    private String intitule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "active")
    private String active;
    @ManyToMany(mappedBy = "vagueList")
    private List<Temporaire> temporaireList;

    public Vague() {
    }

    public Vague(Integer idvague) {
        this.idvague = idvague;
    }

    public Vague(Integer idvague, String intitule, Date datedebut, Date datefin, String active) {
        this.idvague = idvague;
        this.intitule = intitule;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.active = active;
    }

    public Integer getIdvague() {
        return idvague;
    }

    public void setIdvague(Integer idvague) {
        this.idvague = idvague;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public List<Temporaire> getTemporaireList() {
        return temporaireList;
    }

    public void setTemporaireList(List<Temporaire> temporaireList) {
        this.temporaireList = temporaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvague != null ? idvague.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vague)) {
            return false;
        }
        Vague other = (Vague) object;
        if ((this.idvague == null && other.idvague != null) || (this.idvague != null && !this.idvague.equals(other.idvague))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Vague[ idvague=" + idvague + " ]";
    }
    
}