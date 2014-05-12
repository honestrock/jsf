
import duyuru.Duyurular;
import duyuru.DuyuruListeleme;
import java.util.ArrayList;
import user.Kullanici;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferhatseyrek
 */
public class NewClass {
    public static void main(String[] args) {
        DuyuruListeleme d= new DuyuruListeleme();
        ArrayList<Duyurular> list=d.duyuruGetir();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getBaslik());
        }
    }
}
