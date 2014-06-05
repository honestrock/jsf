/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duyuru;

import com.ferhat.domains.Checkin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author ferhatseyrek
 */
public class duyuruBean {

    public Baglanti bag1=new Baglanti();
    private Duyurular duyuru;
    private Checkin rez;
  
    private PreparedStatement pr;
    private PreparedStatement pr1;
    public duyuruBean() {
        rez=new Checkin();
        duyuru=new Duyurular();
        duyuru.setBaslik("");
        duyuru.setIcerik("");
        duyuru.setOnay(1);
         bag1.baglan();
    }
    
     public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    

    
    public void rezervasyonYap(){
        try{
        
            
            pr1=bag1.baglan().prepareStatement("INSERT INTO `otel`.`CHECKIN`(`checkintarihi`,`checkouttarihi`,`alinanucret`,`gun`,`kisisayisi`,`kullanici`,`odano`) VALUES (?,?,?,?,?,?,?);");
            pr1.setDate(1, new java.sql.Date(rez.getCheckintarihi().getTime()));
            pr1.setDate(2,  new java.sql.Date(rez.getCheckouttarihi().getTime()));
            pr1.setInt(3, rez.getAlinanucret());
            pr1.setInt(4, rez.getGun());
            pr1.setInt(5, rez.getKisisayisi());
            pr1.setInt(6, rez.getKullanici());
            pr1.setInt(7, rez.getOdano());
            
            pr1.executeUpdate();
            
            RequestContext requestContext = RequestContext.getCurrentInstance();         
            requestContext.update("form:display");
            requestContext.execute("PF('dlg').show()");
            
           
        }catch(SQLException e){
            
      
        }
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

    /**
     * @return the rez
     */
    public Checkin getRez() {
        return rez;
    }

    /**
     * @param rez the rez to set
     */
    public void setRez(Checkin rez) {
        this.rez = rez;
    }
    
}
