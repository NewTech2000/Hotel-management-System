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

public class RoomDetailDTO extends SuperDTO implements Serializable {
    
    private String rid;
    private String reid;

    public RoomDetailDTO() {
    }

    public RoomDetailDTO(String rid, String reid) {
        this.rid = rid;
        this.reid = reid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }

}
