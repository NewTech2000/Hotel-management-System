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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RoomDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDTO;


/**
 *
 * @author USER
 */

public class RoomDAOImpl implements RoomDAO{

        
    private Connection connection;
    
    public RoomDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        String sql = "INSERT INTO room VALUES (?,?,?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, roomDTO.getRid());
        pstm.setString(2, roomDTO.getRoom_type());
        pstm.setString(3, roomDTO.getRoom_floor());
        pstm.setString(4, roomDTO.getBed_type());
        pstm.setString(5, roomDTO.getRoom_decription());
        pstm.setString(6, roomDTO.getRoom_number());
        pstm.setDouble(7, roomDTO.getPrices());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        String sql = "UPDATE room SET room_type=?, room_floor=?, bed_type=?,room_decription=?,room_number=?,prices=? WHERE rid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, roomDTO.getRoom_type());
        pstm.setString(2, roomDTO.getRoom_floor());
        pstm.setString(3, roomDTO.getBed_type());
        pstm.setString(4, roomDTO.getRoom_decription());
        pstm.setString(5, roomDTO.getRoom_number());
        pstm.setDouble(6, roomDTO.getPrices());
        
        pstm.setString(9, roomDTO.getRid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM room WHERE rid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public RoomDTO search(String key) throws Exception {
        String sql = "SELECT * FROM room WHERE rid = '" + key + "'";
        
        RoomDTO ro = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            ro = new RoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7)
            ) {};
        }
        return ro;
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
        String sql = "SELECT * FROM room";
        
        ArrayList<RoomDTO> alRoom = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alRoom == null){
                alRoom = new ArrayList<>();
            }
            RoomDTO dto = new RoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7)
            );
            alRoom.add(dto);
        }
        return alRoom;
    }

}
