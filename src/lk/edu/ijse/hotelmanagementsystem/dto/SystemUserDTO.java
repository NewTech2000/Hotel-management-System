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

public class SystemUserDTO  extends SuperDTO implements Serializable {
    
    private String suid;
    private String userLevel;
    private String userName;
    private String password;

    public SystemUserDTO() {
    }

    public SystemUserDTO(String suid, String userLevel, String userName, String password) {
        this.suid = suid;
        this.userLevel = userLevel;
        this.userName = userName;
        this.password = password;
    }

    public SystemUserDTO(String suid) {
        this.suid = suid;
    }

    public SystemUserDTO(String suid, String userName, String password) {
        this.suid = suid;
        this.userName = userName;
        this.password = password;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
