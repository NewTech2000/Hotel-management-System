/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RoomDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDTO;

/**
 *
 * @author USER
 */

public class RoomControllerImpl implements RoomController {

    private RoomDAO roomDAO;
    
    public RoomControllerImpl(){
        roomDAO =(RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    }
    
    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.add(roomDTO);
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(roomDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return roomDAO.delete(key);
    }

    @Override
    public RoomDTO search(String key) throws Exception {
        return roomDAO.search(key);
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
        return roomDAO.getAll();
    }
}
