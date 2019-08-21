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

public class CardDTO  extends SuperDTO implements Serializable {
    
    private String caid;
    private String bank;
    private String card_id;
    private double advances;
    private double amount;

    public CardDTO() {
    }

    public CardDTO(String caid, String bank, String card_id, double advances, double amount) {
        this.caid = caid;
        this.bank = bank;
        this.card_id = card_id;
        this.advances = advances;
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
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
