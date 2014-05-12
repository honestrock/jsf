/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import duyuru.Baglanti;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UE-Studyo
 */
public class KullaniciBean {

    private Kullanici kullanicibilgi = new Kullanici();
    private String hatamesaji;
    private boolean loginYapildiMi;
    public Baglanti bag= new Baglanti();

    public boolean isLoginYapildiMi() {
        return loginYapildiMi;
    }

    public void setLoginYapildiMi(boolean loginYapildiMi) {
        this.loginYapildiMi = loginYapildiMi;
    }

    public String getHatamesaji() {
        return hatamesaji;
    }

    public void setHatamesaji(String hatamesaji) {
        this.hatamesaji = hatamesaji;
    }
    public Kullanici getKullanicibilgi() {
        return kullanicibilgi;
    }

    public void setKullanicibilgi(Kullanici kullanicibilgi) {
        this.kullanicibilgi = kullanicibilgi;
    }
    private Connection connection;
    private PreparedStatement titlesQuery;

    public KullaniciBean() {
        kullanicibilgi.setAdi("");
        kullanicibilgi.setCinsiyeti(0);
        kullanicibilgi.setEmail("");
        kullanicibilgi.setKullaniciadi("");
        kullanicibilgi.setSifre("");
        kullanicibilgi.setSoyadi("");
        kullanicibilgi.setYetki(2);
        bag.baglan();
    }

    public String girisYap() {
        try {           
           kullanicibilgi.setYetki(2);
            titlesQuery = bag.baglan().prepareStatement("SELECT * "
                    + "FROM KULLANICI where KULLANICIADI=? and SIFRE=?");
            titlesQuery.setString(1, kullanicibilgi.getKullaniciadi());
            titlesQuery.setString(2, kullanicibilgi.getSifre());
            ResultSet results = titlesQuery.executeQuery();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            HttpSession session = request.getSession();

            while (results.next()) {
                if(results.getString("KULLANICIADI").equals(kullanicibilgi.getKullaniciadi()) && results.getString("SIFRE").equals(kullanicibilgi.getSifre())){
                kullanicibilgi.setKullaniciadi(results.getString("KULLANICIADI"));
                kullanicibilgi.setAdi(results.getString("ADI"));
                kullanicibilgi.setSoyadi(results.getString("SOYADI"));
                kullanicibilgi.setCinsiyeti(results.getInt("CINSIYETI"));
                kullanicibilgi.setYetki(results.getInt("YETKI"));
                session.setAttribute("kadi", kullanicibilgi.getAdi());
                session.setAttribute("ksoyadi", kullanicibilgi.getSoyadi());
                }
            }
            if ( kullanicibilgi.getYetki() == 0) {
                setLoginYapildiMi(true);
                setHatamesaji("");
                return "admin";
            } else if (kullanicibilgi.getYetki() == 1) {
                setLoginYapildiMi(true);
                setHatamesaji("");
                return "kullanici";
            } else {
                setLoginYapildiMi(false);
                setHatamesaji("yanlış bilgi girildi");
                return "basarisiz";
            }
        } catch (SQLException ex) {
            return "basarisiz";
        }
    }
    public String cikisyap(){
        setLoginYapildiMi(false);
        kullanicibilgi.setKullaniciadi("");
        return "cikis";
    }
    
}


  
    