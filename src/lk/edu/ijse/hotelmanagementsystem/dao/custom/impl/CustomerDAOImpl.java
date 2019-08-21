/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CustomerDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;

/**
 *
 * @author USER
 */

public class CustomerDAOImpl implements CustomerDAO{
    
    private Connection connection;
    
    public CustomerDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, customerDTO.getCid());
        pstm.setString(2, customerDTO.getFName());
        pstm.setString(3, customerDTO.getLName());
        pstm.setString(4, customerDTO.getEmail());
        pstm.setString(5, customerDTO.getAddress());
        pstm.setString(6, customerDTO.getCountry());
        pstm.setString(7, customerDTO.getPasportId());
        pstm.setString(8, customerDTO.getNic());
        pstm.setInt(9, customerDTO.getTel());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws Exception {
        String sql = "UPDATE customer SET f_name=?, l_name=?, email=?,address=?,country=?,NIC=?,tel=? WHERE cid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, customerDTO.getFName());
        pstm.setString(2, customerDTO.getLName());
        pstm.setString(3, customerDTO.getEmail());
        pstm.setString(4, customerDTO.getAddress());
        pstm.setString(5, customerDTO.getCountry());
        pstm.setString(6, customerDTO.getPasportId());
        pstm.setString(7, customerDTO.getNic());
        pstm.setInt(8, customerDTO.getTel());
        
        pstm.setString(9, customerDTO.getCid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM customer WHERE cid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public CustomerDTO search(String key) throws Exception {
        String sql = "SELECT * FROM customer WHERE cid = '" + key + "'";
        
        CustomerDTO customer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            customer = new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getInt(9)
            ) {};
        }
        return customer;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        String sql = "SELECT * FROM customer";
        
        ArrayList<CustomerDTO> alCustomer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alCustomer == null){
                alCustomer = new ArrayList<>();
            }
            CustomerDTO dto = new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getInt(9)
            );
            alCustomer.add(dto);
        }
        return alCustomer;
    }
}
