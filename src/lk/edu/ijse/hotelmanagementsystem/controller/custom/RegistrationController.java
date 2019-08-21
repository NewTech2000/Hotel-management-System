/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.SuperController;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RegistrationDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;

/**
 *
 * @author USER
 */
public interface RegistrationController extends SuperController<RegistrationDTO> {
    
    public boolean add(CustomerDTO customerDTO,RegistrationDTO dto, ArrayList<ServiceDetailDTO> alServiceDetails, ArrayList<RoomDetailDTO> alRoomDetails, ArrayList<FacilityDetailDTO> alFacilityDetails) throws Exception;
}
