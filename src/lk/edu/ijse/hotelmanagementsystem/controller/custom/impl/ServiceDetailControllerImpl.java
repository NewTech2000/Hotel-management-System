/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceDetailController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ServiceDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;

/**
 *
 * @author USER
 */

public class ServiceDetailControllerImpl implements ServiceDetailController {

    private ServiceDetailDAO serviceDetailDAO;
    
    public ServiceDetailControllerImpl(){
        serviceDetailDAO =(ServiceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE_DETAIL);
    }

    @Override
    public boolean add(ServiceDetailDTO serviceDetailDTO) throws Exception {
        return serviceDetailDAO.add(serviceDetailDTO);
    }

    @Override
    public boolean update(ServiceDetailDTO serviceDetailDTO) throws Exception {
        return serviceDetailDAO.update(serviceDetailDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return serviceDetailDAO.delete(key);
    }

    @Override
    public ServiceDetailDTO search(String key) throws Exception {
        return serviceDetailDAO.search(key);
    }

    @Override
    public ArrayList<ServiceDetailDTO> getAll() throws Exception {
        return serviceDetailDAO.getAll();
    }

    @Override
    public ArrayList<ServiceDetailDTO> getSSSS(String name) throws Exception {
        return serviceDetailDAO.getSSSS(name);
    }
}
