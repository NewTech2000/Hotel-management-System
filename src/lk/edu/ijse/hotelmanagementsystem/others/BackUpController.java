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
public class BackUpController {
    
    public static int wrigthBackUp(String path)throws IOException,InterruptedException{
        
        Runtime runtime=Runtime.getRuntime();
        Process runPro=runtime.exec("mysqldump HotelManagementSystem -h localhost -u root -p19960913 -r"+path);
        int res=runPro.waitFor();
        return res;
    }
}
