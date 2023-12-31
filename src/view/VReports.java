package view;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import model.MDbConnection;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VReports extends javax.swing.JFrame {
    private String formattedDate;
    private String formattedTime;
    public VReports() {
        initComponents();
        setCurrentDate();
        setCurrentTime();
    }
    
     private void setCurrentDate(){
        
        LocalDate currentDate = LocalDate.now();

        // Define a formatter for the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date as a string
       formattedDate = currentDate.format(formatter);
        dateLbl.setText(formattedDate);
    }
    
    //get current time
    private void setCurrentTime(){
        LocalTime currentTime = LocalTime.now();

        // Define a formatter for the desired time format with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");

        // Format the current time as a string
        formattedTime = currentTime.format(formatter);
        timeLbl.setText(formattedTime);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salesFullReportBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        fromDateTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        toDateTxt = new javax.swing.JTextField();
        salesMonthlyReportBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        adminNameLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        adminProfileLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        productsFullReportBtn = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        fromDateTxt2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        toDateTxt2 = new javax.swing.JTextField();
        productsMonthlyReportBtn = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(64, 78, 104));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROYAL MARKET PLAZA");

        closeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-close-26 (2).png"))); // NOI18N
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Point of Sales Managing System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228)
                .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(37, 50, 55));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-copyright-20.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("2023 All Rights Reserverd. DsignLk Software Solutions (pvt) Ltd.");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(363, 363, 363))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(64, 78, 104));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Sales Reports");

        salesFullReportBtn.setBackground(new java.awt.Color(0, 153, 0));
        salesFullReportBtn.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        salesFullReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        salesFullReportBtn.setText("Generate Report");
        salesFullReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesFullReportBtnActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Full Report");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 204));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Monthly Reports");

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("From:");

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("To:");

        salesMonthlyReportBtn.setBackground(new java.awt.Color(0, 153, 0));
        salesMonthlyReportBtn.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        salesMonthlyReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        salesMonthlyReportBtn.setText("Generate Report");
        salesMonthlyReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesMonthlyReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesFullReportBtn)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(salesMonthlyReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesFullReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fromDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(toDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(salesMonthlyReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("REPORTS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("Date:");

        dateLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 255));
        dateLbl.setText("2023-12-24");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("Time:");

        timeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(0, 0, 255));
        timeLbl.setText("10.39.12 AM");

        adminNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        adminNameLbl.setForeground(new java.awt.Color(0, 0, 204));
        adminNameLbl.setText("D.M Jayasinghe");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Administrator");

        adminProfileLbl.setBackground(new java.awt.Color(255, 255, 255));
        adminProfileLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-person-40.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(64, 78, 104));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 255, 255));
        jLabel12.setText("Products Reports");

        productsFullReportBtn.setBackground(new java.awt.Color(0, 153, 0));
        productsFullReportBtn.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        productsFullReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        productsFullReportBtn.setText("Generate Report");
        productsFullReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsFullReportBtnActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(0, 0, 204));

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Full Report");

        jSeparator8.setForeground(new java.awt.Color(0, 0, 204));

        jLabel26.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Monthly Reports");

        jLabel27.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("From:");

        jLabel28.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("To:");

        productsMonthlyReportBtn.setBackground(new java.awt.Color(0, 153, 0));
        productsMonthlyReportBtn.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        productsMonthlyReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        productsMonthlyReportBtn.setText("Generate Report");
        productsMonthlyReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsMonthlyReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productsFullReportBtn)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(productsMonthlyReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productsFullReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(fromDateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(toDateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(productsMonthlyReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLbl)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(timeLbl)
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminNameLbl)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminProfileLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(adminProfileLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(adminNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1206, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salesFullReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesFullReportBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JasperDesign japerDesign = JRXmlLoader.load("E:\\NIBM\\EAD\\Point_Of_Sales_System\\src\\view\\sales_full_report.jrxml");
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText("SELECT orderItemCode, orderItemName, SUM(totalPrice) AS totalAmount FROM orderItem GROUP BY orderItemCode, orderItemName;");
            japerDesign.setQuery(designQuery);
            JasperReport report = JasperCompileManager.compileReport(japerDesign);
            JasperPrint print = JasperFillManager.fillReport(report, null, MDbConnection.createConnection());
            JasperViewer.viewReport(print);
           } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_salesFullReportBtnActionPerformed

    private void salesMonthlyReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesMonthlyReportBtnActionPerformed
        // TODO add your handling code here:
        String fromDate = fromDateTxt.getText();
        String toDate = toDateTxt.getText();
         try {
            // TODO add your handling code here:
            JasperDesign japerDesign = JRXmlLoader.load("E:\\NIBM\\EAD\\Point_Of_Sales_System\\src\\view\\selected_sales_report.jrxml");
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText("SELECT i.orderItemCode, i.orderItemName, i.orderItemPrice, i.orderItemQty, i.totalPrice,  o.orderDate FROM orderItem AS i INNER JOIN `order` AS o ON i.orderID = o.orderID WHERE o.orderDate BETWEEN '"+fromDate+"' AND '"+toDate+"' ORDER BY o.orderDate");
            japerDesign.setQuery(designQuery);
            JasperReport report = JasperCompileManager.compileReport(japerDesign);
            JasperPrint print = JasperFillManager.fillReport(report, null, MDbConnection.createConnection());
            JasperViewer.viewReport(print);
           } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_salesMonthlyReportBtnActionPerformed

    private void productsFullReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsFullReportBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JasperDesign japerDesign = JRXmlLoader.load("E:\\NIBM\\EAD\\Point_Of_Sales_System\\src\\view\\all_products_report.jrxml");
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText("SELECT productCode, productName, purchasePrice, stockQty, purchasedDate FROM product");
            japerDesign.setQuery(designQuery);
            JasperReport report = JasperCompileManager.compileReport(japerDesign);
            JasperPrint print = JasperFillManager.fillReport(report, null, MDbConnection.createConnection());
            JasperViewer.viewReport(print);
           } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_productsFullReportBtnActionPerformed

    private void productsMonthlyReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsMonthlyReportBtnActionPerformed
        // TODO add your handling code here:
        String fromDate = fromDateTxt.getText();
        String toDate = toDateTxt.getText();
        try {
            // TODO add your handling code here:
            JasperDesign japerDesign = JRXmlLoader.load("E:\\NIBM\\EAD\\Point_Of_Sales_System\\src\\view\\selected_product_report.jrxml");
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText("SELECT productCode, productName, purchasePrice, stockQty, purchasedDate FROM product WHERE purchasedDate  BETWEEN  '"+fromDate+"' AND '"+toDate+"'");
            japerDesign.setQuery(designQuery);
            JasperReport report = JasperCompileManager.compileReport(japerDesign);
            JasperPrint print = JasperFillManager.fillReport(report, null, MDbConnection.createConnection());
            JasperViewer.viewReport(print);
           } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_productsMonthlyReportBtnActionPerformed

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
        VDashboard dashboard = new VDashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeLblMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminNameLbl;
    private javax.swing.JLabel adminProfileLbl;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField fromDateTxt;
    private javax.swing.JTextField fromDateTxt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton productsFullReportBtn;
    private javax.swing.JButton productsMonthlyReportBtn;
    private javax.swing.JButton salesFullReportBtn;
    private javax.swing.JButton salesMonthlyReportBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JTextField toDateTxt;
    private javax.swing.JTextField toDateTxt2;
    // End of variables declaration//GEN-END:variables
}
