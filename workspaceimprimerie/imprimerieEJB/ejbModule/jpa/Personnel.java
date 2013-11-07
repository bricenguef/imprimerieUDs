/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
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
@Table(name = "personnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByIdpersonne", query = "SELECT p FROM Personnel p WHERE p.idpersonne = :idpersonne"),
    @NamedQuery(name = "Personnel.findByNompersonnel", query = "SELECT p FROM Personnel p WHERE p.nompersonnel = :nompersonnel"),
    @NamedQuery(name = "Personnel.findByDatenaissance", query = "SELECT p FROM Personnel p WHERE p.datenaissance = :datenaissance"),
    @NamedQuery(name = "Personnel.findByEmail", query = "SELECT p FROM Personnel p WHERE p.email = :email"),
    @NamedQuery(name = "Personnel.findByTel", query = "SELECT p FROM Personnel p WHERE p.tel = :tel"),
    @NamedQuery(name = "Personnel.findByCode", query = "SELECT p FROM Personnel p WHERE p.code = :code"),
    @NamedQuery(name = "Personnel.findByStatut", query = "SELECT p FROM Personnel p WHERE p.statut = :statut"),
    @NamedQuery(name = "Personnel.findByGrade", query = "SELECT p FROM Personnel p WHERE p.grade = :grade"),
    @NamedQuery(name = "Personnel.findByDepartement", query = "SELECT p FROM Personnel p WHERE p.departement = :departement")})
public class Personnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private Integer idpersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nompersonnel")
    private String nompersonnel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "departement")
    private String departement;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personnel")
    private Temporaire temporaire;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idpersonne")
    private Compte compte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
    private List<Affecter> affecterList;

    public Personnel() {
    }

    public Personnel(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Personnel(Integer idpersonne, String nompersonnel, Date datenaissance, String email, String tel, String code, String statut, String grade, String departement) {
        this.idpersonne = idpersonne;
        this.nompersonnel = nompersonnel;
        this.datenaissance = datenaissance;
        this.email = email;
        this.tel = tel;
        this.code = code;
        this.statut = statut;
        this.grade = grade;
        this.departement = departement;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getNompersonnel() {
        return nompersonnel;
    }

    public void setNompersonnel(String nompersonnel) {
        this.nompersonnel = nompersonnel;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Temporaire getTemporaire() {
        return temporaire;
    }

    public void setTemporaire(Temporaire temporaire) {
        this.temporaire = temporaire;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
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
        hash += (idpersonne != null ? idpersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Personnel[ idpersonne=" + idpersonne + " ]";
    }
    
}