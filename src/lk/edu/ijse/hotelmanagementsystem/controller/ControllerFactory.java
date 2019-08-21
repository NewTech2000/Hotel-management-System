/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller;

import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.CardControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.CashControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.ChecakControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.CustomerControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.FacilityControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.FacilityDetailControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.PaymentMethodControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.RegistrationControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.RoomControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.RoomDetailControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.ServiceControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.ServiceDetailControllerImpl;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.impl.SystemUserControllerImpl;



/**
 *
 * @author USER
 */
public class ControllerFactory {
    
    public enum ControllerTypes{
        SYSTEM_USER,CUSTOMER,REGISTRATION,FACILITY,FACILITY_DETAIL,SERVICE,SERVICE_DETAIL,ROOM,ROOM_DETAIL,
        CARD,CASH,CHECAK,PAYMENT_METHOD
    }
    
    private static ControllerFactory ctrlFactory;
    
    private ControllerFactory(){
        
    }
    public static ControllerFactory getInstance(){
        if (ctrlFactory == null){
            ctrlFactory = new ControllerFactory();
        }
        return ctrlFactory;
    }
    
    public SuperController getController(ControllerTypes controllerTypes) {
        switch (controllerTypes){
            case SYSTEM_USER:
                return new SystemUserControllerImpl();
            case CUSTOMER:
                return new CustomerControllerImpl();
            case REGISTRATION:
                return new RegistrationControllerImpl();
            case FACILITY:
                return new FacilityControllerImpl();
            case FACILITY_DETAIL:
                return new FacilityDetailControllerImpl();
            case SERVICE:
                return new ServiceControllerImpl();
            case SERVICE_DETAIL:
                return new ServiceDetailControllerImpl();
            case ROOM:
                return new RoomControllerImpl();
            case ROOM_DETAIL:
                return new RoomDetailControllerImpl();
            case CARD:
                return new CardControllerImpl();
            case CASH:
                return new CashControllerImpl();
            case CHECAK:
                return new ChecakControllerImpl();
            case PAYMENT_METHOD:
                return new PaymentMethodControllerImpl();
            default:
                return null;
        }
    }
}
