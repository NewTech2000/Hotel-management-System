/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.SystemUserController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.SystemUserDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.SystemUserDTO;

/**
 *
 * @author USER
 */

public class SystemUserControllerImpl implements SystemUserController {

    private SystemUserDAO systemUserDAO;
    
    public SystemUserControllerImpl(){
        systemUserDAO =(SystemUserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SYSTEM_USER);
    }
    
    @Override
    public boolean add(SystemUserDTO systemUserDTO) throws Exception {
        return systemUserDAO.add(systemUserDTO);
    }

    @Override
    public boolean update(SystemUserDTO systemUserDTO) throws Exception {
        return systemUserDAO.update(systemUserDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return systemUserDAO.delete(key);
    }

    @Override
    public SystemUserDTO search(String key) throws Exception {
        return systemUserDAO.search(key);
    }

    @Override
    public ArrayList<SystemUserDTO> getAll() throws Exception {
        return systemUserDAO.getAll();
    }
    
    
}
