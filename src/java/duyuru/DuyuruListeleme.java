/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

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
    public DuyuruListeleme() {
        baglanti=new Baglanti();
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
    
    
}
