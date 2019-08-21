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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.CardDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;

/**
 *
 * @author USER
 */

public class CardDAOImpl implements CardDAO{
    
    private Connection connection;
    
    public CardDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(CardDTO cardDTO) throws Exception {
        String sql = "INSERT INTO card VALUES (?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
//        if(cardDTO.getCaid()!=""){
//            pstm.setString(1, cardDTO.getCaid());
//        }else{
//            pstm.setString(1, null);
//        }
//        
//        if(cardDTO.getBank()!=""){
//            pstm.setString(2, cardDTO.getBank());
//        }else{
//            pstm.setString(2, null);
//        }
//        
//        if(cardDTO.getCard_id()!=""){
//            pstm.setString(3, cardDTO.getCard_id());
//        }else{
//            pstm.setString(3, null);
//        }
//        
//        if(cardDTO.getAdvances()!=0.00){
//            pstm.setDouble(4, cardDTO.getAdvances());
//        }else{
//            pstm.setDouble(4, 0.00);
//        }
//        
//        if(cardDTO.getAmount()!=0.00){
//            pstm.setDouble(5, cardDTO.getAmount());
//        }else{
//            pstm.setDouble(5, 0.00);
//        }
        
        pstm.setString(1, cardDTO.getCaid());
        pstm.setString(2, cardDTO.getBank());
        pstm.setString(3, cardDTO.getCard_id());
        pstm.setDouble(4, cardDTO.getAdvances());
        pstm.setDouble(5, cardDTO.getAmount());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(CardDTO cardDTO) throws Exception {
        String sql = "UPDATE card SET bank=?, card_id=?, advances=?, amount=?  WHERE caid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, cardDTO.getBank());
        pstm.setString(2, cardDTO.getCard_id());
        pstm.setDouble(3, cardDTO.getAdvances());
        pstm.setDouble(4, cardDTO.getAmount());
        
        pstm.setString(5, cardDTO.getCaid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM card WHERE caid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public CardDTO search(String key) throws Exception {
        String sql = "SELECT * FROM card WHERE cid = '" + key + "'";
        
        CardDTO ca = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            ca = new CardDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
            ) {};
        }
        return ca;
    }

    @Override
    public ArrayList<CardDTO> getAll() throws Exception {
        String sql = "SELECT * FROM card";
        
        ArrayList<CardDTO> alC = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alC == null){
                alC = new ArrayList<>();
            }
            CardDTO dto = new CardDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
            );
            alC.add(dto);
        }
        return alC;
    }

}
