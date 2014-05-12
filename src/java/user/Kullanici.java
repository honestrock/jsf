/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

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
@Table(name = "KULLANICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findByKullaniciadi", query = "SELECT k FROM Kullanici k WHERE k.kullaniciadi = :kullaniciadi"),
    @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi"),
    @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi"),
    @NamedQuery(name = "Kullanici.findByEmail", query = "SELECT k FROM Kullanici k WHERE k.email = :email"),
    @NamedQuery(name = "Kullanici.findByCinsiyeti", query = "SELECT k FROM Kullanici k WHERE k.cinsiyeti = :cinsiyeti"),
    @NamedQuery(name = "Kullanici.findByYetki", query = "SELECT k FROM Kullanici k WHERE k.yetki = :yetki")})
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "KULLANICIADI")
    private String kullaniciadi;
    @Size(max = 45)
    @Column(name = "SIFRE")
    private String sifre;
    @Size(max = 45)
    @Column(name = "ADI")
    private String adi;
    @Size(max = 45)
    @Column(name = "SOYADI")
    private String soyadi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CINSIYETI")
    private Integer cinsiyeti;
    @Column(name = "YETKI")
    private Integer yetki;

    public Kullanici() {
    }

    public Kullanici(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(Integer cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public Integer getYetki() {
        return yetki;
    }

    public void setYetki(Integer yetki) {
        this.yetki = yetki;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciadi != null ? kullaniciadi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciadi == null && other.kullaniciadi != null) || (this.kullaniciadi != null && !this.kullaniciadi.equals(other.kullaniciadi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user.Kullanici[ kullaniciadi=" + kullaniciadi + " ]";
    }
    
}
