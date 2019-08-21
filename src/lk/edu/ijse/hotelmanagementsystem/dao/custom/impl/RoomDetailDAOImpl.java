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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RoomDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;

/**
 *
 * @author USER
 */

public class RoomDetailDAOImpl implements RoomDetailDAO {
     
    private Connection connection;
    
    public RoomDetailDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(RoomDetailDTO roomDetailDTO) throws Exception {
        String sql = "INSERT INTO room_detail VALUES (?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, roomDetailDTO.getReid());
        pstm.setString(2, roomDetailDTO.getRid());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(RoomDetailDTO roomDetailDTO) throws Exception {
        String sql = "UPDATE room_detail SET rid=? WHERE reid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, roomDetailDTO.getReid());
        
        pstm.setString(9, roomDetailDTO.getRid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM room_detail WHERE rid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public RoomDetailDTO search(String key) throws Exception {
        String sql = "SELECT * FROM room_detail WHERE reid = '" + key + "'";
        
        RoomDetailDTO roomDetail = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            roomDetail = new RoomDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
        }
        return roomDetail;
    }

    @Override
    public ArrayList<RoomDetailDTO> getAll() throws Exception {
        String sql = "SELECT * FROM room_detail";
        
        ArrayList<RoomDetailDTO> alRoom = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alRoom == null){
                alRoom = new ArrayList<>();
            }
            RoomDetailDTO dto = new RoomDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alRoom.add(dto);
        }
        return alRoom;
    }
    
    public ArrayList<RoomDetailDTO> searchList(String reid) throws Exception {
        
        String sql = "SELECT * FROM room_detail WHERE reid ='"+reid+"'";
        
        ArrayList<RoomDetailDTO> alRoom = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alRoom == null){
                alRoom = new ArrayList<>();
            }
            RoomDetailDTO dto = new RoomDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alRoom.add(dto);
        }
        return alRoom;
    }

    @Override
    public ArrayList<RoomDetailDTO> getRoom(String name) throws Exception {
        String sql = "SELECT * FROM room_detail WHERE reid = '" + name + "'";
        
        ArrayList<RoomDetailDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            RoomDetailDTO dto = new RoomDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alSer.add(dto);
        }
        return alSer;
    }
}
