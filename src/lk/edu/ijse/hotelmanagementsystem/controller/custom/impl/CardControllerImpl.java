/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CardController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CashController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CardDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CashDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ChecakDAO;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.PaymentMethodDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;


/**
 *
 * @author USER
 */

public class CardControllerImpl implements CardController{

    private CardDAO cardDAO;
    private PaymentMethodDAO paymentMethodDAO;
    private CashDAO cashDAO;
    private ChecakDAO cheakDAO;
    
    public CardControllerImpl(){
        paymentMethodDAO =(PaymentMethodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT_METHOD);
        cardDAO =(CardDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CARD);
        cashDAO =(CashDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASH);
        cheakDAO =(ChecakDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHECAK);
    }

    @Override
    public boolean add(CardDTO cardDTO) throws Exception {
        return cardDAO.add(cardDTO);
    }

    @Override
    public boolean update(CardDTO cardDTO) throws Exception {
        return cardDAO.update(cardDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return cardDAO.delete(key);
    }

    @Override
    public CardDTO search(String key) throws Exception {
        return cardDAO.search(key);
    }

    @Override
    public ArrayList<CardDTO> getAll() throws Exception {
        return cardDAO.getAll();
    }

    @Override
    public boolean add(CardDTO card, CashDTO cash, ChecakDTO cheak, PaymentMethodDTO alPay) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        try {
            boolean result0 = cardDAO.add(card);
            if (result0){
                boolean result1 = cashDAO.add(cash);
                if (result1){
                    boolean result2 = cheakDAO.add(cheak);
                    if (result2){
                        boolean result4 = paymentMethodDAO.add(alPay);
                        if(result4){
                            connection.setAutoCommit(true);
                            return false;
                        }
                    }
                }
            }
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
            return false;
        }
    }
}