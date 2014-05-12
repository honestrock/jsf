/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ferhat.domains;

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
 * @author apple
 */
@Entity
@Table(name = "ODALAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odalar.findAll", query = "SELECT o FROM Odalar o"),
    @NamedQuery(name = "Odalar.findByOdano", query = "SELECT o FROM Odalar o WHERE o.odano = :odano"),
    @NamedQuery(name = "Odalar.findByKisilik", query = "SELECT o FROM Odalar o WHERE o.kisilik = :kisilik"),
    @NamedQuery(name = "Odalar.findByDurum", query = "SELECT o FROM Odalar o WHERE o.durum = :durum"),
    @NamedQuery(name = "Odalar.findByCephe", query = "SELECT o FROM Odalar o WHERE o.cephe = :cephe"),
    @NamedQuery(name = "Odalar.findByFiyat", query = "SELECT o FROM Odalar o WHERE o.fiyat = :fiyat"),
    @NamedQuery(name = "Odalar.findByTipi", query = "SELECT o FROM Odalar o WHERE o.tipi = :tipi"),
    @NamedQuery(name = "Odalar.findByYataksayisi", query = "SELECT o FROM Odalar o WHERE o.yataksayisi = :yataksayisi"),
    @NamedQuery(name = "Odalar.findByAlan", query = "SELECT o FROM Odalar o WHERE o.alan = :alan")})
public class Odalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "odano")
    private Integer odano;
    @Column(name = "kisilik")
    private Integer kisilik;
    @Column(name = "durum")
    private Integer durum;
    @Size(max = 15)
    @Column(name = "cephe")
    private String cephe;
    @Column(name = "fiyat")
    private Integer fiyat;
    @Size(max = 45)
    @Column(name = "tipi")
    private String tipi;
    @Column(name = "yataksayisi")
    private Integer yataksayisi;
    @Column(name = "alan")
    private Integer alan;

    public Odalar() {
    }

    public Odalar(Integer odano) {
        this.odano = odano;
    }

    public Integer getOdano() {
        return odano;
    }

    public void setOdano(Integer odano) {
        this.odano = odano;
    }

    public Integer getKisilik() {
        return kisilik;
    }

    public void setKisilik(Integer kisilik) {
        this.kisilik = kisilik;
    }

    public Integer getDurum() {
        return durum;
    }

    public void setDurum(Integer durum) {
        this.durum = durum;
    }

    public String getCephe() {
        return cephe;
    }

    public void setCephe(String cephe) {
        this.cephe = cephe;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public Integer getYataksayisi() {
        return yataksayisi;
    }

    public void setYataksayisi(Integer yataksayisi) {
        this.yataksayisi = yataksayisi;
    }

    public Integer getAlan() {
        return alan;
    }

    public void setAlan(Integer alan) {
        this.alan = alan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odano != null ? odano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odalar)) {
            return false;
        }
        Odalar other = (Odalar) object;
        if ((this.odano == null && other.odano != null) || (this.odano != null && !this.odano.equals(other.odano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferhat.domains.Odalar[ odano=" + odano + " ]";
    }
    
}
