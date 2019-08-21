/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.dao;

import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.CardDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.CashDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.ChecakDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.CustomerDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.FacilityDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.FacilityDetailDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.PaymentMethodDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.RegistrationDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.RoomDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.RoomDetailDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.ServiceDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.ServiceDetailDAOImpl;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.impl.SystemUserDAOImpl;



/**
 *
 * @author USER
 */
public class DAOFactory {
    
    public enum DAOTypes{
        SYSTEM_USER,CUSTOMER,REGISTRATION,FACILITY,FACILITY_DETAIL,SERVICE,SERVICE_DETAIL,ROOM,ROOM_DETAIL,
        CARD,CASH,CHECAK,PAYMENT_METHOD
    }

    private static DAOFactory daoFactory;
    
    public DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType){
            case SYSTEM_USER:
                return new SystemUserDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case FACILITY:
                return new FacilityDAOImpl();
            case FACILITY_DETAIL:
                return new FacilityDetailDAOImpl();
            case SERVICE:
                return new ServiceDAOImpl();
            case SERVICE_DETAIL:
                return new ServiceDetailDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case ROOM_DETAIL:
                return new RoomDetailDAOImpl();
            case CARD:
                return new CardDAOImpl();
            case CASH:
                return new CashDAOImpl();
            case CHECAK:
                return new ChecakDAOImpl();
            case PAYMENT_METHOD:
                return new PaymentMethodDAOImpl();
            default:
                return null;
        }
    }
}
