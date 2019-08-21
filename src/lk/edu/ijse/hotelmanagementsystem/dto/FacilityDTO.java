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

public class FacilityDTO  extends SuperDTO implements Serializable {
    
    private String fid;
    private String facility_Name;
    private double prices;

    public FacilityDTO() {
    }

    public FacilityDTO(String fid, String facility_Name, double prices) {
        this.fid = fid;
        this.facility_Name = facility_Name;
        this.prices = prices;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFacility_Name() {
        return facility_Name;
    }

    public void setFacility_Name(String facility_Name) {
        this.facility_Name = facility_Name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    
}
