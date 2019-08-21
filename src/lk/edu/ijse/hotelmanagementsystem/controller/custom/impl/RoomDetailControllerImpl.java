/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.PaymentMethodController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomDetailController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.PaymentMethodDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RoomDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;

/**
 *
 * @author USER
 */

public class RoomDetailControllerImpl implements RoomDetailController {

    private RoomDetailDAO roomDetailDAO;
    
    public RoomDetailControllerImpl(){
        roomDetailDAO =(RoomDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM_DETAIL);
    }

    @Override
    public boolean add(RoomDetailDTO roomDetailDTO) throws Exception {
        return roomDetailDAO.add(roomDetailDTO);
    }

    @Override
    public boolean update(RoomDetailDTO roomDetailDTO) throws Exception {
        return roomDetailDAO.update(roomDetailDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return roomDetailDAO.delete(key);
    }

    @Override
    public RoomDetailDTO search(String key) throws Exception {
        return roomDetailDAO.search(key);
    }
    
    public ArrayList<RoomDetailDTO> searchList(String name) throws Exception {
        return roomDetailDAO.searchList(name);
    }

    @Override
    public ArrayList<RoomDetailDTO> getAll() throws Exception {
        return roomDetailDAO.getAll();
    }

    @Override
    public ArrayList<RoomDetailDTO> getRoom(String name) throws Exception {
        return  roomDetailDAO.getRoom(name);
    }
}
