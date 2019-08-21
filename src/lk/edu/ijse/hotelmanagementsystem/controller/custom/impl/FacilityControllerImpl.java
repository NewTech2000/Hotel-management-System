/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.FacilityDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDTO;


/**
 *
 * @author USER
 */

public class FacilityControllerImpl implements FacilityController{

    private FacilityDAO facilityDAO;
    
    public FacilityControllerImpl(){
        facilityDAO =(FacilityDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FACILITY);
    }
    
    @Override
    public boolean add(FacilityDTO facilityDTO) throws Exception {
        System.out.println("facility controller impl");
        return facilityDAO.add(facilityDTO);
    }

    @Override
    public boolean update(FacilityDTO facilityDTO) throws Exception {
        return facilityDAO.update(facilityDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return facilityDAO.delete(key);
    }

    @Override
    public FacilityDTO search(String key) throws Exception {
        return facilityDAO.search(key);
    }

    @Override
    public ArrayList<FacilityDTO> getAll() throws Exception {
        return facilityDAO.getAll();
    }

    @Override
    public ArrayList<FacilityDTO> getFacility(String name) throws Exception {
        return  facilityDAO.getFacility(name);
    }
}
