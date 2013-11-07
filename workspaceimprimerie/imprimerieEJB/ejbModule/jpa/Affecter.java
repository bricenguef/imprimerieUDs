/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author marcel
 */
@Entity
@Table(name = "affecter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affecter.findAll", query = "SELECT a FROM Affecter a"),
    @NamedQuery(name = "Affecter.findByIdpersonne", query = "SELECT a FROM Affecter a WHERE a.affecterPK.idpersonne = :idpersonne"),
    @NamedQuery(name = "Affecter.findByIdtache", query = "SELECT a FROM Affecter a WHERE a.affecterPK.idtache = :idtache"),
    @NamedQuery(name = "Affecter.findByDate", query = "SELECT a FROM Affecter a WHERE a.date = :date"),
    @NamedQuery(name = "Affecter.findByHeuredebut", query = "SELECT a FROM Affecter a WHERE a.heuredebut = :heuredebut"),
    @NamedQuery(name = "Affecter.findByHeurefin", query = "SELECT a FROM Affecter a WHERE a.heurefin = :heurefin"),
    @NamedQuery(name = "Affecter.findByHeuredebutsup", query = "SELECT a FROM Affecter a WHERE a.heuredebutsup = :heuredebutsup"),
    @NamedQuery(name = "Affecter.findByHeurefinsup", query = "SELECT a FROM Affecter a WHERE a.heurefinsup = :heurefinsup"),
    @NamedQuery(name = "Affecter.findByEtat", query = "SELECT a FROM Affecter a WHERE a.etat = :etat")})
public class Affecter implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AffecterPK affecterPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heuredebut")
    @Temporal(TemporalType.TIME)
    private Date heuredebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heurefin")
    @Temporal(TemporalType.TIME)
    private Date heurefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heuredebutsup")
    @Temporal(TemporalType.TIME)
    private Date heuredebutsup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heurefinsup")
    @Temporal(TemporalType.TIME)
    private Date heurefinsup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "etat")
    private String etat;
    @JoinColumn(name = "idtache", referencedColumnName = "idtache", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tache tache;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personnel personnel;

    public Affecter() {
    }

    public Affecter(AffecterPK affecterPK) {
        this.affecterPK = affecterPK;
    }

    public Affecter(AffecterPK affecterPK, Date date, Date heuredebut, Date heurefin, Date heuredebutsup, Date heurefinsup, String etat) {
        this.affecterPK = affecterPK;
        this.date = date;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
        this.heuredebutsup = heuredebutsup;
        this.heurefinsup = heurefinsup;
        this.etat = etat;
    }

    public Affecter(int idpersonne, int idtache) {
        this.affecterPK = new AffecterPK(idpersonne, idtache);
    }

    public AffecterPK getAffecterPK() {
        return affecterPK;
    }

    public void setAffecterPK(AffecterPK affecterPK) {
        this.affecterPK = affecterPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(Date heuredebut) {
        this.heuredebut = heuredebut;
    }

    public Date getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(Date heurefin) {
        this.heurefin = heurefin;
    }

    public Date getHeuredebutsup() {
        return heuredebutsup;
    }

    public void setHeuredebutsup(Date heuredebutsup) {
        this.heuredebutsup = heuredebutsup;
    }

    public Date getHeurefinsup() {
        return heurefinsup;
    }

    public void setHeurefinsup(Date heurefinsup) {
        this.heurefinsup = heurefinsup;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
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
        hash += (affecterPK != null ? affecterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affecter)) {
            return false;
        }
        Affecter other = (Affecter) object;
        if ((this.affecterPK == null && other.affecterPK != null) || (this.affecterPK != null && !this.affecterPK.equals(other.affecterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Affecter[ affecterPK=" + affecterPK + " ]";
    }
    
}