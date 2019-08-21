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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ServiceDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDTO;

/**
 *
 * @author USER
 */

public class ServiceDAOImpl implements ServiceDAO {
     
    private Connection connection;
    
    public ServiceDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(ServiceDTO serviceDTO) throws Exception {
        String sql = "INSERT INTO service VALUES (?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, serviceDTO.getSid());
        pstm.setString(2, serviceDTO.getService_name());
        pstm.setDouble(3, serviceDTO.getPrice());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(ServiceDTO serviceDTO) throws Exception {
        String sql = "UPDATE service SET service_name=?,price=? WHERE sid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, serviceDTO.getService_name());
        pstm.setDouble(2, serviceDTO.getPrice());
        
        pstm.setString(9, serviceDTO.getSid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM service WHERE sid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ServiceDTO search(String key) throws Exception {
        String sql = "SELECT * FROM service WHERE sid = '" + key + "'";
        
        ServiceDTO ser = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            ser = new ServiceDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            ) {};
        }
        return ser;
    }

    @Override
    public ArrayList<ServiceDTO> getAll() throws Exception {
        String sql = "SELECT * FROM service";
        
        ArrayList<ServiceDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            ServiceDTO dto = new ServiceDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            );
            alSer.add(dto);
        }
        return alSer;
    }
}
