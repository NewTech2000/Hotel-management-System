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

public class RoomDTO  extends SuperDTO implements Serializable {
    
    private String rid;
    private String room_type;
    private String room_floor;
    private String bed_type;
    private String room_decription;
    private String room_number;
    private double prices;

    public RoomDTO() {
    }

    public RoomDTO(String rid, String room_type, String room_floor, String bed_type, String room_decription, String room_number, double prices) {
        this.rid = rid;
        this.room_type = room_type;
        this.room_floor = room_floor;
        this.bed_type = bed_type;
        this.room_decription = room_decription;
        this.room_number = room_number;
        this.prices = prices;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_floor() {
        return room_floor;
    }

    public void setRoom_floor(String room_floor) {
        this.room_floor = room_floor;
    }

    public String getBed_type() {
        return bed_type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public String getRoom_decription() {
        return room_decription;
    }

    public void setRoom_decription(String room_decription) {
        this.room_decription = room_decription;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

}
