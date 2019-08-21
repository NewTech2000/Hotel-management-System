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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.PaymentMethodDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;

/**
 *
 * @author USER
 */

public class PaymentMethodDAOImpl implements PaymentMethodDAO {
    
    private Connection connection;
    
    public PaymentMethodDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(PaymentMethodDTO paymentMethodDTO) throws Exception {
        String sql = "INSERT INTO payment_method VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, paymentMethodDTO.getPmid());
        pstm.setString(2, paymentMethodDTO.getReid());
        
        if(paymentMethodDTO.getCaid()!=""){
            pstm.setString(3, paymentMethodDTO.getCaid());
        }else{
            pstm.setString(3, null);
        }
        if(paymentMethodDTO.getCsid()!=""){
            pstm.setString(4, paymentMethodDTO.getCsid());
        }else{
            pstm.setString(4, null);
        }
        if(paymentMethodDTO.getCkid()!=""){
            pstm.setString(5, paymentMethodDTO.getCkid());
        }else{
            pstm.setString(5, null);
        }
        pstm.setString(6, paymentMethodDTO.getDate());
        pstm.setDouble(7, paymentMethodDTO.getTax());
        pstm.setDouble(8, paymentMethodDTO.getDiscount());
        pstm.setDouble(9, paymentMethodDTO.getAmount());
        pstm.setDouble(10, paymentMethodDTO.getBalance());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(PaymentMethodDTO paymentMethodDTO) throws Exception {
        String sql = "UPDATE payment_method SET reid=?, caid=?, csid=?, ckid=?,date=?, tax=?, discount=?,amount=?,balance=? WHERE pmid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, paymentMethodDTO.getReid());
        pstm.setString(2, paymentMethodDTO.getCaid());
        pstm.setString(3, paymentMethodDTO.getCsid());
        pstm.setString(4, paymentMethodDTO.getCkid());
        pstm.setString(5, paymentMethodDTO.getDate());
        pstm.setDouble(6, paymentMethodDTO.getTax());
        pstm.setDouble(7, paymentMethodDTO.getDiscount());
        pstm.setDouble(8, paymentMethodDTO.getAmount());
        pstm.setDouble(9, paymentMethodDTO.getBalance());
        
        pstm.setString(10, paymentMethodDTO.getPmid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM payment_method WHERE pmid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public PaymentMethodDTO search(String key) throws Exception {
        String sql = "SELECT * FROM payment_method WHERE pmid = '" + key + "'";
        
        PaymentMethodDTO payment = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            payment = new PaymentMethodDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7),
                    rst.getDouble(8),
                    rst.getDouble(9),
                    rst.getDouble(10)
            ) {};
        }
        return payment;
    }

    @Override
    public ArrayList<PaymentMethodDTO> getAll() throws Exception {
        String sql = "SELECT * FROM payment_method";
        
        ArrayList<PaymentMethodDTO> alPayme = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alPayme == null){
                alPayme = new ArrayList<>();
            }
            PaymentMethodDTO dto = new PaymentMethodDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7),
                    rst.getDouble(8),
                    rst.getDouble(9),
                    rst.getDouble(10)
            );
            alPayme.add(dto);
        }
        return alPayme;
    }
}
