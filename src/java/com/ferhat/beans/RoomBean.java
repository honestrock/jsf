/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ferhat.beans;

import com.ferhat.domains.Odalar;
import com.ferhat.serviceimp.RoomServiceImp;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class RoomBean {


    RoomServiceImp rmp;
    
    public RoomBean() {
        rmp=new RoomServiceImp();
        rmp.roomUpdate(1);
    }
    
   public ArrayList<Odalar> bringRooms(){
       ArrayList<Odalar> liste=rmp.bringRooms();
       
       return liste;
   }

    /**
     * @return the liste
     */
   

    
}
