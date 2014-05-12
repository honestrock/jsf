/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferhatseyrek
 */
@Entity
@Table(name = "duyurular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duyurular.findAll", query = "SELECT d FROM Duyurular d"),
    @NamedQuery(name = "Duyurular.findByBaslik", query = "SELECT d FROM Duyurular d WHERE d.baslik = :baslik"),
    @NamedQuery(name = "Duyurular.findByIcerik", query = "SELECT d FROM Duyurular d WHERE d.icerik = :icerik"),
    @NamedQuery(name = "Duyurular.findByOnay", query = "SELECT d FROM Duyurular d WHERE d.onay = :onay")})
public class Duyurular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "baslik")
    private String baslik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "icerik")
    private String icerik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onay")
    private int onay;

    public Duyurular() {
    }

    public Duyurular(String baslik) {
        this.baslik = baslik;
    }

    public Duyurular(String baslik, String icerik, int onay) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.onay = onay;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getOnay() {
        return onay;
    }

    public void setOnay(int onay) {
        this.onay = onay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baslik != null ? baslik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duyurular)) {
            return false;
        }
        Duyurular other = (Duyurular) object;
        if ((this.baslik == null && other.baslik != null) || (this.baslik != null && !this.baslik.equals(other.baslik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duyuru.Duyurular[ baslik=" + baslik + " ]";
    }
    
}
