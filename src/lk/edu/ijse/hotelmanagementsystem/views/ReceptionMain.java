/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.views;

import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lk.edu.ijse.hotelmanagementsystem.common.AllDate;
import lk.edu.ijse.hotelmanagementsystem.controller.ControllerFactory;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.CustomerController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.FacilityDetailController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RegistrationController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.RoomDetailController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceController;
import lk.edu.ijse.hotelmanagementsystem.controller.custom.ServiceDetailController;
import lk.edu.ijse.hotelmanagementsystem.dto.CustomerDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.FacilityDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RegistrationDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.RoomDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDTO;
import lk.edu.ijse.hotelmanagementsystem.dto.ServiceDetailDTO;
import lk.edu.ijse.hotelmanagementsystem.idgenerator.IDGenerator;
import lk.edu.ijse.hotelmanagementsystem.others.BackUpController;
import lk.edu.ijse.hotelmanagementsystem.others.RestorController;
import lk.edu.ijse.hotelmanagementsystem.validation.Validation;
import static lk.edu.ijse.hotelmanagementsystem.views.ReceptionPayment.txtAmount;

/**
 *
 * @author USER
 */
public final class ReceptionMain extends javax.swing.JFrame {

    String title = "LY HOTEL GALLE";
    String subString = "";
    private CustomerController ctrlCustomer;
    private RoomController ctrlRoom;
    private RegistrationController ctrlRegistration;
    private FacilityController ctrlFacli;
    private ServiceController ctrlServi;
    private ServiceDetailController ctrlServiDetail;
    private RoomDetailController ctrlRoomDetail;
    private FacilityDetailController ctrlFacilityDetail;
    private DefaultTableModel dtmServ;
    private DefaultTableModel dtmFacili;
    private DefaultTableModel dtmChooseFacili;
    private DefaultTableModel dtmChooseServic;
    private DefaultTableModel dtmChooseRoom;
    private DefaultTableModel dtmChoseRoomDetail2;
    private DefaultTableModel dtmRoomDetail;
    private DefaultTableModel dtmChoseRoomDetail1;

    /**
     * Creates new form ReceptionMain
     */
    public ReceptionMain() {
        initComponents();
//        setDate();
//        coman();
//        customerId();
//        loadComboRoomType();
        setTime();
        RunLable();
//        loadDataFacility();
//        loadDataService();
//        registrationId();
    }

    public void coman() {
        ctrlCustomer = (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CUSTOMER);
        ctrlFacli = (FacilityController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FACILITY);
        dtmFacili = (DefaultTableModel) tblFacility.getModel();
        dtmServ = (DefaultTableModel) tblServices.getModel();
        dtmChoseRoomDetail2 = (DefaultTableModel) tblChooseRoomDetail2.getModel();
        dtmChoseRoomDetail1 = (DefaultTableModel) tblChoosRoomDetail1.getModel();
        dtmRoomDetail = (DefaultTableModel) tblRoomDetail.getModel();
        ctrlServi = (ServiceController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SERVICE);
        tblFacility.getTableHeader().setFont(this.getFont().deriveFont(Font.BOLD));
        tblChooseRoomDetail2.getTableHeader().setFont(this.getFont().deriveFont(Font.BOLD));
        tblRoomDetail.getTableHeader().setFont(this.getFont().deriveFont(Font.BOLD));
        tblServices.getTableHeader().setFont(this.getFont().deriveFont(Font.BOLD));
        tblChoosRoomDetail1.getTableHeader().setFont(this.getFont().deriveFont(Font.BOLD));
        ctrlRoomDetail = (RoomDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM_DETAIL);
        ctrlRoom = (RoomController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM);
        ctrlRegistration = (RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.REGISTRATION);
        ctrlServiDetail = (ServiceDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SERVICE_DETAIL);
        
        ctrlFacilityDetail = (FacilityDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FACILITY_DETAIL);
    }

    public void registrationId() {
        try {
            String id = IDGenerator.getNewID("registration", "reid", "REG0");
            txtREGID.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void customerId() {
        try {
            String id = IDGenerator.getNewID("customer", "cid", "C0");
            txtCid.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataFacility() {

        dtmFacili.setRowCount(0);
        try {
            ArrayList<FacilityDTO> allFac = ctrlFacli.getAll();

            if (allFac == null) {
                return;
            }
            for (FacilityDTO fac : allFac) {

                Object[] rowData = {
                    fac.getFid(),
                    fac.getFacility_Name(),
                    fac.getPrices()
                };
                dtmFacili.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataService() {

        dtmServ.setRowCount(0);
        try {
            ArrayList<ServiceDTO> allSer = ctrlServi.getAll();

            if (allSer == null) {
                return;
            }
            for (ServiceDTO ser : allSer) {

                Object[] rowData = {
                    ser.getSid(),
                    ser.getService_name(),
                    ser.getPrice()
                };
                dtmServ.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataRoom() {

        dtmRoomDetail.setRowCount(0);
        try {
            ArrayList<RoomDTO> allRom = ctrlRoom.getAll();

            if (allRom == null) {
                return;
            }
            for (RoomDTO rom : allRom) {

                Object[] rowData = {
                    rom.getRid(),
                    rom.getRoom_number(),
                    rom.getRoom_decription(),
                    rom.getRoom_floor(),
                    rom.getPrices()

                };
                dtmRoomDetail.addRow(rowData);
            }
        } catch (Exception ex) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblBackUp = new javax.swing.JLabel();
        lblRestor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRunAvalabale = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblChooseRoomPriceAmount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtREGID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lblStep22 = new javax.swing.JLabel();
        lblStep25 = new javax.swing.JLabel();
        lblStep30 = new javax.swing.JLabel();
        lblDeleteServices = new javax.swing.JLabel();
        lblDeleteFacility = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChooseRoomDetail2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblChoseFacility = new javax.swing.JTable();
        btnPaymentChose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblChoseServices = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblNoOfRoom = new javax.swing.JLabel();
        cmbAmountChild = new javax.swing.JComboBox();
        cmbAmountAdult = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblChooseFacilityPriceAmount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblChooseServicePriceAmount = new javax.swing.JLabel();
        lblChooseFullAmount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlSouth = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblDetailRegistration = new javax.swing.JLabel();
        lblManageService = new javax.swing.JLabel();
        lblManageFacility = new javax.swing.JLabel();
        lblManageRoom = new javax.swing.JLabel();
        lblDetailPayment = new javax.swing.JLabel();
        lblDetailRoom = new javax.swing.JLabel();
        lblDetailServices = new javax.swing.JLabel();
        lblDetailFacility = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStep17 = new javax.swing.JLabel();
        lblStep20 = new javax.swing.JLabel();
        cbxDoubleBead = new javax.swing.JRadioButton();
        cbxSingalBead = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        cmbRoomType = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblRoomDetail = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblChoosRoomDetail1 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblStep18 = new javax.swing.JLabel();
        cmbMealType = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        btnChooseRoom = new javax.swing.JButton();
        lblDeleteChoseRoom = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtCid = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnServiceOk = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        btnFacilityOk = new javax.swing.JButton();
        lblCustomerView = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblStep8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPasportNumber = new javax.swing.JTextField();
        cmbCountry = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        lblStep12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFacility = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        btnCustomerSearch = new javax.swing.JButton();
        lblStep6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBackUp.setBackground(new java.awt.Color(0, 0, 51));
        lblBackUp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBackUp.setForeground(new java.awt.Color(255, 255, 255));
        lblBackUp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/Entypo_d83d(0)_64.png"))); // NOI18N
        lblBackUp.setText("BackUp");
        lblBackUp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblBackUp.setOpaque(true);
        lblBackUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackUpMouseClicked(evt);
            }
        });
        getContentPane().add(lblBackUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        lblRestor.setBackground(new java.awt.Color(0, 0, 51));
        lblRestor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRestor.setForeground(new java.awt.Color(255, 255, 255));
        lblRestor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/Entypo_d83d(1)_64.png"))); // NOI18N
        lblRestor.setText("Restor");
        lblRestor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblRestor.setOpaque(true);
        lblRestor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestorMouseClicked(evt);
            }
        });
        getContentPane().add(lblRestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 50));

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/MiniMaz.png"))); // NOI18N
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 50, 50));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/edu/ijse/hotelmanagementsystem/icon/Close.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 50, 50));

        lblRunAvalabale.setBackground(new java.awt.Color(0, 0, 51));
        lblRunAvalabale.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblRunAvalabale.setForeground(new java.awt.Color(255, 255, 255));
        lblRunAvalabale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRunAvalabale.setText("LY HOTEL GALLE");
        lblRunAvalabale.setOpaque(true);
        getContentPane().add(lblRunAvalabale, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 970, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblChooseRoomPriceAmount.setBackground(new java.awt.Color(204, 204, 204));
        lblChooseRoomPriceAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChooseRoomPriceAmount.setForeground(new java.awt.Color(51, 51, 51));
        lblChooseRoomPriceAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChooseRoomPriceAmount.setOpaque(true);
        jPanel3.add(lblChooseRoomPriceAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 110, 30));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Amount");
        jLabel6.setOpaque(true);
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 50, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("No Of Room");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 90, 20));

        txtREGID.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(txtREGID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 120, 20));

        jLabel21.setBackground(new java.awt.Color(0, 0, 51));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Room Detail");
        jLabel21.setOpaque(true);
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 30));

        lblStep22.setBackground(new java.awt.Color(0, 0, 51));
        lblStep22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep22.setForeground(new java.awt.Color(255, 255, 255));
        lblStep22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep22.setText("Facility ");
        lblStep22.setOpaque(true);
        jPanel3.add(lblStep22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 30));

        lblStep25.setBackground(new java.awt.Color(0, 0, 51));
        lblStep25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep25.setForeground(new java.awt.Color(255, 255, 255));
        lblStep25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep25.setText("Registration");
        lblStep25.setOpaque(true);
        jPanel3.add(lblStep25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));

        lblStep30.setBackground(new java.awt.Color(0, 0, 51));
        lblStep30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep30.setForeground(new java.awt.Color(255, 255, 255));
        lblStep30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep30.setText("Services");
        lblStep30.setOpaque(true);
        jPanel3.add(lblStep30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 200, 30));

        lblDeleteServices.setBackground(new java.awt.Color(51, 51, 51));
        lblDeleteServices.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeleteServices.setForeground(new java.awt.Color(255, 255, 255));
        lblDeleteServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeleteServices.setText("Delete");
        lblDeleteServices.setOpaque(true);
        lblDeleteServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteServicesMouseClicked(evt);
            }
        });
        jPanel3.add(lblDeleteServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 50, 30));

        lblDeleteFacility.setBackground(new java.awt.Color(51, 51, 51));
        lblDeleteFacility.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeleteFacility.setForeground(new java.awt.Color(255, 255, 255));
        lblDeleteFacility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeleteFacility.setText("Delete");
        lblDeleteFacility.setOpaque(true);
        lblDeleteFacility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteFacilityMouseClicked(evt);
            }
        });
        jPanel3.add(lblDeleteFacility, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 50, 30));

        tblChooseRoomDetail2.setBackground(new java.awt.Color(204, 204, 204));
        tblChooseRoomDetail2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Room Number", "Description", "Room Floor", "Price"
            }
        ));
        tblChooseRoomDetail2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChooseRoomDetail2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblChooseRoomDetail2);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 410, 80));

        tblChoseFacility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Facility ID", "Facilitity Name", "Price"
            }
        ));
        jScrollPane9.setViewportView(tblChoseFacility);

        jPanel3.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 410, 90));

        btnPaymentChose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPaymentChose.setText("Pay");
        btnPaymentChose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentChoseMouseClicked(evt);
            }
        });
        btnPaymentChose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentChoseActionPerformed(evt);
            }
        });
        jPanel3.add(btnPaymentChose, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 110, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 110, 30));

        tblChoseServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Services ID", "Services  Name", "Price"
            }
        ));
        jScrollPane10.setViewportView(tblChoseServices);

        jPanel3.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 410, 120));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Child Am.");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 90, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Regester ID");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 90, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText(" Adult Am.");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 90, 20));

        lblNoOfRoom.setBackground(new java.awt.Color(255, 255, 255));
        lblNoOfRoom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNoOfRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoOfRoom.setOpaque(true);
        jPanel3.add(lblNoOfRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 80, 20));

        cmbAmountChild.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        jPanel3.add(cmbAmountChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 80, -1));

        cmbAmountAdult.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        jPanel3.add(cmbAmountAdult, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 80, -1));

        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Amount");
        jLabel7.setOpaque(true);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 50, 30));

        lblChooseFacilityPriceAmount.setBackground(new java.awt.Color(204, 204, 204));
        lblChooseFacilityPriceAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChooseFacilityPriceAmount.setForeground(new java.awt.Color(51, 51, 51));
        lblChooseFacilityPriceAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChooseFacilityPriceAmount.setOpaque(true);
        jPanel3.add(lblChooseFacilityPriceAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 110, 30));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Amount");
        jLabel8.setOpaque(true);
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 50, 30));

        lblChooseServicePriceAmount.setBackground(new java.awt.Color(204, 204, 204));
        lblChooseServicePriceAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChooseServicePriceAmount.setForeground(new java.awt.Color(51, 51, 51));
        lblChooseServicePriceAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChooseServicePriceAmount.setOpaque(true);
        jPanel3.add(lblChooseServicePriceAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 110, 30));

        lblChooseFullAmount.setBackground(new java.awt.Color(204, 204, 204));
        lblChooseFullAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChooseFullAmount.setForeground(new java.awt.Color(51, 51, 51));
        lblChooseFullAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChooseFullAmount.setOpaque(true);
        jPanel3.add(lblChooseFullAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 120, 20));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Amount");
        jLabel9.setOpaque(true);
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 80, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, 430, 650));

        pnlSouth.setBackground(new java.awt.Color(255, 255, 255));
        pnlSouth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlSouth.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 110, 40));

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlSouth.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 140, 40));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pnlSouth.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 20, 50));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pnlSouth.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 20, 50));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnlSouth.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        lblDetailRegistration.setBackground(new java.awt.Color(0, 0, 51));
        lblDetailRegistration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailRegistration.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailRegistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailRegistration.setText("Regis. Detail");
        lblDetailRegistration.setOpaque(true);
        lblDetailRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailRegistrationMouseClicked(evt);
            }
        });
        pnlSouth.add(lblDetailRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 110, 30));

        lblManageService.setBackground(new java.awt.Color(0, 0, 51));
        lblManageService.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblManageService.setForeground(new java.awt.Color(255, 255, 255));
        lblManageService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManageService.setText("Manage Service");
        lblManageService.setOpaque(true);
        lblManageService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageServiceMouseClicked(evt);
            }
        });
        pnlSouth.add(lblManageService, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 110, 30));

        lblManageFacility.setBackground(new java.awt.Color(0, 0, 51));
        lblManageFacility.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblManageFacility.setForeground(new java.awt.Color(255, 255, 255));
        lblManageFacility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManageFacility.setText("Manage Facility");
        lblManageFacility.setOpaque(true);
        lblManageFacility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageFacilityMouseClicked(evt);
            }
        });
        pnlSouth.add(lblManageFacility, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 110, 30));

        lblManageRoom.setBackground(new java.awt.Color(0, 0, 51));
        lblManageRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblManageRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblManageRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManageRoom.setText("Manage Room");
        lblManageRoom.setOpaque(true);
        lblManageRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageRoomMouseClicked(evt);
            }
        });
        pnlSouth.add(lblManageRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 110, 30));

        lblDetailPayment.setBackground(new java.awt.Color(0, 0, 51));
        lblDetailPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailPayment.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailPayment.setText("Payment Detail");
        lblDetailPayment.setOpaque(true);
        lblDetailPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailPaymentMouseClicked(evt);
            }
        });
        pnlSouth.add(lblDetailPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 110, 30));

        lblDetailRoom.setBackground(new java.awt.Color(0, 0, 51));
        lblDetailRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailRoom.setText("Room Detail");
        lblDetailRoom.setOpaque(true);
        lblDetailRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailRoomMouseClicked(evt);
            }
        });
        pnlSouth.add(lblDetailRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 110, 30));

        lblDetailServices.setBackground(new java.awt.Color(0, 0, 51));
        lblDetailServices.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailServices.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailServices.setText("Service Detail");
        lblDetailServices.setOpaque(true);
        lblDetailServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailServicesMouseClicked(evt);
            }
        });
        pnlSouth.add(lblDetailServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 110, 30));

        lblDetailFacility.setBackground(new java.awt.Color(0, 0, 51));
        lblDetailFacility.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailFacility.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailFacility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetailFacility.setText("Facility Detail");
        lblDetailFacility.setOpaque(true);
        lblDetailFacility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailFacilityMouseClicked(evt);
            }
        });
        pnlSouth.add(lblDetailFacility, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 110, 30));

        getContentPane().add(pnlSouth, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 1370, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStep17.setBackground(new java.awt.Color(0, 0, 51));
        lblStep17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep17.setForeground(new java.awt.Color(255, 255, 255));
        lblStep17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep17.setText("Chose Room");
        lblStep17.setOpaque(true);
        jPanel2.add(lblStep17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 380, 30));

        lblStep20.setBackground(new java.awt.Color(0, 0, 51));
        lblStep20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep20.setForeground(new java.awt.Color(255, 255, 255));
        lblStep20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep20.setText("Room");
        lblStep20.setOpaque(true);
        jPanel2.add(lblStep20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));

        cbxDoubleBead.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbxDoubleBead);
        cbxDoubleBead.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxDoubleBead.setText("Double Bead");
        jPanel2.add(cbxDoubleBead, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 110, 20));

        cbxSingalBead.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbxSingalBead);
        cbxSingalBead.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxSingalBead.setText("Singal Bead");
        jPanel2.add(cbxSingalBead, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 110, 20));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Bed Type");
        jLabel29.setOpaque(true);
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 410, 20));

        jPanel2.add(cmbRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 200, 30));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Chek In");
        jLabel31.setOpaque(true);
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 30));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 90, 30));

        tblRoomDetail.setBackground(new java.awt.Color(204, 204, 204));
        tblRoomDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Room Number", "Description", "Room Floor", "Price"
            }
        ));
        tblRoomDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomDetailMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblRoomDetail);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 410, 120));

        tblChoosRoomDetail1.setBackground(new java.awt.Color(204, 204, 204));
        tblChoosRoomDetail1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Room Number", "Description", "Room Floor", "Price"
            }
        ));
        tblChoosRoomDetail1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChoosRoomDetail1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblChoosRoomDetail1);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 410, 110));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Room Type");
        jLabel33.setOpaque(true);
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 410, 30));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Chek Out");
        jLabel34.setOpaque(true);
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 410, 30));

        lblStep18.setBackground(new java.awt.Color(0, 0, 51));
        lblStep18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep18.setForeground(new java.awt.Color(255, 255, 255));
        lblStep18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep18.setText("Chose Meal");
        lblStep18.setOpaque(true);
        jPanel2.add(lblStep18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 430, 30));

        cmbMealType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FullBord", "Half Bord", "Room Only" }));
        jPanel2.add(cmbMealType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 190, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Meal Type");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 110, 20));

        btnChooseRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChooseRoom.setText("Ok");
        btnChooseRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseRoomActionPerformed(evt);
            }
        });
        jPanel2.add(btnChooseRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 90, 20));

        lblDeleteChoseRoom.setBackground(new java.awt.Color(51, 51, 51));
        lblDeleteChoseRoom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeleteChoseRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblDeleteChoseRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeleteChoseRoom.setText("Delete");
        lblDeleteChoseRoom.setOpaque(true);
        lblDeleteChoseRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteChoseRoomMouseClicked(evt);
            }
        });
        jPanel2.add(lblDeleteChoseRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 50, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCid.setBackground(new java.awt.Color(204, 204, 204));
        txtCid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidKeyPressed(evt);
            }
        });
        jPanel1.add(txtCid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, 20));

        txtFirstName.setBackground(new java.awt.Color(204, 204, 204));
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 300, 20));

        txtLastName.setBackground(new java.awt.Color(204, 204, 204));
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLastNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 300, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Last Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("First Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Address");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("E-Mail");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 20));

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 300, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Country");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 20));

        btnServiceOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnServiceOk.setText("Ok");
        btnServiceOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiceOkActionPerformed(evt);
            }
        });
        jPanel1.add(btnServiceOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 60, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("NIC");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Tel");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 20));

        txtTel.setBackground(new java.awt.Color(204, 204, 204));
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelKeyReleased(evt);
            }
        });
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 300, 20));

        txtNIC.setBackground(new java.awt.Color(204, 204, 204));
        txtNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNICKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNICKeyReleased(evt);
            }
        });
        jPanel1.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 300, 20));

        btnFacilityOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFacilityOk.setText("Ok");
        btnFacilityOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacilityOkActionPerformed(evt);
            }
        });
        jPanel1.add(btnFacilityOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 60, 30));

        lblCustomerView.setBackground(new java.awt.Color(51, 51, 51));
        lblCustomerView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCustomerView.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomerView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomerView.setText("View");
        lblCustomerView.setOpaque(true);
        lblCustomerView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCustomerViewMouseClicked(evt);
            }
        });
        jPanel1.add(lblCustomerView, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 50, 30));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 300, 50));

        lblStep8.setBackground(new java.awt.Color(0, 0, 51));
        lblStep8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep8.setForeground(new java.awt.Color(255, 255, 255));
        lblStep8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep8.setText("Customer ");
        lblStep8.setOpaque(true);
        jPanel1.add(lblStep8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Pasport Num.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 20));

        txtPasportNumber.setBackground(new java.awt.Color(204, 204, 204));
        txtPasportNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasportNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasportNumberKeyReleased(evt);
            }
        });
        jPanel1.add(txtPasportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 300, 20));

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select Country -", "Sri Lanka", "India", "Japan", "Rusiya", "Bangaladash", "Singapur", "England", " " }));
        cmbCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCountryKeyPressed(evt);
            }
        });
        jPanel1.add(cmbCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, 20));

        tblServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Services ID", "Services  Name", "Price"
            }
        ));
        jScrollPane2.setViewportView(tblServices);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 410, 100));

        lblStep12.setBackground(new java.awt.Color(0, 0, 51));
        lblStep12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep12.setForeground(new java.awt.Color(255, 255, 255));
        lblStep12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep12.setText("Services");
        lblStep12.setOpaque(true);
        jPanel1.add(lblStep12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 370, 30));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 410, 100));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("CID");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 20));

        btnCustomerSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCustomerSearch.setText("Search");
        btnCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnCustomerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 90, -1));

        lblStep6.setBackground(new java.awt.Color(0, 0, 51));
        lblStep6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStep6.setForeground(new java.awt.Color(255, 255, 255));
        lblStep6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStep6.setText("Facility ");
        lblStep6.setOpaque(true);
        jPanel1.add(lblStep6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 430, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtLastName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtLastName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtCid.requestFocus();
        }
    }//GEN-LAST:event_txtFirstNameKeyPressed

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased
        Validation.validateName(txtFirstName);
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void tblChooseRoomDetail2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChooseRoomDetail2MouseClicked


    }//GEN-LAST:event_tblChooseRoomDetail2MouseClicked

    private void tblRoomDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRoomDetailMouseClicked

    private void tblChoosRoomDetail1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoosRoomDetail1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblChoosRoomDetail1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        backLogIn();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblDetailRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailRegistrationMouseClicked
        viewRegistrationDetail();
    }//GEN-LAST:event_lblDetailRegistrationMouseClicked

    private void btnPaymentChoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentChoseMouseClicked
        //
    }//GEN-LAST:event_btnPaymentChoseMouseClicked

    private void btnCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerSearchActionPerformed
        searchCustomer();
    }//GEN-LAST:event_btnCustomerSearchActionPerformed

    private void lblCustomerViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomerViewMouseClicked
        loadViewCustomer();
    }//GEN-LAST:event_lblCustomerViewMouseClicked

    private void tblFacilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacilityMouseClicked
        //
    }//GEN-LAST:event_tblFacilityMouseClicked

    private void btnServiceOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceOkActionPerformed
        TableModel services = tblServices.getModel();
        int[] index = tblServices.getSelectedRows();
        Object[] row = new Object[3];
        dtmChooseServic = (DefaultTableModel) tblChoseServices.getModel();
        for (int i = 0; i < index.length; i++) {
            row[0] = services.getValueAt(index[i], 0);
            row[1] = services.getValueAt(index[i], 1);
            row[2] = services.getValueAt(index[i], 2);
            dtmChooseServic.addRow(row);
            double total = 0;
            for (int j = 0; j < tblChoseServices.getRowCount(); j++) {
                double amount = Double.parseDouble(tblChoseServices.getValueAt(j, 2).toString());
            }
        }
        amount();
    }//GEN-LAST:event_btnServiceOkActionPerformed

    private void btnFacilityOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilityOkActionPerformed
        TableModel facility = tblFacility.getModel();
        int[] index = tblFacility.getSelectedRows();
        Object[] row = new Object[3];
        dtmChooseFacili = (DefaultTableModel) tblChoseFacility.getModel();
        for (int i = 0; i < index.length; i++) {
            row[0] = facility.getValueAt(index[i], 0);
            row[1] = facility.getValueAt(index[i], 1);
            row[2] = facility.getValueAt(index[i], 2);
            dtmChooseFacili.addRow(row);
            double total = 0;
            for (int j = 0; j < tblChoseFacility.getRowCount(); j++) {
                double amount = Double.parseDouble(tblChoseFacility.getValueAt(j, 2).toString());
                total+=amount;
            }
            lblChooseFacilityPriceAmount.setText(String.valueOf(total));
            try {
                String update ="";
            } catch (Exception e) {

            }
        }
        amount();
    }//GEN-LAST:event_btnFacilityOkActionPerformed

    private void btnChooseRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseRoomActionPerformed
        TableModel room = tblRoomDetail.getModel();
        int[] index = tblRoomDetail.getSelectedRows();
        Object[] row = new Object[5];
        dtmChoseRoomDetail1 = (DefaultTableModel) tblChoosRoomDetail1.getModel();
        dtmChoseRoomDetail2 = (DefaultTableModel) tblChooseRoomDetail2.getModel();
        for (int i = 0; i < index.length; i++) {
            row[0] = room.getValueAt(index[i], 0);
            row[1] = room.getValueAt(index[i], 1);
            row[2] = room.getValueAt(index[i], 2);
            row[3] = room.getValueAt(index[i], 3);
            row[4] = room.getValueAt(index[i], 4);
            dtmChoseRoomDetail1.addRow(row);
            dtmChoseRoomDetail2.addRow(row);
            
            tblRowCount();
            double total = 0;
            for (int j = 0; j < tblChoosRoomDetail1.getRowCount(); j++) {
                double amount = Double.parseDouble(tblChoosRoomDetail1.getValueAt(j, 4).toString());
                total+=amount;
            }
            lblChooseRoomPriceAmount.setText(String.valueOf(total));
            try {
                String update ="";
                } catch (Exception e) {
                    
            }
        }
        amount();
    }//GEN-LAST:event_btnChooseRoomActionPerformed

    private void txtLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyReleased
        Validation.validateName(txtLastName);
    }//GEN-LAST:event_txtLastNameKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        Validation.emailValidate(txtEmail);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased

    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyReleased
        Validation.validatePhoneNumber(txtTel);
    }//GEN-LAST:event_txtTelKeyReleased

    private void txtNICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyReleased
        Validation.validateNIC(txtNIC);
    }//GEN-LAST:event_txtNICKeyReleased

    private void txtPasportNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasportNumberKeyReleased
        //
    }//GEN-LAST:event_txtPasportNumberKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addTransaction();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPaymentChoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentChoseActionPerformed
        viewPayment();
        loadAmountPayment();
    }//GEN-LAST:event_btnPaymentChoseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        avalableRoomSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void lblManageServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageServiceMouseClicked
        manageServices();
    }//GEN-LAST:event_lblManageServiceMouseClicked

    private void lblManageFacilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageFacilityMouseClicked
        manageFacility();
    }//GEN-LAST:event_lblManageFacilityMouseClicked

    private void lblManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageRoomMouseClicked
        manageRoom();
    }//GEN-LAST:event_lblManageRoomMouseClicked

    private void lblDetailPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailPaymentMouseClicked
        paymentDetail();
    }//GEN-LAST:event_lblDetailPaymentMouseClicked

    private void lblDetailRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailRoomMouseClicked
        viewRoomDetail();
    }//GEN-LAST:event_lblDetailRoomMouseClicked

    private void lblDetailServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailServicesMouseClicked
        viewServicesDetail();
    }//GEN-LAST:event_lblDetailServicesMouseClicked

    private void lblDetailFacilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailFacilityMouseClicked
        viewFacilityDetail();
    }//GEN-LAST:event_lblDetailFacilityMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lblRestorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestorMouseClicked
        restorBackUp();
    }//GEN-LAST:event_lblRestorMouseClicked

    private void lblBackUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackUpMouseClicked
        bacUp();
    }//GEN-LAST:event_lblBackUpMouseClicked

    private void lblDeleteChoseRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteChoseRoomMouseClicked
        int se = tblChoosRoomDetail1.getSelectedRow();
        dtmChoseRoomDetail1.removeRow(se);
        dtmChoseRoomDetail2.removeRow(se);
        double total = 0;
        for (int j = 0; j < tblChoosRoomDetail1.getRowCount(); j++) {
            double amount = Double.parseDouble(tblChoosRoomDetail1.getValueAt(j, 4).toString());
            total+=amount;
        }
        lblChooseRoomPriceAmount.setText(String.valueOf(total));
        try {
            String update ="";
            } catch (Exception e) {

        }
        amount();
    }//GEN-LAST:event_lblDeleteChoseRoomMouseClicked

    private void lblDeleteFacilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteFacilityMouseClicked
        int se = tblChoseFacility.getSelectedRow();
        dtmChooseFacili.removeRow(se);
        double total = 0;
        for (int j = 0; j < tblChoseFacility.getRowCount(); j++) {
        double amount = Double.parseDouble(tblChoseFacility.getValueAt(j, 2).toString());
        total+=amount;
        }
        lblChooseFacilityPriceAmount.setText(String.valueOf(total));
        try {
            String update ="";
        } catch (Exception e) {
            
        }
        amount();
    }//GEN-LAST:event_lblDeleteFacilityMouseClicked

    private void lblDeleteServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteServicesMouseClicked
        int se = tblChoseServices.getSelectedRow();
        dtmChooseServic.removeRow(se);
        double total = 0;
        for (int j = 0; j < tblChoseServices.getRowCount(); j++) {
            double amount = Double.parseDouble(tblChoseServices.getValueAt(j, 2).toString());
            total+=amount;
        }
        lblChooseServicePriceAmount.setText(String.valueOf(total));
        try {
             String update ="";
        } catch (Exception e) {

        }
        amount();
    }//GEN-LAST:event_lblDeleteServicesMouseClicked

    private void txtLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAddress.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtAddress.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtFirstName.requestFocus();
        }
    }//GEN-LAST:event_txtLastNameKeyPressed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmail.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtEmail.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtLastName.requestFocus();
        }
    }//GEN-LAST:event_txtAddressKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtTel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtTelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNIC.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtNIC.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtTel.requestFocus();
        }
    }//GEN-LAST:event_txtTelKeyPressed

    private void txtNICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPasportNumber.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPasportNumber.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtTel.requestFocus();
        }
    }//GEN-LAST:event_txtNICKeyPressed

    private void txtPasportNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasportNumberKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCountry.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            cmbCountry.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtNIC.requestFocus();
        }
    }//GEN-LAST:event_txtPasportNumberKeyPressed

    private void cmbCountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCountryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnSave.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtPasportNumber.requestFocus();
        }
    }//GEN-LAST:event_cmbCountryKeyPressed

    private void txtCidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFirstName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtFirstName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            cmbMealType.requestFocus();
        }
    }//GEN-LAST:event_txtCidKeyPressed

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
            java.util.logging.Logger.getLogger(ReceptionMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseRoom;
    private javax.swing.JButton btnCustomerSearch;
    private javax.swing.JButton btnFacilityOk;
    private javax.swing.JButton btnPaymentChose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnServiceOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbxDoubleBead;
    private javax.swing.JRadioButton cbxSingalBead;
    private javax.swing.JComboBox cmbAmountAdult;
    private javax.swing.JComboBox cmbAmountChild;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbMealType;
    private javax.swing.JComboBox cmbRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBackUp;
    private javax.swing.JLabel lblChooseFacilityPriceAmount;
    private javax.swing.JLabel lblChooseFullAmount;
    private javax.swing.JLabel lblChooseRoomPriceAmount;
    private javax.swing.JLabel lblChooseServicePriceAmount;
    private javax.swing.JLabel lblCustomerView;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeleteChoseRoom;
    private javax.swing.JLabel lblDeleteFacility;
    private javax.swing.JLabel lblDeleteServices;
    private javax.swing.JLabel lblDetailFacility;
    private javax.swing.JLabel lblDetailPayment;
    private javax.swing.JLabel lblDetailRegistration;
    private javax.swing.JLabel lblDetailRoom;
    private javax.swing.JLabel lblDetailServices;
    private javax.swing.JLabel lblManageFacility;
    private javax.swing.JLabel lblManageRoom;
    private javax.swing.JLabel lblManageService;
    private javax.swing.JLabel lblNoOfRoom;
    private javax.swing.JLabel lblRestor;
    private javax.swing.JLabel lblRunAvalabale;
    private javax.swing.JLabel lblStep12;
    private javax.swing.JLabel lblStep17;
    private javax.swing.JLabel lblStep18;
    private javax.swing.JLabel lblStep20;
    private javax.swing.JLabel lblStep22;
    private javax.swing.JLabel lblStep25;
    private javax.swing.JLabel lblStep30;
    private javax.swing.JLabel lblStep6;
    private javax.swing.JLabel lblStep8;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlSouth;
    public static javax.swing.JTable tblChoosRoomDetail1;
    public static javax.swing.JTable tblChooseRoomDetail2;
    private javax.swing.JTable tblChoseFacility;
    private javax.swing.JTable tblChoseServices;
    private javax.swing.JTable tblFacility;
    public static javax.swing.JTable tblRoomDetail;
    private javax.swing.JTable tblServices;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCid;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtPasportNumber;
    private javax.swing.JTextField txtREGID;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables

    public void RunLable() {
        setFont(new Font("Areal", 3, 12));
        setTitle(" \" LY HOTEL GALLE   \'1.5 VERSION\' \"");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        new Thread() {
            public void run() {
                for (int i = 0; i < title.length() + 1; i++) {
                    try {
                        if (i == title.length()) {
                            i = 0;
                            subString = "";
                        }
                        subString += title.substring(i, i + 1);
                        lblRunAvalabale.setText(subString);
                        sleep(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(ReceptionMain.this, "Database Error...");
                    }
                }
            }
        }.start();
    }

    private void setDate() {
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        lblDate.setText(sf.format(now));
    }

    private void setDates() {
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        ReceptionPayment.lblDatePayment.setText(sf.format(now));
    }

    private void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date date = new Date();
                    String currentdate = new SimpleDateFormat("hh:mm:ss aa").format(date);
                    lblTime.setText(currentdate);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }).start();
    }

    private void addCustomer() {

        String cid = txtCid.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String e_mail = txtEmail.getText();
        int tel = Integer.parseInt(txtTel.getText());
        String nic = txtNIC.getText();
        String pasPortID = txtPasportNumber.getText();
        String country = cmbCountry.getSelectedItem().toString();

        CustomerDTO customer = new CustomerDTO(cid, firstName, lastName, e_mail, address, country, pasPortID, nic, tel);
        try {
            boolean add = ctrlCustomer.add(customer);
            if (add) {
                JOptionPane.showMessageDialog(this, "Customer Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Customer Added Failed");
            }
        } catch (Exception e) {
        }
        cleanTxt();
        
    }

    public void cleanTxt() {

        txtCid.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtNIC.setText("");
        txtTel.setText("");
        txtPasportNumber.setText("");
    }

    private void searchCustomer() {
        String cid = txtCid.getText();

        try {
            CustomerDTO foodDetailList = ctrlCustomer.search(cid);
            if (foodDetailList == null) {
                JOptionPane.showMessageDialog(this, "Customer not found..");
            } else {
                txtCid.setText(foodDetailList.getCid());
                txtFirstName.setText(foodDetailList.getFName());
                txtLastName.setText(foodDetailList.getLName());
                txtAddress.setText(foodDetailList.getAddress());
                txtEmail.setText(foodDetailList.getEmail());
                txtTel.setText("" + foodDetailList.getTel());
                txtNIC.setText(foodDetailList.getNic());
                txtPasportNumber.setText(cid);
                cmbCountry.setSelectedItem(foodDetailList.getCountry());

            }
        } catch (Exception e) {
            Logger.getLogger(ReceptionMain.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadViewCustomer() {
        new ViewCustomerDetail().setVisible(true);
        //this.dispose();
    }

    private void loadComboRoomType() {
        try {

            ArrayList<RoomDTO> all = ctrlRoom.getAll();
            cmbRoomType.removeAllItems();
            ArrayList<String> list = new ArrayList<>();
            for (RoomDTO all1 : all) {
                //
                if (!list.contains(all1.getRoom_type())) {
                    list.add(all1.getRoom_type());
                    cmbRoomType.addItem(all1.getRoom_type());

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tblRowCount() {
        int s = tblChooseRoomDetail2.getRowCount();
        lblNoOfRoom.setText(s + "");
    }

    private void addTransaction() {
        String cid = txtCid.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String e_mail = txtEmail.getText();
        int tel = Integer.parseInt(txtTel.getText());
        String nic = txtNIC.getText();
        String pasPortID = txtPasportNumber.getText();
        String country = cmbCountry.getSelectedItem().toString();

        CustomerDTO customer = new CustomerDTO(cid, firstName, lastName, e_mail, address, country, pasPortID, nic, tel);
        
//        Date date = dteChehkIn.getDate();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String format = sdf.format(date);

//        Date date1 = dteChekOut.getDate();
        
        Date date1 = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        String format1 = sdf1.format(date1);

        String rid = txtREGID.getText();
        String chekin = format;
        String chekout = format1;
        int romAmount = Integer.parseInt(lblNoOfRoom.getText());
        String adult = cmbAmountAdult.getSelectedItem().toString();
        String child = cmbAmountChild.getSelectedItem().toString();
        String meal = cmbMealType.getSelectedItem().toString();

        RegistrationDTO regDTO = new RegistrationDTO(rid, cid, chekin, chekout, romAmount, adult, child, meal);
        ArrayList<ServiceDetailDTO> alServiceDetail = new ArrayList<>();

        ArrayList<RoomDetailDTO> alRoomDetail = new ArrayList<>();

        ArrayList<FacilityDetailDTO> alFacilityDetail = new ArrayList<>();

        for (int i = 0; i < dtmChooseServic.getRowCount(); i++) {
            ServiceDetailDTO serviceDetail = new ServiceDetailDTO(
                    regDTO.getReid(),
                    dtmChooseServic.getValueAt(i, 0).toString()
            );
            alServiceDetail.add(serviceDetail);

            for (int j = 0; j < dtmChoseRoomDetail2.getRowCount(); j++) {
                RoomDetailDTO roomDetail = new RoomDetailDTO(
                        regDTO.getReid(),
                        dtmChoseRoomDetail2.getValueAt(i, 0).toString()
                );
                alRoomDetail.add(roomDetail);

                for (int h = 0; h < dtmChooseFacili.getRowCount(); h++) {
                    FacilityDetailDTO facilityDetail = new FacilityDetailDTO(
                            regDTO.getReid(),
                            dtmChooseFacili.getValueAt(i, 0).toString()
                    );
                    alFacilityDetail.add(facilityDetail);
                }
            }
        }

        try {
            boolean result = ctrlRegistration.add(customer, regDTO, alServiceDetail, alRoomDetail, alFacilityDetail);
            if (result) {
                JOptionPane.showMessageDialog(this, "Order has been successfully placed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to place the order", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to place the order", "Error", JOptionPane.ERROR_MESSAGE);
            Logger
                    .getLogger(ReceptionMain.class
                            .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void viewRegistrationDetail() {
        new ViewRegistrationDetail().setVisible(true);
        //this.dispose();
    }

    private void viewRoomDetail() {
        new ViewRoomDetail().setVisible(true);
    }

    private void viewFacilityDetail() {
        new ViewFacilityDetail().setVisible(true);
    }

    private void viewServicesDetail() {
        new ViewServicesDetail().setVisible(true);
    }

    private void manageServices() {
        new ManageServicesDetail().setVisible(true);
    }

    private void manageFacility() {
        new ManageFacilityDetail().setVisible(true);
    }

    private void manageRoom() {
        new ManageRoomDetail().setVisible(true);
    }

    private void backLogIn() {
        new LogIn().setVisible(true);
        this.dispose();
    }

    private void viewPayment() {
        new ReceptionPayment().setVisible(true);
        setDates();
    }

    private void bacUp() {
        JFileChooser fc = new JFileChooser("D:\\New Folder");
        fc.showSaveDialog(this);
        File file = fc.getSelectedFile();
        String path = file.getAbsolutePath();

        try {
            int res = BackUpController.wrigthBackUp(path);
            if (res == 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");

            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ReceptionMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void restorBackUp() {

        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File file = fc.getSelectedFile();
        String path = file.getAbsolutePath();
        try {
            int res = RestorController.restorBackUp(path);
            if (res == 0) {
                System.out.println("Restore success");
            } else {
                System.out.println("Restore failed");

            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ReceptionMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void avalableRoomSearch() {
        try {
//            Date inDate = dteChehkIn.getDate();
            Date inDate =null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//            Date outDate = dteChekOut.getDate();
            Date outDate = null;
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            String inDateS = sdf.format(inDate);
            String outDateS = sdf1.format(outDate);

            String rmType = cmbRoomType.getSelectedItem().toString();
            boolean selected = cbxSingalBead.isSelected();
            boolean selected1 = cbxDoubleBead.isSelected();
            String bedType = "";
            if (selected) {
                bedType = "Singal Bead";
            } else if (selected1) {
                bedType = "Double Bead";
            }

            ArrayList<String> allDatesInTheRange = AllDate.getAllDatesInTheRange(inDateS, outDateS);
            
            
            ArrayList<RegistrationDTO> all = ctrlRegistration.getAll();
            ArrayList<String> al = new ArrayList<>();
            String availableDates = "";
            String roomNos = "";
            for (RegistrationDTO all1 : all) {
                String reid = all1.getReid();
                RoomDetailDTO search = ctrlRoomDetail.search(reid);
                String rid = search.getRid();
                
                RoomDTO search1 = ctrlRoom.search(rid);
                
                String room_type = search1.getRoom_type();
                String bed_type = search1.getBed_type();

                if (room_type.equals(rmType) && bedType.equals(bed_type)) {
                    String allDates = "";
                    String checkin = all1.getCheckin();
                    String checkout = all1.getCheckout();
                    ArrayList<String> allDatesInTheRange1 = AllDate.getAllDatesInTheRange(checkin, checkout);
                    for (String allDatesInTheRange11 : allDatesInTheRange1) {
                        for (int i = 0; i < allDatesInTheRange.size() - 1; i++) {
                            String get = allDatesInTheRange.get(i);
                            if (allDatesInTheRange11.equals(get)) {
                                allDates = allDates + (get + ",");
                            }
                        }
                    }
                    if (!"".equals(allDates)) {
                        availableDates = allDates;
                        String reids = all1.getReid();
                        RoomDetailDTO searches = ctrlRoomDetail.search(reids);
                        String rids = searches.getRid();
                        roomNos = roomNos + rids + ",";
                    }
                }

            }

            String[] split = roomNos.split(",");
            for (String split1 : split) {
                System.out.println(split1);
                ArrayList<RoomDTO> room = ctrlRoom.getAll();
                dtmRoomDetail.setRowCount(0);
                for (RoomDTO room1 : room) {
                    if (!split1.equals(room1.getRid())) {
                        Object[] os = {room1.getRid(), room1.getRoom_number(), room1.getRoom_decription(),
                            room1.getRoom_floor(), room1.getPrices()};
                        dtmRoomDetail.addRow(os);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void amount(){
        
        
        if(!"".equals(lblChooseFacilityPriceAmount.getText())){
            lblChooseFacilityPriceAmount.getText();
        }else{
            lblChooseFacilityPriceAmount.setText("0.00");
        }
        
        if(!"".equals(lblChooseServicePriceAmount.getText())){
            lblChooseServicePriceAmount.getText();
        }else{
            lblChooseServicePriceAmount.setText("0.00");
        }
        
        if(!"".equals(lblChooseRoomPriceAmount.getText())){
            lblChooseRoomPriceAmount.getText();
        }else{
            lblChooseRoomPriceAmount.setText("0.00");
        }
        
        double fac = Double.parseDouble(lblChooseFacilityPriceAmount.getText());
        double rom = Double.parseDouble(lblChooseRoomPriceAmount.getText());
        double ser = Double.parseDouble(lblChooseServicePriceAmount.getText());
        double balance = fac + rom + ser;
        lblChooseFullAmount.setText(balance + "");
       
    }

    public void setTex() {
        lblChooseFacilityPriceAmount.setText("0.00");
        lblChooseRoomPriceAmount.setText("0.00");
        lblChooseServicePriceAmount.setText("0.00");
        lblChooseFullAmount.setText("0.00");
    }
    
    public void loadAmountPayment(){
        
         ReceptionPayment.txtAmount.setText(lblChooseFullAmount.getText());
         ReceptionPayment.txtREGID.setText(txtREGID.getText());
         ReceptionPayment.txtAmount.setText(lblChooseFullAmount.getText());
    }
    
    private void addRegistration() {

//        Date date = dteChehkIn.getDate();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String format = sdf.format(date);

//        Date date1 = dteChekOut.getDate();
        Date date1 = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        String format1 = sdf1.format(date1);

        String rid = txtREGID.getText();
        String cid = txtCid.getText();
        String chekin = format;
        String chekout = format1;
        int romAmount = Integer.parseInt(lblNoOfRoom.getText());
        String adult = cmbAmountAdult.getSelectedItem().toString();
        String child = cmbAmountChild.getSelectedItem().toString();
        String meal = cmbMealType.getSelectedItem().toString();

        RegistrationDTO registration = new RegistrationDTO(rid, cid, chekin, chekout, romAmount, adult, child, meal);
        try {
            boolean add = ctrlRegistration.add(registration);
            if (add) {
                JOptionPane.showMessageDialog(this, "Registation Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Registation Added Failed");
            }
        } catch (Exception e) {
        }
    }

    private void paymentDetail() {
        new ViewPaymentDetail().setVisible(true);
    }


}
