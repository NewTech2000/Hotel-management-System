/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RegistrationController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CustomerDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.FacilityDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RegistrationDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RoomDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ServiceDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RegistrationDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;

/**
 *
 * @author USER
 */

public class RegistrationControllerImpl implements RegistrationController {

    private RegistrationDAO registrationDAO;
    private ServiceDetailDAO serviceDetailDAO;
    private RoomDetailDAO roomDetailDAO;
    private FacilityDetailDAO facilityDetailDAO;
    private CustomerDAO customerDAO;
    
    public RegistrationControllerImpl(){
        registrationDAO =(RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
        serviceDetailDAO = (ServiceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE_DETAIL);
        facilityDetailDAO = (FacilityDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FACILITY_DETAIL);
        roomDetailDAO =(RoomDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM_DETAIL);
        customerDAO =(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }
    
    @Override
    public boolean add(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.add(registrationDTO);
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.update(registrationDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return registrationDAO.delete(key);
    }

    @Override
    public RegistrationDTO search(String key) throws Exception {
        return registrationDAO.search(key);
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        return registrationDAO.getAll();
    }

    @Override
    public boolean add(CustomerDTO customerDTO,RegistrationDTO dto, ArrayList<ServiceDetailDTO> alServicesDetails, ArrayList<RoomDetailDTO> alRoomDetails, ArrayList<FacilityDetailDTO> alFaclityDetail) throws Exception {
        
        Connection connection = ConnectionFactory.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean reslt = customerDAO.add(customerDTO);
        if (reslt){
        boolean result = registrationDAO.add(dto);
            if (result){
                
                for (ServiceDetailDTO alSerDetail : alServicesDetails) {
                    alSerDetail.setSid(alSerDetail.getSid());
                    result = serviceDetailDAO.add(alSerDetail);

                    for (RoomDetailDTO alRoomDetail : alRoomDetails) {
                        alRoomDetail.setRid(alRoomDetail.getRid());
                        result = roomDetailDAO.add(alRoomDetail);

                        for (FacilityDetailDTO alfacDetail : alFaclityDetail) {
                            alfacDetail.setFid(alfacDetail.getFid());
                            result = facilityDetailDAO.add(alfacDetail);

                            if (!result){
                                connection.rollback();
                                connection.setAutoCommit(true);
                                return false;
                            }
                        }
                    }
                }
            }
            
            connection.setAutoCommit(true);
            return true;
            
        }else{
            connection.setAutoCommit(true);
            return false;
        }
    }
}
