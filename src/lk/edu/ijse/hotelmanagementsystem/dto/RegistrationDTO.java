/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.dto;

import java.io.Serializable;

/**
 *
 * @author USER
 */

public class RegistrationDTO  extends SuperDTO implements Serializable {
    
    private String reid;
    private String cid;
    private String checkin;
    private String checkout;
    private int no_of_rooms;
    private String no_of_adults;
    private String no_of_children;
    private String meal_type;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String reid, String cid, String checkin, String checkout, int no_of_rooms, String no_of_adults, String no_of_children, String meal_type) {
        this.reid = reid;
        this.cid = cid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.no_of_rooms = no_of_rooms;
        this.no_of_adults = no_of_adults;
        this.no_of_children = no_of_children;
        this.meal_type = meal_type;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public String getNo_of_adults() {
        return no_of_adults;
    }

    public void setNo_of_adults(String no_of_adults) {
        this.no_of_adults = no_of_adults;
    }

    public String getNo_of_children() {
        return no_of_children;
    }

    public void setNo_of_children(String no_of_children) {
        this.no_of_children = no_of_children;
    }

}
