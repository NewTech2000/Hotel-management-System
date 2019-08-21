/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.SuperController;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;

/**
 *
 * @author USER
 */
public interface ServiceDetailController extends SuperController<ServiceDetailDTO> {
 
    
    public ArrayList<ServiceDetailDTO> getSSSS(String name)throws Exception;  
}
