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

public class PaymentMethodDTO  extends SuperDTO implements Serializable {
    
    private String pmid;
    private String reid;
    private String caid;
    private String csid;
    private String ckid;
    private String date;
    private double tax;
    private double discount;
    private double amount;
    private double balance;

    public PaymentMethodDTO() {
    }

    public PaymentMethodDTO(String pmid, String reid, String caid, String csid, String ckid, String date, double tax, double discount, double amount, double balance) {
        this.pmid = pmid;
        this.reid = reid;
        this.caid = caid;
        this.csid = csid;
        this.ckid = ckid;
        this.date = date;
        this.tax = tax;
        this.discount = discount;
        this.amount = amount;
        this.balance = balance;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getCsid() {
        return csid;
    }

    public void setCsid(String csid) {
        this.csid = csid;
    }

    public String getCkid() {
        return ckid;
    }

    public void setCkid(String ckid) {
        this.ckid = ckid;
    }
}
