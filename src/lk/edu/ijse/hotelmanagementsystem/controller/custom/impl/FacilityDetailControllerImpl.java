/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityDetailController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.FacilityDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;

/**
 *
 * @author USER
 */

public class FacilityDetailControllerImpl implements FacilityDetailController{

    private FacilityDetailDAO facilityDetailDAO;
    
    public FacilityDetailControllerImpl(){
        facilityDetailDAO =(FacilityDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FACILITY_DETAIL);
    }
    
    @Override
    public boolean add(FacilityDetailDTO facilityDetailDTO) throws Exception {
        return facilityDetailDAO.add(facilityDetailDTO);
    }

    @Override
    public boolean update(FacilityDetailDTO facilityDetailDTO) throws Exception {
        return facilityDetailDAO.update(facilityDetailDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return facilityDetailDAO.delete(key);
    }

    @Override
    public FacilityDetailDTO search(String key) throws Exception {
        return facilityDetailDAO.search(key);
    }

    @Override
    public ArrayList<FacilityDetailDTO> getAll() throws Exception {
        return facilityDetailDAO.getAll();
    }

    @Override
    public ArrayList<FacilityDetailDTO> getFacility(String name) throws Exception {
        return  facilityDetailDAO.getFacility(name);
    }
}
