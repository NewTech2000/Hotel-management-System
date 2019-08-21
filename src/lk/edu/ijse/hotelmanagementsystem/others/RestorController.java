/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.others;

import java.io.IOException;

/**
 *
 * @author USER
 */
public class RestorController {
  public static int restorBackUp(String path)throws IOException,InterruptedException{
        String[] exCmd= new String[]{"mysql","HotelManagementSystem","--password=19960913","-e"," source"+path};
        Process runTime = Runtime.getRuntime().exec(exCmd);
        int res = runTime.waitFor();
        return res;
    }
    
}
