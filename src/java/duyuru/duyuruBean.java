/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ferhatseyrek
 */
public class duyuruBean {

    public Baglanti bag1=new Baglanti();
    private Duyurular duyuru;
  
    private PreparedStatement pr;
    public duyuruBean() {
        duyuru=new Duyurular();
        duyuru.setBaslik("");
        duyuru.setIcerik("");
        duyuru.setOnay(1);
         bag1.baglan();
    }
    
    public String duyuruKaydet() {
        try {
          
            duyuru.setOnay(1);
           
            pr=bag1.baglan().prepareStatement("Insert into duyurular(baslik,icerik,onay) values(?,?,?)");
          
            pr.setString(1, duyuru.getBaslik());
          
            pr.setString(2, duyuru.getIcerik());
           
            pr.setInt(3, duyuru.getOnay());
           
            pr.executeUpdate();
            
           
            return null;
        } catch (SQLException e) {
          
            return null;
        }
        
    }

    /**
     * @return the duyuru
     */
    public Duyurular getDuyuru() {
        return duyuru;
    }

    /**
     * @param duyuru the duyuru to set
     */
    public void setDuyuru(Duyurular duyuru) {
        this.duyuru = duyuru;
    }
    
}
