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

public class FacilityDetailDTO  extends SuperDTO implements Serializable {
    
    private String fid;
    private String reid;

    public FacilityDetailDTO() {
    }

    public FacilityDetailDTO(String fid, String reid) {
        this.fid = fid;
        this.reid = reid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }
    
    
}
