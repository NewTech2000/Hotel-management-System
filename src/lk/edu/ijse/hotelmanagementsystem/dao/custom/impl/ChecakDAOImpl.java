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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ChecakDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;


/**
 *
 * @author USER
 */

public class ChecakDAOImpl implements ChecakDAO{
    
    private Connection connection;
    
    public ChecakDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(ChecakDTO checakDTO) throws Exception {
        String sql = "INSERT INTO checak VALUES (?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, checakDTO.getCkid());
        pstm.setString(2, checakDTO.getBank());
        pstm.setString(3, checakDTO.getCheck_id());
        pstm.setDouble(4, checakDTO.getAdvances());
        pstm.setDouble(5, checakDTO.getAmount());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(ChecakDTO checakDTO) throws Exception {
        String sql = "UPDATE checak SET bank=?, check_id=?,advances=?,amount=? WHERE ckid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, checakDTO.getBank());
        pstm.setString(2, checakDTO.getCheck_id());
        pstm.setDouble(3, checakDTO.getAdvances());
        pstm.setDouble(4, checakDTO.getAmount());
        
        pstm.setString(5, checakDTO.getCkid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM checak WHERE ckid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ChecakDTO search(String key) throws Exception {
        String sql = "SELECT * FROM checak WHERE ckid = '" + key + "'";
        
        ChecakDTO customer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            customer = new ChecakDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
            ) {};
        }
        return customer;
    }

    @Override
    public ArrayList<ChecakDTO> getAll() throws Exception {
        String sql = "SELECT * FROM checak";
        
        ArrayList<ChecakDTO> alChek = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alChek == null){
                alChek = new ArrayList<>();
            }
            ChecakDTO dto = new ChecakDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
            );
            alChek.add(dto);
        }
        return alChek;
    }

}
