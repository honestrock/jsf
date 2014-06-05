/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

import com.ferhat.domains.Checkin;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class rezlist {

    /**
     * @return the liste
     */
    public static ArrayList<Checkin> getListe() {
        return liste;
    }

    /**
     * @param aListe the liste to set
     */
    public static void setListe(ArrayList<Checkin> aListe) {
        liste = aListe;
    }
    
    DuyuruListeleme listem=new DuyuruListeleme();
    private static ArrayList<Checkin> liste;

    public rezlist(ArrayList<Checkin> liste) {
             this.liste=liste;
    }
    
    public rezlist(){
   
    }
    
    
    
    public ArrayList<Checkin> don(){
       
        return getListe();
    }
    
}
