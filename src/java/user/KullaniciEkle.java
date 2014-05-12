/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import duyuru.Baglanti;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ferhatseyrek
 */
public class KullaniciEkle {

    public Baglanti bag2=new Baglanti();
    private Kullanici kullanicilar;
    private PreparedStatement pr;
            
    public KullaniciEkle() {
        kullanicilar=new Kullanici();
        kullanicilar.setAdi("");
       
         kullanicilar.setEmail("");
         kullanicilar.setKullaniciadi("");
         kullanicilar.setSifre("");
         kullanicilar.setSoyadi("");
        
         bag2.baglan();
    }
    public String KullaniciKaydet() {
        try {
          
          
           
            pr=bag2.baglan().prepareStatement("insert into KULLANICI(KULLANICIADI,SIFRE,ADI,SOYADI,EMAIL) values(?,?,?,?,?)");
            pr.setString(1, getKullanicilar().getKullaniciadi());
            pr.setString(2, getKullanicilar().getSifre());
            pr.setString(3, getKullanicilar().getAdi());
            pr.setString(4, getKullanicilar().getSoyadi());
            pr.setString(5, getKullanicilar().getEmail());
            pr.executeUpdate();
            return null;
        } catch (SQLException e) {
          
            return null;
        }
        
    }

    /**
     * @return the kullanicilar
     */
    public Kullanici getKullanicilar() {
        return kullanicilar;
    }

    /**
     * @param kullanicilar the kullanicilar to set
     */
    public void setKullanicilar(Kullanici kullanicilar) {
        this.kullanicilar = kullanicilar;
    }
    
}
