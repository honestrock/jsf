package duyuru;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferhatseyrek
 */
public class Baglanti {
    

    public Connection baglan() {
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
           


        } catch (Exception sqlException) {
            //sqlException.printStackTrace();
            System.out.println(sqlException.getMessage());
        }
        return  null;
        
    }
}
