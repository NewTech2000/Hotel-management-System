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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.FacilityDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDTO;

/**
 *
 * @author USER
 */
public class FacilityDAOImpl implements FacilityDAO {

    Connection connection;

    public FacilityDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(FacilityDTO facilityDTO) throws Exception {
        String sql = "INSERT INTO facility VALUES (?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, facilityDTO.getFid());
        pstm.setString(2, facilityDTO.getFacility_Name());
        pstm.setDouble(3, facilityDTO.getPrices());
        
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(FacilityDTO facilityDTO) throws Exception {
        String sql = "UPDATE facility SET facility_Name=?,prices=? WHERE fid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, facilityDTO.getFacility_Name());
        pstm.setDouble(2, facilityDTO.getPrices());
        
        pstm.setString(3, facilityDTO.getFid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM facility WHERE fid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public FacilityDTO search(String key) throws Exception {
        String sql = "SELECT * FROM facility WHERE fid = '" + key + "'";
        
        FacilityDTO customer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            customer = new FacilityDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            ) {};
        }
        return customer;
    }

    @Override
    public ArrayList<FacilityDTO> getAll() throws Exception {
        String sql = "SELECT * FROM facility";
        
        ArrayList<FacilityDTO> alCustomer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alCustomer == null){
                alCustomer = new ArrayList<>();
            }
            FacilityDTO dto = new FacilityDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            );
            alCustomer.add(dto);
        }
        return alCustomer;
    }

    @Override
    public ArrayList<FacilityDTO> getFacility(String name) throws Exception {
        String sql = "SELECT * FROM facility WHERE fid = '" + name + "'";
        
        ArrayList<FacilityDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            FacilityDTO dto = new FacilityDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            );
            alSer.add(dto);
        }
        return alSer;
    }

}
