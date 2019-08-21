/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom.impl;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CustomerController;
import lk.edu.ijse.hotelmanagementsystem.dao.DAOFactory;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CustomerDAO;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;

/**
 *
 * @author USER
 */

public class CustomerControllerImpl implements CustomerController{

    private CustomerDAO customerDAO;
    
    public CustomerControllerImpl(){
        customerDAO =(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }
    
    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(customerDTO);
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(customerDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return customerDAO.delete(key);
    }

    @Override
    public CustomerDTO search(String key) throws Exception {
        return customerDAO.search(key);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        return customerDAO.getAll();
    }
    

}
