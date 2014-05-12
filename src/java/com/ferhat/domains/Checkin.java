/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ferhat.domains;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apple
 */
@Entity
@Table(name = "CHECKIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkin.findAll", query = "SELECT c FROM Checkin c"),
    @NamedQuery(name = "Checkin.findById", query = "SELECT c FROM Checkin c WHERE c.id = :id"),
    @NamedQuery(name = "Checkin.findByCheckintarihi", query = "SELECT c FROM Checkin c WHERE c.checkintarihi = :checkintarihi"),
    @NamedQuery(name = "Checkin.findByCheckouttarihi", query = "SELECT c FROM Checkin c WHERE c.checkouttarihi = :checkouttarihi"),
    @NamedQuery(name = "Checkin.findByAlinanucret", query = "SELECT c FROM Checkin c WHERE c.alinanucret = :alinanucret"),
    @NamedQuery(name = "Checkin.findByGun", query = "SELECT c FROM Checkin c WHERE c.gun = :gun"),
    @NamedQuery(name = "Checkin.findByKisisayisi", query = "SELECT c FROM Checkin c WHERE c.kisisayisi = :kisisayisi"),
    @NamedQuery(name = "Checkin.findByKullanici", query = "SELECT c FROM Checkin c WHERE c.kullanici = :kullanici"),
    @NamedQuery(name = "Checkin.findByOdano", query = "SELECT c FROM Checkin c WHERE c.odano = :odano")})
public class Checkin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkintarihi")
    @Temporal(TemporalType.DATE)
    private Date checkintarihi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkouttarihi")
    @Temporal(TemporalType.DATE)
    private Date checkouttarihi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alinanucret")
    private int alinanucret;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gun")
    private int gun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kisisayisi")
    private int kisisayisi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kullanici")
    private int kullanici;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odano")
    private int odano;

    public Checkin() {
    }

    public Checkin(Integer id) {
        this.id = id;
    }

    public Checkin(Integer id, Date checkintarihi, Date checkouttarihi, int alinanucret, int gun, int kisisayisi, int kullanici, int odano) {
        this.id = id;
        this.checkintarihi = checkintarihi;
        this.checkouttarihi = checkouttarihi;
        this.alinanucret = alinanucret;
        this.gun = gun;
        this.kisisayisi = kisisayisi;
        this.kullanici = kullanici;
        this.odano = odano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckintarihi() {
        return checkintarihi;
    }

    public void setCheckintarihi(Date checkintarihi) {
        this.checkintarihi = checkintarihi;
    }

    public Date getCheckouttarihi() {
        return checkouttarihi;
    }

    public void setCheckouttarihi(Date checkouttarihi) {
        this.checkouttarihi = checkouttarihi;
    }

    public int getAlinanucret() {
        return alinanucret;
    }

    public void setAlinanucret(int alinanucret) {
        this.alinanucret = alinanucret;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int getKisisayisi() {
        return kisisayisi;
    }

    public void setKisisayisi(int kisisayisi) {
        this.kisisayisi = kisisayisi;
    }

    public int getKullanici() {
        return kullanici;
    }

    public void setKullanici(int kullanici) {
        this.kullanici = kullanici;
    }

    public int getOdano() {
        return odano;
    }

    public void setOdano(int odano) {
        this.odano = odano;
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
        if (!(object instanceof Checkin)) {
            return false;
        }
        Checkin other = (Checkin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferhat.domains.Checkin[ id=" + id + " ]";
    }
    
}
