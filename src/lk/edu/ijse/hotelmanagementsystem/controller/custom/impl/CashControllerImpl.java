/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CashController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CashDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;

/**
 *
 * @author USER
 */

public class CashControllerImpl  implements CashController{

    private CashDAO cashDAO;
    
    public CashControllerImpl(){
        cashDAO =(CashDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASH);
    }

    @Override
    public boolean add(CashDTO cashDTO) throws Exception {
        return cashDAO.add(cashDTO);
    }

    @Override
    public boolean update(CashDTO cashDTO) throws Exception {
        return cashDAO.update(cashDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return cashDAO.delete(key);
    }

    @Override
    public CashDTO search(String key) throws Exception {
        return cashDAO.search(key);
    }

    @Override
    public ArrayList<CashDTO> getAll() throws Exception {
        return cashDAO.getAll();
    }
    
}
