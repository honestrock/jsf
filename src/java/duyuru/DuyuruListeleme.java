/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

import com.ferhat.domains.Checkin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ferhatseyrek
 */
public class DuyuruListeleme {

    /**
     * Creates a new instance of DuyurularListeleme
     */
   
        
        
        private  PreparedStatement pr;
    public Baglanti baglanti;
    private Checkin test;
    public DuyuruListeleme() {
        baglanti=new Baglanti();
        test=new Checkin();
    }
        
        
        
        public  ArrayList<Duyurular> duyuruGetir() {
        ArrayList<Duyurular> liste = new ArrayList<Duyurular>();
        try {
            pr = baglanti.baglan().prepareStatement("Select * from Duyurular where onay=?");
            pr.setInt(1, 1);
            
             ResultSet results = pr.executeQuery();
             while (results.next()) {
                Duyurular ad= new Duyurular();
                ad.setBaslik(results.getString("baslik"));
                ad.setIcerik(results.getString("icerik"));
                ad.setOnay(results.getInt("onay"));
                liste.add(ad);
            }
             
         
             
            return liste;
        } catch (Exception e) {
            return liste;
        }

    }
        
        public String rezarvasyonGetir() {
            
        ArrayList<Checkin> liste = new ArrayList<Checkin>();
        try {
            pr = baglanti.baglan().prepareStatement("SELECT * FROM otel.CHECKIN o where o.checkintarihi=? and o.checkouttarihi=?");
           
            pr.setDate(1, new java.sql.Date(getTest().getCheckintarihi().getTime()));
            pr.setDate(2, new java.sql.Date(getTest().getCheckouttarihi().getTime()));
             ResultSet results = pr.executeQuery();
             while (results.next()) {
               Checkin a=new Checkin();
               a.setCheckintarihi(results.getDate("checkintarihi"));
               a.setCheckouttarihi(results.getDate("checkouttarihi"));
               
               liste.add(a);
            }
             
          rezlist test=new rezlist();
          
          test.setListe(liste);
          
        
            return "/listele.xhtml";  
        
          
    
        } catch (Exception e) {
                return "/index.xhtml";
        }
            
    }
        
        public  ArrayList<Checkin> listele(ArrayList<Checkin> listele) {
       
            return listele;

         }

    /**
     * @return the test
     */
    public Checkin getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Checkin test) {
        this.test = test;
    }
    
    
}
