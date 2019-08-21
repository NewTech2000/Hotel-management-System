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

public class ServiceDetailDTO  extends SuperDTO implements Serializable {
    
    private String sid;
    private String reid;

    public ServiceDetailDTO() {
    }

    public ServiceDetailDTO(String sid, String reid) {
        this.sid = sid;
        this.reid = reid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }

}
