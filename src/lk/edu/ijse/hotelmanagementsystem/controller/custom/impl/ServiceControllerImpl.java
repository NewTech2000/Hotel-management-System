
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ServiceDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDTO;

/**
 *
 * @author USER
 */

public class ServiceControllerImpl implements ServiceController {

    private ServiceDAO serviceDAO;
    
    public ServiceControllerImpl(){
        serviceDAO =(ServiceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE);
    }
    
    @Override
    public boolean add(ServiceDTO serviceDTO) throws Exception {
        return serviceDAO.add(serviceDTO);
    }

    @Override
    public boolean update(ServiceDTO serviceDTO) throws Exception {
        return serviceDAO.update(serviceDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
       return serviceDAO.delete(key);
    }

    @Override
    public ServiceDTO search(String key) throws Exception {
        return serviceDAO.search(key);
    }

    @Override
    public ArrayList<ServiceDTO> getAll() throws Exception {
        return serviceDAO.getAll();
    }
}
