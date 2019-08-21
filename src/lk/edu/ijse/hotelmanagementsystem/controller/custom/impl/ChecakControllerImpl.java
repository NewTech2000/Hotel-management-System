/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ChecakController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ChecakDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;

/**
 *
 * @author USER
 */

public class ChecakControllerImpl implements ChecakController {

    private ChecakDAO checakDAO;
    
    public ChecakControllerImpl(){
        checakDAO =(ChecakDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHECAK);
    }

    @Override
    public boolean add(ChecakDTO checakDTO) throws Exception {
        return checakDAO.add(checakDTO);
    }

    @Override
    public boolean update(ChecakDTO checakDTO) throws Exception {
        return checakDAO.update(checakDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return checakDAO.delete(key);
    }

    @Override
    public ChecakDTO search(String key) throws Exception {
        return checakDAO.search(key);
    }

    @Override
    public ArrayList<ChecakDTO> getAll() throws Exception {
        return checakDAO.getAll();
    }
}