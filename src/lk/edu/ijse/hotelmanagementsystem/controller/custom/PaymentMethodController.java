/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.controller.custom;

import java.util.ArrayList;
import lk.edu.ijse.hotelmanagementsystem.controller.SuperController;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;

/**
 *
 * @author USER
 */
public interface PaymentMethodController extends SuperController<PaymentMethodDTO> {
    
    public boolean add(CardDTO card, CashDTO cash,ChecakDTO cheak,PaymentMethodDTO dto) throws Exception;
    
}
