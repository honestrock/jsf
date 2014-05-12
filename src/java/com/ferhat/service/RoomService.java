/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ferhat.service;

import com.ferhat.domains.Odalar;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public interface RoomService {
    
    public ArrayList<Odalar> bringRooms();
    public ArrayList<Odalar> bringARooms(int state);
    public void roomUpdate(int roomnumber);
    
    
    
    
}
