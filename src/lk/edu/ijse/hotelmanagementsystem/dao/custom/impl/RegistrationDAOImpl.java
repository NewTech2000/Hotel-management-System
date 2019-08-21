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
import lk.edu.ijse.hotelmanagementsystem.dao.custom.RegistrationDAO;
import lk.edu.ijse.hotelmanagementsystem.db.ConnectionFactory;
import lk.edu.ijse.hotelmanagementsystem.dto.RegistrationDTO;

/**
 *
 * @author USER
 */

public class RegistrationDAOImpl implements RegistrationDAO{
    
    private Connection connection;
    
    public RegistrationDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(RegistrationDTO registrationDTO) throws Exception {
        
        String sql = "INSERT INTO registration VALUES (?,?,?,?,?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, registrationDTO.getReid());
        pstm.setString(2, registrationDTO.getCid());
        pstm.setString(3, registrationDTO.getCheckin());
        pstm.setString(4, registrationDTO.getCheckout());
        pstm.setInt(5, registrationDTO.getNo_of_rooms());
        pstm.setString(6, registrationDTO.getNo_of_adults());
        pstm.setString(7, registrationDTO.getNo_of_children());
        pstm.setString(8, registrationDTO.getMeal_type());
        int result = pstm.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws Exception {
        String sql = "UPDATE registration SET cid=?, checkin=?, checkout=?,no_of_rooms=?,no_of_adults=?,no_of_children=?,meal_type=?  WHERE reid =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, registrationDTO.getCid());
        pstm.setString(2, registrationDTO.getCheckin());
        pstm.setString(3, registrationDTO.getCheckout());
        pstm.setInt(4, registrationDTO.getNo_of_rooms());
        pstm.setString(5, registrationDTO.getNo_of_adults());
        pstm.setString(6, registrationDTO.getNo_of_children());
        pstm.setString(7, registrationDTO.getMeal_type());
        
        pstm.setString(8, registrationDTO.getReid());
        
        int result = pstm.executeUpdate();    
        return (result > 0); 
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM registration WHERE reid ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public RegistrationDTO search(String key) throws Exception {
        String sql = "SELECT * FROM registration WHERE reid = '" + key + "'";
        
        RegistrationDTO regis = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            regis = new RegistrationDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            ) {};
        }
        return regis;
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        String sql = "SELECT * FROM registration";
        
        ArrayList<RegistrationDTO> alReg = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alReg == null){
                alReg = new ArrayList<>();
            }
            RegistrationDTO dto = new RegistrationDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            alReg.add(dto);
        }
        return alReg;
    }
}
