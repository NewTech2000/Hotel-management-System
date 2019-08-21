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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CashDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;

/**
 *
 * @author USER
 */

public class CashDAOImpl implements CashDAO{
    
    private Connection connection;
    
    public CashDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(CashDTO cashDTO) throws Exception {
        String sql = "INSERT INTO cash VALUES (?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
//        if(cardDTO.getCaid()!=""){
//            pstm.setDouble(5, cardDTO.getAmount());
//        }else{
//            pstm.setString(5, null);
//        }
        
        pstm.setString(1, cashDTO.getCsid());
        pstm.setDouble(2, cashDTO.getAdvances());
        pstm.setDouble(3, cashDTO.getAmount());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(CashDTO cashDTO) throws Exception {
        String sql = "UPDATE cash SET advances=?,amount=? WHERE csid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setDouble(1, cashDTO.getAdvances());
        pstm.setDouble(2, cashDTO.getAmount());
        
        pstm.setString(3, cashDTO.getCsid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM cash WHERE csid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public CashDTO search(String key) throws Exception {
        String sql = "SELECT * FROM cash WHERE csid = '" + key + "'";
        
        CashDTO cash = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            cash = new CashDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3)
            ) {};
        }
        return cash;
    }

    @Override
    public ArrayList<CashDTO> getAll() throws Exception {
        String sql = "SELECT * FROM cash";
        
        ArrayList<CashDTO> alCas = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alCas == null){
                alCas = new ArrayList<>();
            }
            CashDTO dto = new CashDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3)
            );
            alCas.add(dto);
        }
        return alCas;
    }

}
