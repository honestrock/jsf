/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

/**
 *
 * @author ferhatseyrek
 */
public class ListeBean {

    /**
     * Creates a new instance of ListeBean
     */
    
    public ListeBean() {
     private Integer no;
    private String adi;

    public ListeBean(Integer no, String adi) {
        this.no = no;
        this.adi = adi;
    }

    /**
     * @return the no
     */
    public Integer getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * @return the adi
     */
    public String getAdi() {
        return adi;
    }

    /**
     * @param adi the adi to set
     */
    public void setAdi(String adi) {
        this.adi = adi;
    }
    }
    

