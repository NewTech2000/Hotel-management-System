/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.edu.ijse.hotelmanagementsystem.controller.ControllerFactory;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CardController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CashController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ChecakController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CustomerController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityDetailController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.PaymentMethodController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RegistrationController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomDetailController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceDetailController;
import lk.edu.ijse.hotelmanagementsystem.dto.CardDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.CashDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ChecakDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.PaymentMethodDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RegistrationDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.idgenerator.IDGenerator;
import lk.edu.ijse.hotelmanagementsystem.jasper.MyJasperView;
import lk.edu.ijse.hotelmanagementsystem.validation.Validation;
//import net.sf.jasperreports.engine.JREmptyDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author USER
 */
public final class ReceptionPayment extends javax.swing.JFrame {

    private PaymentMethodController ctrlPaymentMethod;
    private CashController ctrlCash;
    private ChecakController ctrlCheak;
    private CardController ctrlCard;
    private RoomController ctrlRoom;
    private ServiceController ctrlServices;
    private FacilityController ctrlFacility;
    private FacilityDetailController ctrlFacilityDetail;
    private ServiceDetailController ctrlServicesDetail;
    private RegistrationController ctrlRegistration;
    private RoomDetailController ctrlRoomDetail;
    private CustomerController ctrlCustomer;
    public DefaultTableModel dtmChoseRoomDetail;
    public DefaultTableModel dtmService;
    public DefaultTableModel dtmFacility;
    
    /**
     * Creates new form ReceptionPayment
     */
    public ReceptionPayment() {
        initComponents();
//        coman();
//        paymentId();
//        paymentIdCard();
//        paymentIdCash();
//        paymentIdCheak();
//        paymentIdRegistation();
        setLocationRelativeTo(null);
//        setTex();
    }
    
    public void coman(){
        ctrlPaymentMethod = (PaymentMethodController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT_METHOD);
        ctrlCard =(CardController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CARD);
        ctrlCheak =(ChecakController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CHECAK);
        ctrlCash =(CashController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CASH);
        ctrlRoom =(RoomController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM);
        ctrlServices =(ServiceController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SERVICE);
        ctrlFacility =(FacilityController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FACILITY);
        ctrlRoomDetail =(RoomDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM_DETAIL);
        ctrlServicesDetail =(ServiceDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SERVICE_DETAIL);
        ctrlFacilityDetail =(FacilityDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FACILITY_DETAIL);
        ctrlCustomer =(CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CUSTOMER);
        dtmChoseRoomDetail = (DefaultTableModel) tblChoosRoomDetail.getModel();
        dtmFacility = (DefaultTableModel) tblChoseFacility.getModel();
        dtmService = (DefaultTableModel) tblChoseServices.getModel();
        ctrlRegistration = (RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.REGISTRATION);
    }
    
    public void setTex(){
        txtCardAmount.setText("0.00");
        txtCardAdvance.setText("0.00");
        txtCashAdvances.setText("0.00");
        txtCashAmount.setText("0.00");
        txtCheakAdvance.setText("0.00");
        txtCheakAmount.setText("0.00");
        //txtAmount.setText("0.00");
        txtDiscount.setText("0.00");
        txtTax.setText("0.00");
        lblFullAmount.setText("0.00");
        pnlCard.setVisible(false);
        pnlCash.setVisible(false);
        pnlCheak.setVisible(false);
    }
    
    public void paymentId(){
        try {
            String id= IDGenerator.getNewID("payment_method","pmid", "PM0");
            txtPID.setText(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void paymentIdCard(){
        try {
            String id= IDGenerator.getNewID("card","caid", "CA0");
            txtCardID.setText(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paymentIdCash(){
        try {
            String id= IDGenerator.getNewID("cash","csid", "CS0");
            txtCashID.setText(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paymentIdCheak(){
        try {
            String id= IDGenerator.getNewID("checak","ckid", "CK0");
            txtCheakID.setText(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paymentIdRegistation(){
        try {
            String id= IDGenerator.getNewID("registration","reid", "REG0");
            txtREGID.setText(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgnPayment = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblStep5 = new javax.swing.JLabel();
        pnlPayment = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblChoosRoomDetail = new javax.swing.JTable();
        btnCustomerSearch = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lblFullAmount = new javax.swing.JLabel();
        txtREGID = new javax.swing.JTextField();
        btnPrintBill = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        txtCardID = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtCardNum = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtCardAdvance = new javax.swing.JTextField();
        txtCardAmount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cmbCardBank = new javax.swing.JComboBox();
        pnlCash = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtCashID = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCashAdvances = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCashAmount = new javax.swing.JTextField();
        pnlCheak = new javax.swing.JPanel();
        txtCheakID = new javax.swing.JTextField();
        txtCheakAmount = new javax.swing.JTextField();
        txtCheakNum = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtCheakAdvance = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        cmbCheakBank = new javax.swing.JComboBox();
        lblMealType = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblChoseFacility = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblChoseServices = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblDatePayment = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTax = new javax.swing.JTextField();
        rbnCard = new javax.swing.JRadioButton();
        rbnCash = new javax.swing.JRadioButton();
        rbnCheak = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        lblCheakIn = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        lblChekOut = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblCid = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblAdultAmount = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lblChildAmount = new javax.swing.JLabel();
        lblRoomAmount = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblCustomerTel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFacility = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/MiniMaz.png"))); // NOI18N
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 50, 50));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/Close.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 50, 50));

        lblStep5.setBackground(new java.awt.Color(0, 0, 51));
        lblStep5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStep5.setForeground(new java.awt.Color(255, 255, 255));
        lblStep5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep5.setText("Payment");
        lblStep5.setOpaque(true);
        getContentPane().add(lblStep5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        pnlPayment.setBackground(new java.awt.Color(204, 204, 204));
        pnlPayment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChoosRoomDetail.setBackground(new java.awt.Color(204, 204, 204));
        tblChoosRoomDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID"
            }
        ));
        tblChoosRoomDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChoosRoomDetailMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblChoosRoomDetail);

        pnlPayment.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, 100));

        btnCustomerSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCustomerSearch.setText("Search");
        btnCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerSearchActionPerformed(evt);
            }
        });
        pnlPayment.add(btnCustomerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Amount");
        pnlPayment.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 70, 30));

        txtAmount.setBackground(new java.awt.Color(240, 240, 240));
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
        });
        pnlPayment.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 190, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Discount");
        pnlPayment.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 70, 30));

        txtDiscount.setBackground(new java.awt.Color(240, 240, 240));
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        pnlPayment.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 190, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Full Amount");
        pnlPayment.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 90, 30));

        lblFullAmount.setOpaque(true);
        pnlPayment.add(lblFullAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 190, 30));

        txtREGID.setBackground(new java.awt.Color(240, 240, 240));
        txtREGID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtREGIDKeyPressed(evt);
            }
        });
        pnlPayment.add(txtREGID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 110, 30));

        btnPrintBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintBill.setText("Print Bill");
        btnPrintBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintBillMouseClicked(evt);
            }
        });
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });
        pnlPayment.add(btnPrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 700, 90, 30));

        btnPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPayment.setText("Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        pnlPayment.add(btnPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 700, 100, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Date");
        pnlPayment.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 40, 30));

        pnlCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCardID.setBackground(new java.awt.Color(240, 240, 240));
        pnlCard.add(txtCardID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Balance");
        pnlCard.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Bank Name");
        pnlCard.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Advance");
        pnlCard.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        txtCardNum.setBackground(new java.awt.Color(240, 240, 240));
        pnlCard.add(txtCardNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 160, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Card ID");
        pnlCard.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Card Num");
        pnlCard.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        txtCardAdvance.setBackground(new java.awt.Color(240, 240, 240));
        txtCardAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardAdvanceActionPerformed(evt);
            }
        });
        txtCardAdvance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCardAdvanceKeyReleased(evt);
            }
        });
        pnlCard.add(txtCardAdvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, 30));

        txtCardAmount.setBackground(new java.awt.Color(240, 240, 240));
        txtCardAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCardAmountKeyReleased(evt);
            }
        });
        pnlCard.add(txtCardAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, 30));

        jLabel30.setBackground(new java.awt.Color(0, 0, 51));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Card Payment");
        jLabel30.setOpaque(true);
        pnlCard.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 30));

        cmbCardBank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbCardBank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sampath Bank", "HNB  Bank", "People's  Bank", "Comersal Bank" }));
        pnlCard.add(cmbCardBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, 30));

        pnlPayment.add(pnlCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 280, 240));

        pnlCash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setBackground(new java.awt.Color(0, 0, 51));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Cash Payment");
        jLabel44.setOpaque(true);
        pnlCash.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Cash ID");
        pnlCash.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        txtCashID.setBackground(new java.awt.Color(240, 240, 240));
        pnlCash.add(txtCashID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Advance");
        pnlCash.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 30));

        txtCashAdvances.setBackground(new java.awt.Color(240, 240, 240));
        txtCashAdvances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashAdvancesActionPerformed(evt);
            }
        });
        txtCashAdvances.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCashAdvancesKeyReleased(evt);
            }
        });
        pnlCash.add(txtCashAdvances, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 160, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Balance");
        pnlCash.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 30));

        txtCashAmount.setBackground(new java.awt.Color(240, 240, 240));
        txtCashAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCashAmountKeyReleased(evt);
            }
        });
        pnlCash.add(txtCashAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 160, 30));

        pnlPayment.add(pnlCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 280, 180));

        pnlCheak.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCheakID.setBackground(new java.awt.Color(240, 240, 240));
        pnlCheak.add(txtCheakID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, 30));

        txtCheakAmount.setBackground(new java.awt.Color(240, 240, 240));
        txtCheakAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCheakAmountKeyReleased(evt);
            }
        });
        pnlCheak.add(txtCheakAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, 30));

        txtCheakNum.setBackground(new java.awt.Color(240, 240, 240));
        pnlCheak.add(txtCheakNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 160, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Bank Name");
        pnlCheak.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Cheak ID");
        pnlCheak.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Cheak Num.");
        pnlCheak.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Advance");
        pnlCheak.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("Balance");
        pnlCheak.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 30));

        txtCheakAdvance.setBackground(new java.awt.Color(240, 240, 240));
        txtCheakAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheakAdvanceActionPerformed(evt);
            }
        });
        txtCheakAdvance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCheakAdvanceKeyReleased(evt);
            }
        });
        pnlCheak.add(txtCheakAdvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, 30));

        jLabel54.setBackground(new java.awt.Color(0, 0, 51));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Cheak Payment");
        jLabel54.setOpaque(true);
        pnlCheak.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 30));

        cmbCheakBank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbCheakBank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sampath Bank", "HNB  Bank", "People's  Bank", "Comersal Bank" }));
        pnlCheak.add(cmbCheakBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, 30));

        pnlPayment.add(pnlCheak, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 280, 240));

        lblMealType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMealType.setOpaque(true);
        pnlPayment.add(lblMealType, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 130, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Pay Method");
        pnlPayment.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 100, 40));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Reg: ID");
        pnlPayment.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        txtPID.setBackground(new java.awt.Color(240, 240, 240));
        pnlPayment.add(txtPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 190, 30));

        tblChoseFacility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Facilitity Id"
            }
        ));
        jScrollPane9.setViewportView(tblChoseFacility);

        pnlPayment.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 160, 100));

        tblChoseServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Services  Id"
            }
        ));
        jScrollPane10.setViewportView(tblChoseServices);

        pnlPayment.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 170, 100));

        jLabel53.setBackground(new java.awt.Color(0, 0, 51));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Room");
        jLabel53.setOpaque(true);
        pnlPayment.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 30));

        jLabel55.setBackground(new java.awt.Color(0, 0, 51));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Services");
        jLabel55.setOpaque(true);
        pnlPayment.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, 30));

        jLabel56.setBackground(new java.awt.Color(0, 0, 51));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Facility");
        jLabel56.setOpaque(true);
        pnlPayment.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 160, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("Meal Type");
        pnlPayment.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 70, 30));

        lblDatePayment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDatePayment.setOpaque(true);
        pnlPayment.add(lblDatePayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 160, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Tax");
        pnlPayment.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 70, 30));

        txtTax.setBackground(new java.awt.Color(240, 240, 240));
        txtTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxActionPerformed(evt);
            }
        });
        txtTax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaxKeyReleased(evt);
            }
        });
        pnlPayment.add(txtTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 190, 30));

        rbnCard.setBackground(new java.awt.Color(204, 204, 204));
        bgnPayment.add(rbnCard);
        rbnCard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbnCard.setText("Card");
        rbnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCardActionPerformed(evt);
            }
        });
        pnlPayment.add(rbnCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, -1, -1));

        rbnCash.setBackground(new java.awt.Color(204, 204, 204));
        bgnPayment.add(rbnCash);
        rbnCash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbnCash.setText("Cash");
        rbnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCashActionPerformed(evt);
            }
        });
        pnlPayment.add(rbnCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, -1));

        rbnCheak.setBackground(new java.awt.Color(204, 204, 204));
        bgnPayment.add(rbnCheak);
        rbnCheak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbnCheak.setText("Cheak");
        rbnCheak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCheakActionPerformed(evt);
            }
        });
        pnlPayment.add(rbnCheak, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Payment ID");
        pnlPayment.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 100, 30));

        lblCheakIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCheakIn.setOpaque(true);
        pnlPayment.add(lblCheakIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 190, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Cheak In");
        pnlPayment.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 70, 30));

        lblChekOut.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChekOut.setOpaque(true);
        pnlPayment.add(lblChekOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 190, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Cheak Out");
        pnlPayment.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 80, 30));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Customer ID");
        pnlPayment.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        lblCid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCid.setOpaque(true);
        pnlPayment.add(lblCid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 190, 30));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Adult Am:");
        pnlPayment.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 70, 30));

        lblAdultAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAdultAmount.setOpaque(true);
        pnlPayment.add(lblAdultAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 190, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("Child Am:");
        pnlPayment.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 70, 30));

        lblChildAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChildAmount.setOpaque(true);
        pnlPayment.add(lblChildAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 130, 30));

        lblRoomAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRoomAmount.setOpaque(true);
        pnlPayment.add(lblRoomAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 130, 30));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("No Of Room");
        pnlPayment.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 90, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("Cust Name");
        pnlPayment.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        lblCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCustomerName.setOpaque(true);
        pnlPayment.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 190, 30));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setText("Cust Tel");
        pnlPayment.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));

        lblCustomerTel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCustomerTel.setOpaque(true);
        pnlPayment.add(lblCustomerTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 190, 30));

        tblFacility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Facility ID", "Facilitity Name", "Price"
            }
        ));
        tblFacility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacilityMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFacility);

        pnlPayment.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 410, 100));

        getContentPane().add(pnlPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        Validation.validatePrice(txtAmount);
    }//GEN-LAST:event_txtAmountKeyReleased

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        Validation.validatePrice(txtDiscount);
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void btnPrintBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintBillMouseClicked
        //
    }//GEN-LAST:event_btnPrintBillMouseClicked

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed
       // viewReseptionMain();
        printBill();
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        addTransaction();
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void txtTaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaxKeyReleased
        Validation.validatePrice(txtTax);
    }//GEN-LAST:event_txtTaxKeyReleased

    private void txtCashAdvancesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashAdvancesKeyReleased
        Validation.validatePrice(txtCashAdvances);
    }//GEN-LAST:event_txtCashAdvancesKeyReleased

    private void txtCashAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashAmountKeyReleased
        Validation.validatePrice(txtCashAmount);
    }//GEN-LAST:event_txtCashAmountKeyReleased

    private void txtCheakAdvanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCheakAdvanceKeyReleased
        Validation.validatePrice(txtCheakAdvance);
    }//GEN-LAST:event_txtCheakAdvanceKeyReleased

    private void txtCheakAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCheakAmountKeyReleased
        Validation.validatePrice(txtCheakAmount);
    }//GEN-LAST:event_txtCheakAmountKeyReleased

    private void txtCardAdvanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardAdvanceKeyReleased
        Validation.validatePrice(txtCardAdvance);
    }//GEN-LAST:event_txtCardAdvanceKeyReleased

    private void txtCardAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardAmountKeyReleased
        Validation.validatePrice(txtCardAmount);
    }//GEN-LAST:event_txtCardAmountKeyReleased

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        double total = Double.parseDouble(txtAmount.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        double amount = total - (total * discount / 100);
        lblFullAmount.setText(amount + "");
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtCashAdvancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashAdvancesActionPerformed
        double cash = Double.parseDouble(lblFullAmount.getText());
        double total = Double.parseDouble(txtCashAdvances.getText());
        double balance = total - cash;
        txtCashAmount.setText(balance + "");
    }//GEN-LAST:event_txtCashAdvancesActionPerformed

    private void txtCheakAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheakAdvanceActionPerformed
        
        double cash = Double.parseDouble(lblFullAmount.getText());
        double total = Double.parseDouble(txtCheakAdvance.getText());
        double balance = total - cash;
        txtCheakAmount.setText(balance + "");
    }//GEN-LAST:event_txtCheakAdvanceActionPerformed

    private void txtCardAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardAdvanceActionPerformed
        double cash = Double.parseDouble(lblFullAmount.getText());
        double total = Double.parseDouble(txtCardAdvance.getText());
        double balance = total - cash;
        txtCardAmount.setText(balance + "");
    }//GEN-LAST:event_txtCardAdvanceActionPerformed

    private void txtTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxActionPerformed
        double total = Double.parseDouble(lblFullAmount.getText());
        double tax = Double.parseDouble(txtTax.getText());
        double amount = total + tax;
        lblFullAmount.setText(amount + "");
    }//GEN-LAST:event_txtTaxActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerSearchActionPerformed
        searchCustomer();
    }//GEN-LAST:event_btnCustomerSearchActionPerformed

    private void rbnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCashActionPerformed
        pnlCash.setVisible(true);
        pnlCard.setVisible(false);
        pnlCheak.setVisible(false);
    }//GEN-LAST:event_rbnCashActionPerformed

    private void rbnCheakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCheakActionPerformed
        pnlCash.setVisible(false);
        pnlCard.setVisible(false);
        pnlCheak.setVisible(true);
    }//GEN-LAST:event_rbnCheakActionPerformed

    private void rbnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCardActionPerformed
        pnlCash.setVisible(false);
        pnlCard.setVisible(true);
        pnlCheak.setVisible(false);
    }//GEN-LAST:event_rbnCardActionPerformed

    private void tblChoosRoomDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoosRoomDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblChoosRoomDetailMouseClicked

    private void txtREGIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtREGIDKeyPressed
        
    }//GEN-LAST:event_txtREGIDKeyPressed

    private void tblFacilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacilityMouseClicked
        //
    }//GEN-LAST:event_tblFacilityMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceptionPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgnPayment;
    private javax.swing.JButton btnCustomerSearch;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JComboBox cmbCardBank;
    private javax.swing.JComboBox cmbCheakBank;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAdultAmount;
    private javax.swing.JLabel lblCheakIn;
    private javax.swing.JLabel lblChekOut;
    private javax.swing.JLabel lblChildAmount;
    private javax.swing.JLabel lblCid;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerTel;
    public static javax.swing.JLabel lblDatePayment;
    private javax.swing.JLabel lblFullAmount;
    private javax.swing.JLabel lblMealType;
    private javax.swing.JLabel lblRoomAmount;
    private javax.swing.JLabel lblStep5;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlCash;
    private javax.swing.JPanel pnlCheak;
    private javax.swing.JPanel pnlPayment;
    private javax.swing.JRadioButton rbnCard;
    private javax.swing.JRadioButton rbnCash;
    private javax.swing.JRadioButton rbnCheak;
    public static javax.swing.JTable tblChoosRoomDetail;
    public static javax.swing.JTable tblChoseFacility;
    public static javax.swing.JTable tblChoseServices;
    private javax.swing.JTable tblFacility;
    public static javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCardAdvance;
    private javax.swing.JTextField txtCardAmount;
    private javax.swing.JTextField txtCardID;
    private javax.swing.JTextField txtCardNum;
    private javax.swing.JTextField txtCashAdvances;
    private javax.swing.JTextField txtCashAmount;
    private javax.swing.JTextField txtCashID;
    private javax.swing.JTextField txtCheakAdvance;
    private javax.swing.JTextField txtCheakAmount;
    private javax.swing.JTextField txtCheakID;
    private javax.swing.JTextField txtCheakNum;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtPID;
    public static javax.swing.JTextField txtREGID;
    private javax.swing.JTextField txtTax;
    // End of variables declaration//GEN-END:variables

    private void viewReseptionMain() {
        new ReceptionMain().setVisible(true);
        this.dispose();
    }
    
    private void addTransaction() {
        
        String caid = txtCardID.getText();
        String cardBank = cmbCardBank.getSelectedItem().toString();
        String cardID =  txtCardNum.getText();
        double cardAdvance = Double.parseDouble(txtCardAdvance.getText());
        double cardAmount = Double.parseDouble(txtCardAmount.getText());
        
        CardDTO cardDTO = new CardDTO(caid, cardBank, cardID, cardAdvance, cardAmount);

        String cashdID =  txtCashID.getText();
        double cashAdvance = Double.parseDouble(txtCashAdvances.getText());
        double cashAmount = Double.parseDouble(txtCashAmount.getText());
        
        CashDTO cashDTO = new CashDTO(cashdID, cashAdvance, cashAmount);

        String checkID = txtCheakID.getText();
        String cheakBank = cmbCheakBank.getSelectedItem().toString();
        String cheakID =  txtCheakNum.getText();
        double cheakAdvance = Double.parseDouble(txtCheakAdvance.getText());
        double cheakAmount = Double.parseDouble(txtCheakAmount.getText());
        
        ChecakDTO cheakDTO = new ChecakDTO(checkID, cheakBank, cheakID,cheakAdvance,cheakAmount);

        String pid = txtPID.getText();
        String reid = txtREGID.getText();
        String dateid = lblDatePayment.getText();
        double taxid = Double.parseDouble(txtTax.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        double amount = Double.parseDouble(txtAmount.getText());
        double balance = Double.parseDouble(lblFullAmount.getText());
        
        PaymentMethodDTO pay = new PaymentMethodDTO(pid, reid, caid, cashdID, checkID, dateid, taxid, discount, amount, balance);
        
        try {
            boolean result = ctrlCard.add(cardDTO, cashDTO, cheakDTO,pay );
            if (result) {
                JOptionPane.showMessageDialog(this, "Payment has been successfully placed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Payment has been successfully placed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to place the Payment", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void searchCustomer() {
            try {
                String regid = txtREGID.getText();
                
                RegistrationDTO reg = ctrlRegistration.search(regid);
                String a = reg.getCid();
                CustomerDTO cust = ctrlCustomer.search(a);
                lblMealType.setText(reg.getMeal_type());
                lblAdultAmount.setText(reg.getNo_of_adults());
                lblChildAmount.setText(reg.getNo_of_children());
                lblRoomAmount.setText(""+reg.getNo_of_rooms());
                lblCheakIn.setText(reg.getCheckin());
                lblChekOut.setText(reg.getCheckout());
                lblCid.setText(reg.getCid());
                lblCustomerTel.setText(""+cust.getTel());
                String first = cust.getFName();
                String last = cust.getLName();
                lblCustomerName.setText(first+" "+last);
                
                try {
                    ArrayList<RoomDetailDTO> service = ctrlRoomDetail.getRoom(txtREGID.getText());
                    
                    dtmChoseRoomDetail.setColumnIdentifiers(new Object[]{"Room ID"});
                    Object[] row = new Object[1];
                    for (int i = 0; i < service.size(); i++) {
                        row[0] = service.get(i).getReid();
                        dtmChoseRoomDetail.addRow(row);
                    }
                    tblChoosRoomDetail.setModel(dtmChoseRoomDetail);
                } catch (Exception ex) {
                    Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
                }
                serachService();
                searchFacility();
            } catch (Exception ex) {
            Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void serachService(){
         
        try {
            ArrayList<ServiceDetailDTO> service = ctrlServicesDetail.getSSSS(txtREGID.getText());
            
            dtmService.setColumnIdentifiers(new Object[]{"Service Id"});
            Object[] row = new Object[1];
            for (int i = 0; i < service.size(); i++) {
                row[0] = service.get(i).getSid();
                dtmService.addRow(row);
            }
            tblChoseServices.setModel(dtmService);
        } catch (Exception ex) {
            Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchFacility(){
     
        try {
            ArrayList<FacilityDetailDTO> facilityDetail = ctrlFacilityDetail.getFacility(txtREGID.getText());
            
            dtmFacility.setColumnIdentifiers(new Object[]{"Facility Id"});
            Object[] row = new Object[1];
            
            for (int i = 0; i < facilityDetail.size(); i++) {
                row[0] = facilityDetail.get(i).getFid();
                dtmFacility.addRow(row);
                loadFacilities(row[0].toString());
            }
            tblChoseFacility.setModel(dtmFacility);
        } catch (Exception ex) {
            Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    private void loadFacilities(String facilityId) throws Exception{
        ArrayList<FacilityDTO> facility = ctrlFacility.getFacility(facilityId);
        
        DefaultTableModel dtm = (DefaultTableModel) tblFacility.getModel();
        Object[] rowData = {facility.get(0).getFid(),
                            facility.get(0).getFacility_Name(),
                            facility.get(0).getPrices()};
        dtm.addRow(rowData);
    }

    private void printBill() {
//        try {
//                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/lk/edu/ijse/hotelmanagementsystem/jasper/Payment.jasper"));
//                HashMap<String, Object> parameters = new HashMap<>();
//                parameters.put("txtREGID", txtREGID.getText());
//                parameters.put("lblCid", lblCid.getText());
//                parameters.put("lblCustomerName", lblCustomerName.getText());
//                parameters.put("lblCustomerTel", lblCustomerTel.getText());
//                parameters.put("lblCheakIn", lblCheakIn.getText());
//                parameters.put("lblChekOut", lblChekOut.getText());
//                parameters.put("lblRoomAmount", lblRoomAmount.getText());
//                parameters.put("lblMealType", lblMealType.getText());
//                parameters.put("lblDatePayment", lblDatePayment.getText());
//                parameters.put("txtPID", txtPID.getText());
//                parameters.put("lblAdultAmount", lblAdultAmount.getText());
//                parameters.put("lblChildAmount", lblChildAmount.getText());
//                
//                parameters.put("txtDiscount", txtDiscount.getText());
//                parameters.put("txtTax", txtTax.getText());
//                parameters.put("lblFullAmount", lblFullAmount.getText());
//                parameters.put("txtCheakAdvance", txtCheakAdvance.getText());
//                parameters.put("txtCheakAmount", txtCheakAmount.getText());
//                parameters.put("txtCardID", txtCardID.getText());
//                parameters.put("txtCardBankName", cmbCardBank.getSelectedItem());
//                parameters.put("txtCardAdvance", txtCardAdvance.getText());
//                parameters.put("txtCardAmount", txtCardAmount.getText());
//                parameters.put("txtCashID", txtCashID.getText());
//                parameters.put("txtCashAdvances", txtCashAdvances.getText());
//                parameters.put("txtCashAmount", txtCashAmount.getText());
//                
//                parameters.put("txtCheakID", txtCheakID.getText());
//                parameters.put("txtCheakBankName", cmbCheakBank.getSelectedItem());
//                
//                
////                JasperPrint fillReport = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
////                MyJasperView jasperView = new MyJasperView(fillReport);
////                jasperView.setVisible(true);
////            } catch (JRException ex) {
////                Logger.getLogger(ReceptionPayment.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }
}