/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ferhat.serviceimp;

import com.ferhat.domains.Odalar;
import com.ferhat.service.RoomService;
import duyuru.Baglanti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apple
 */
public class RoomServiceImp implements RoomService{

    private  PreparedStatement pr;
    public Baglanti baglanti;
    ArrayList<Odalar> o_liste;
    ArrayList<Odalar> o_liste2;
    public RoomServiceImp() {
        baglanti=new Baglanti();
    }

    
    
    
    
    @Override
    public ArrayList<Odalar> bringRooms() {
       o_liste=new ArrayList<>();
       
        try {
              pr = baglanti.baglan().prepareStatement("Select * from ODALAR");
             ResultSet rs = pr.executeQuery();
             
             while(rs.next()){
                 Odalar oda=new Odalar();
                 oda.setAlan(rs.getInt("alan"));
                 oda.setCephe(rs.getString("cephe"));
                 oda.setDurum(rs.getInt("durum"));
                 oda.setFiyat(rs.getInt("fiyat"));
                 oda.setTipi(rs.getString("tipi"));
                 oda.setYataksayisi(rs.getInt("yataksayisi"));
                 oda.setKisilik(rs.getInt("kisilik"));
                 
                 o_liste.add(oda);
             }
             
        } catch (Exception e) {
        }
       
       return o_liste;
    }

    @Override
    public ArrayList<Odalar> bringARooms(int state) {
        o_liste2=new ArrayList<>();
       
        try {
              pr = baglanti.baglan().prepareStatement("Select * from ODALAR where durum=?");
              
              pr.setInt(1, state);
              
              ResultSet rs = pr.executeQuery();
             
             while(rs.next()){
                 Odalar oda=new Odalar();
                 oda.setAlan(rs.getInt("alan"));
                 oda.setCephe(rs.getString("cephe"));
                 oda.setDurum(rs.getInt("durum"));
                 oda.setFiyat(rs.getInt("fiyat"));
                 oda.setTipi(rs.getString("tipi"));
                 oda.setYataksayisi(rs.getInt("yataksayisi"));
                 oda.setKisilik(rs.getInt("kisilik"));
                 
                 o_liste2.add(oda);
             }
             
        } catch (Exception e) {
        }
       
       return o_liste2;
      
    }

    @Override
    public void roomUpdate(int roomnumber) {
        try {
            pr = baglanti.baglan().prepareStatement("update odalar set durum=1 where odano=?");
            pr.setInt(1, roomnumber);
            pr.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(RoomServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
