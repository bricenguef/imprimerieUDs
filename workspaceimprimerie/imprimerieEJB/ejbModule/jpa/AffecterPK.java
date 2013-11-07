/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marcel
 */
@Embeddable
public class AffecterPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersonne")
    private int idpersonne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtache")
    private int idtache;

    public AffecterPK() {
    }

    public AffecterPK(int idpersonne, int idtache) {
        this.idpersonne = idpersonne;
        this.idtache = idtache;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    public int getIdtache() {
        return idtache;
    }

    public void setIdtache(int idtache) {
        this.idtache = idtache;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpersonne;
        hash += (int) idtache;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AffecterPK)) {
            return false;
        }
        AffecterPK other = (AffecterPK) object;
        if (this.idpersonne != other.idpersonne) {
            return false;
        }
        if (this.idtache != other.idtache) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.AffecterPK[ idpersonne=" + idpersonne + ", idtache=" + idtache + " ]";
    }
    
}