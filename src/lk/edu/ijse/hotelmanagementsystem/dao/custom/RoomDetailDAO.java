/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.dao.custom;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.dao.SuperDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;

/**
 *
 * @author USER
 */
public interface RoomDetailDAO extends SuperDAO<RoomDetailDTO> {

    public ArrayList<RoomDetailDTO> searchList(String name)throws Exception;    
    public ArrayList<RoomDetailDTO> getRoom(String name)throws Exception;
}
