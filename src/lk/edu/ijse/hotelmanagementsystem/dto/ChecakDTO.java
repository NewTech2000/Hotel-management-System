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

public class ChecakDTO  extends SuperDTO implements Serializable {
    
    private String ckid;
    private String bank;
    private String check_id;
    private double advances;
    private double amount;

    public ChecakDTO() {
    }

    public ChecakDTO(String ckid, String bank, String check_id, double advances, double amount) {
        this.ckid = ckid;
        this.bank = bank;
        this.check_id = check_id;
        this.advances = advances;
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public String getCkid() {
        return ckid;
    }

    public void setCkid(String ckid) {
        this.ckid = ckid;
    }

    public String getCheck_id() {
        return check_id;
    }

    public void setCheck_id(String check_id) {
        this.check_id = check_id;
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
