/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.validation;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
/**
 *
 * @author USER
 */

public class Validation {

    public static void phoneNumber(JTextField textField, KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
        }
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[0-9]{0,10}$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textField.setText(txt);
            textField.setCaretPosition(caretPosition - 1);
        }

    }

    public static void priceText(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]+[.]?[0-9]{0,2}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    /**
     * Validate text to accept a limited number of integers
     */
    public static void limitesIntegers(JTextField textField, int value) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[0-9]{0," + value + "}$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textField.setText(txt);
            textField.setCaretPosition(caretPosition - 1);
        }
    }

    /**
     * Validate text to accept a NIC
     */
    public static void textNIC(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]{0,9}[v]{0,1}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    /**
     * Validate text to accept a new NIC
     */
    public static void textNewNIC(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]{0,12}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    

    /**
     * Validate text to accept a year
     */
    public static void textYear(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]{0,4}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    /**
     * Validate text to accept letters only
     */
    public static void name(JTextField textField) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[A-Za-z// ]*$")) {
            textField.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textField.setCaretPosition(caretPosition - 1);
        }
    }

    /**
     * Validate text to accept numbers only
     */
    public static void numberOnly(JTextField textField) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[\\d]*")) {
            textField.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textField.setCaretPosition(caretPosition - 1);
        }
    }

    public static void validateNIC(JTextField nicText) {
        String text = nicText.getText();
        boolean matches = text.matches("[\\d]{0,9}");
        if (!matches) {
            nicText.setText(text.substring(0, text.length() - 1));
        }
        boolean matches1 = text.matches("[\\d]{9}");
        if (matches1) {
            nicText.setText(nicText.getText() + "V");
        }
    }

    public static void validationEmail(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void emailValidate(JTextField textField) {
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!text.matches("^[a-z]([a-z0-9]+\\.)*[a-z0-9]+@[a-z0-9]+([a-z0-9]+\\.)*(\\.[a-z0-9]+)+$")) {
            //textField.setText(textField.getText().substring(0, textField.getText ().length() - 1));
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }

    public static void grnbuttonEnable(JToggleButton button, JComboBox cmb, JComboBox modelCmb, JTextField... textFields) {
        boolean enable = true;

        for (JTextField textField : textFields) {

            if (textField.getText().isEmpty()) {
                enable = false;
            }

            if (cmb.getActionCommand().isEmpty()) {
                enable = false;
            }

            if (modelCmb.getActionCommand().isEmpty()) {
                enable = false;
            }

            button.setEnabled(enable);

        }

    }

    public static void nicValidation(JTextField nicTextField) {

        String text = nicTextField.getText();
        int caretPosition = nicTextField.getCaretPosition();
        if (!text.matches("[0-9]{0,9}[vVxX]?")) {
            text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
            nicTextField.setBackground(Color.red);
            nicTextField.setForeground(Color.WHITE);
            nicTextField.setText(text);
            nicTextField.setCaretPosition(caretPosition - 1);
        } else {

            nicTextField.setForeground(Color.BLACK);
            nicTextField.setBackground(Color.WHITE);
        }

    }

    public static void validatePhoneNumber(JTextField textField) {
        String text = textField.getText();
        /*int caretPosition = textField.getCaretPosition();
        if (!text.matches("^[0-9]{0,10}$")) {
            text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
            textField.setText(text);
            textField.setCaretPosition(caretPosition - 1);
        }
        if (text.matches("^[0][1-9]{2}[0-9]{7}$")) {
            textField.setBackground(Color.WHITE);
            textField.setForeground(Color.BLACK);

        } else {
            textField.setBackground(Color.red);
            textField.setForeground(Color.WHITE);
        }*/
        if (!text.matches("\\d{3}\\-\\d{7}")) {
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }

    public static void validatePrice(JTextField textField) {
        String txt = textField.getText();

        /*int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]+[.]?[0-9]{0,2}$")) {
            txt = txt.substring(0, caretPosition + 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition + 1);
        }

        if (txt.matches("^[0-9]+[.]?[0-9]{0,2}$")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }*/
        if(txt.matches(".+\\.\\d{2}") || txt.matches("\\d+")){
            textField.setBackground(Color.white);
        }else{
            textField.setBackground(Color.red);
        }
    }

    public static void validateName(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[a-zA-Z ]+?$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }

        if (txt.matches("^[a-zA-Z ]+?$")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }
    }

    public static void validateAutoId(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("[S][0-9]{0,3}?")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }

        if (txt.matches("[S][0-9]{0,3}?")) {

            textFild.setBackground(Color.WHITE);
            textFild.setForeground(Color.black);
        } else {

            textFild.setBackground(Color.RED);
            textFild.setForeground(Color.WHITE);
        }
    }

    public static void validateInt(JTextField textField) {
        String txt = textField.getText();
        //int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]+$")) {
           /* txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);*/
            textField.setText(textField.getText().substring(0, textField.getText ().length() - 1));
        }

        if (txt.matches("^[0-9]+$")) {

 
        } else {


        }
    }
}
