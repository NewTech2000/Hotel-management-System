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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.SystemUserDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.SystemUserDTO;

/**
 *
 * @author USER
 */

public class SystemUserDAOImpl  implements SystemUserDAO{
    
    private Connection connection;
    
    public SystemUserDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(SystemUserDTO systemUserDTO) throws Exception {
        String sql = "INSERT INTO system_User VALUES (?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, systemUserDTO.getSuid());
        pstm.setString(2, systemUserDTO.getUserLevel());
        pstm.setString(3, systemUserDTO.getUserName());
        pstm.setString(4, systemUserDTO.getPassword());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(SystemUserDTO systemUserDTO) throws Exception {
        String sql = "UPDATE system_User SET user_level=?, user_name=?, password=? WHERE suid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, systemUserDTO.getUserLevel());
        pstm.setString(2, systemUserDTO.getUserName());
        pstm.setString(3, systemUserDTO.getPassword());
        
        pstm.setString(4, systemUserDTO.getSuid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM system_User WHERE suid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public SystemUserDTO search(String key) throws Exception {
        String sql = "SELECT * FROM system_User WHERE suid = '" + key + "'";
        
        SystemUserDTO systemUser = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            systemUser = new SystemUserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ) {};
        }
        return systemUser;
    }

    @Override
    public ArrayList<SystemUserDTO> getAll() throws Exception {
        String sql = "SELECT * FROM system_User";
        
        ArrayList<SystemUserDTO> alSystemUser = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSystemUser == null){
                alSystemUser = new ArrayList<>();
            }
            SystemUserDTO dto = new SystemUserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            alSystemUser.add(dto);
        }
        return alSystemUser;
    }

}
