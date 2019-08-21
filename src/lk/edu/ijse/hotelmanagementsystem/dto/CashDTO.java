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

public class CashDTO  extends SuperDTO implements Serializable {
    
    private String csid;
    private double advances;
    private double amount;

    public CashDTO() {
    }

    public CashDTO(String csid, double advances, double amount) {
        this.csid = csid;
        this.advances = advances;
        this.amount = amount;
    }

    public String getCsid() {
        return csid;
    }

    public void setCsid(String csid) {
        this.csid = csid;
    }

    public double getAdvances() {
        return advances;
    }

    public void setAdvances(double advances) {
        this.advances = advances;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
