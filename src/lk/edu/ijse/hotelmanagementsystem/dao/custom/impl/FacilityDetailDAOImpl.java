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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.FacilityDetailDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;

/**
 *
 * @author USER
 */

public class FacilityDetailDAOImpl implements FacilityDetailDAO{

    private Connection connection;
    
    public FacilityDetailDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(FacilityDetailDTO facilityDetailDTO) throws Exception {
        String sql = "INSERT INTO facility_Detail VALUES (?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, facilityDetailDTO.getReid());
        pstm.setString(2, facilityDetailDTO.getFid());
        
        int result = pstm.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(FacilityDetailDTO facilityDetailDTO) throws Exception {
        String sql = "UPDATE facility_Detail SET fid=? WHERE reid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, facilityDetailDTO.getFid());
        
        pstm.setString(9, facilityDetailDTO.getReid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM facility_Detail WHERE reid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public FacilityDetailDTO search(String key) throws Exception {
        String sql = "SELECT * FROM facility_Detail WHERE reid = '" + key + "'";
        
        FacilityDetailDTO facil = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            facil = new FacilityDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            ) {};
        }
        return facil;
    }

    @Override
    public ArrayList<FacilityDetailDTO> getAll() throws Exception {
        String sql = "SELECT * FROM facility_Detail";
        
        ArrayList<FacilityDetailDTO> alFac = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alFac == null){
                alFac = new ArrayList<>();
            }
            FacilityDetailDTO dto = new FacilityDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alFac.add(dto);
        }
        return alFac;
    }

    @Override
    public ArrayList<FacilityDetailDTO> getFacility(String name) throws Exception {
        String sql = "SELECT * FROM facility_Detail WHERE reid = '" + name + "'";
        
        ArrayList<FacilityDetailDTO> alSer = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alSer == null){
                alSer = new ArrayList<>();
            }
            FacilityDetailDTO dto = new FacilityDetailDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            alSer.add(dto);
        }
        return alSer;
    }
}  
