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

public class CustomerDTO   extends SuperDTO implements Serializable {
    
    private String cid;
    private String fName;
    private String lName;
    private String email;
    private String address;
    private String country;
    private String pasportId;
    private String nic;
    private Integer tel;
    

    public CustomerDTO() {
        
    }

    public CustomerDTO(String cid, String fName, String lName, String email, String address, String country, String pasportId, String nic, Integer tel) {
        this.cid = cid;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;
        this.country = country;
        this.pasportId = pasportId;
        this.nic = nic;
        this.tel = tel;
    }


    public CustomerDTO(String cid) {
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFName() {
        return fName;
    }

    public String getPasportId() {
        return pasportId;
    }

    public void setPasportId(String pasportId) {
        this.pasportId = pasportId;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
