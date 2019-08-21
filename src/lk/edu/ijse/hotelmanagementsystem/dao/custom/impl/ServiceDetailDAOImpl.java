/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.hotelmanagementsystem.dao.custom.ServiceDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;

/**
 *
 * @author USER
 */

public class ServiceDetailDAOImpl implements ServiceDetailDAO {
    
    private Connection connection;
    
    public ServiceDetailDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(ServiceDetailDTO serviceDetailDTO) throws Exception {
        String sql = "INSERT INTO service_detail VALUES (?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, serviceDetailDTO.getReid());
        pstm.setString(2, serviceDetailDTO.getSid());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(ServiceDetailDTO serviceDetailDTO) throws Exception {
        String sql = "UPDATE service_detail SET reid=? WHERE sid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, serviceDetailDTO.getReid());
        
        pstm.setString(9, serviceDetailDTO.getSid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM service_detail WHERE reid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ServiceDetailDTO search(String key) throws Exception {
        String sql = "SELECT * FROM service_detail WHERE reid = '" + key + "'";
        
        ServiceDetailDTO ser = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            ser = new ServiceDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            ) {};
        }
        return ser;
    }

    @Override
    public ArrayList<ServiceDetailDTO> getAll() throws Exception {
        String sql = "SELECT * FROM service_detail";
        
        ArrayList<ServiceDetailDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            ServiceDetailDTO dto = new ServiceDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alSer.add(dto);
        }
        return alSer;
    }

    @Override
    public ArrayList<ServiceDetailDTO> getSSSS(String name) throws Exception {
        String sql = "SELECT * FROM service_detail WHERE reid = '" + name + "'";
        
        ArrayList<ServiceDetailDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            ServiceDetailDTO dto = new ServiceDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alSer.add(dto);
        }
        return alSer;
    }
    
}
