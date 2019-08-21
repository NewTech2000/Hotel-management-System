/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.PaymentMethodController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.PaymentMethodDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;

/**
 *
 * @author USER
 */

public class PaymentMethodControllerImpl implements PaymentMethodController {

    private PaymentMethodDAO paymentMethodDAO;
    
    public PaymentMethodControllerImpl(){
        paymentMethodDAO =(PaymentMethodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT_METHOD);
    }

    @Override
    public boolean add(PaymentMethodDTO paymentMethodDTO) throws Exception {
        return paymentMethodDAO.add(paymentMethodDTO);
    }

    @Override
    public boolean update(PaymentMethodDTO paymentMethodDTO) throws Exception {
       return paymentMethodDAO.update(paymentMethodDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return paymentMethodDAO.delete(key);
    }

    @Override
    public PaymentMethodDTO search(String key) throws Exception {
        return paymentMethodDAO.search(key);
    }

    @Override
    public ArrayList<PaymentMethodDTO> getAll() throws Exception {
        return paymentMethodDAO.getAll();
    }

    @Override
    public boolean add(CardDTO card, CashDTO cash, ChecakDTO cheak, PaymentMethodDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
