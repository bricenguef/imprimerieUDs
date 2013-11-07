/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "temporaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporaire.findAll", query = "SELECT t FROM Temporaire t"),
    @NamedQuery(name = "Temporaire.findByIdpersonne", query = "SELECT t FROM Temporaire t WHERE t.idpersonne = :idpersonne"),
    @NamedQuery(name = "Temporaire.findByFaculte", query = "SELECT t FROM Temporaire t WHERE t.faculte = :faculte"),
    @NamedQuery(name = "Temporaire.findByFiliere", query = "SELECT t FROM Temporaire t WHERE t.filiere = :filiere"),
    @NamedQuery(name = "Temporaire.findByNiveau", query = "SELECT t FROM Temporaire t WHERE t.niveau = :niveau"),
    @NamedQuery(name = "Temporaire.findByNote", query = "SELECT t FROM Temporaire t WHERE t.note = :note"),
    @NamedQuery(name = "Temporaire.findByEtat", query = "SELECT t FROM Temporaire t WHERE t.etat = :etat")})
public class Temporaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersonne")
    private Integer idpersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "faculte")
    private String faculte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "filiere")
    private String filiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "niveau")
    private String niveau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "etat")
    private String etat;
    @JoinTable(name = "appartenir", joinColumns = {
        @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne")}, inverseJoinColumns = {
        @JoinColumn(name = "idvague", referencedColumnName = "idvague")})
    @ManyToMany
    private List<Vague> vagueList;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personnel personnel;

    public Temporaire() {
    }

    public Temporaire(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Temporaire(Integer idpersonne, String faculte, String filiere, String niveau, String note, String etat) {
        this.idpersonne = idpersonne;
        this.faculte = faculte;
        this.filiere = filiere;
        this.niveau = niveau;
        this.note = note;
        this.etat = etat;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Vague> getVagueList() {
        return vagueList;
    }

    public void setVagueList(List<Vague> vagueList) {
        this.vagueList = vagueList;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonne != null ? idpersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporaire)) {
            return false;
        }
        Temporaire other = (Temporaire) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Temporaire[ idpersonne=" + idpersonne + " ]";
    }
    
}