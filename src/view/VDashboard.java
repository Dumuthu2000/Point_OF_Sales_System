package view;
import controller.CDashboard;
import model.MDashboard.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class VDashboard extends javax.swing.JFrame {
    private String formattedDate;
    private String formattedTime;
    
    public VDashboard() {
        initComponents();
        setCurrentDate();
        setCurrentDate();
        // Create and start a timer to update the time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTime();
            }
        });
        timer.start();
        setCurrentTime();
        
        getInvoiceCount();
        getSalesIncome();
        getTodaySalesIncome();
        getProductsCount();
        getStockOutProductsCount();
        getSupplierCount();
    }
    //get current Date
    private void setCurrentDate(){
        
        LocalDate currentDate = LocalDate.now();

        // Define a formatter for the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date as a string
       formattedDate = currentDate.format(formatter);
        dateLbl.setText(formattedDate);
    }
    
    //get current time
    private void setCurrentTime() {
        LocalTime currentTime = LocalTime.now();

        // Define a formatter for the desired time format with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");

        // Format the current time as a string
        String formattedTime = currentTime.format(formatter);
        timeLbl.setText(formattedTime);
    }
    
    private void getInvoiceCount(){
        CDashboard dashboard = new CDashboard();
        try {
            ResultSet result = (ResultSet) dashboard.getInvoicesCountConnection(formattedDate);
            while(result.next()){
                int invoicesCount = result.getInt("ordersCount");
                
                invoiceCount.setText(String.valueOf(invoicesCount));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
    
    private void getSalesIncome(){
        CDashboard dashboard = new CDashboard();
        try {
            ResultSet result = (ResultSet) dashboard.getSalesIncomeConnection();
            while(result.next()){
                float salesAmount = result.getFloat("salesAmount");
                DecimalFormat currencyFormat = new DecimalFormat("#, ##0.00");
                String formattedSalesAmount = currencyFormat.format(salesAmount);
                
                salesIncomeLbl.setText(formattedSalesAmount);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
    
    private void getTodaySalesIncome(){
        CDashboard dashboard = new CDashboard();
            try {
                ResultSet result = (ResultSet) dashboard.getTodaySalesIncomeConnection(formattedDate);
                while(result.next()){
                    float todaySalesAmount = result.getFloat("salesAmount");
                    DecimalFormat currencyFormat = new DecimalFormat("#, ##0.00");
                    String formattedSalesAmount = currencyFormat.format(todaySalesAmount);

                    todaySalesIncomeLbl.setText(formattedSalesAmount);
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 System.out.println(e.getMessage());
        }
    }
    
    private void getProductsCount(){
        CDashboard dashboard = new CDashboard();
            try {
                ResultSet result = (ResultSet) dashboard.getProductsCountConnection();
                while(result.next()){
                     int productsCount = result.getInt("productsCount");
                    stockInProducts.setText(String.valueOf(productsCount));
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 System.out.println(e.getMessage());
        }
    }
    
    private void getStockOutProductsCount(){
        CDashboard dashboard = new CDashboard();
        try {
                ResultSet result = (ResultSet) dashboard.getStockOutProductsCountConnection();
                while(result.next()){
                     int stockOutProducts = result.getInt("productsCount");
                    stockOutProductsLbl.setText(String.valueOf(stockOutProducts));
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 System.out.println(e.getMessage());
        }   
    }
    
    private void getSupplierCount(){
         CDashboard dashboard = new CDashboard();
        try {
                ResultSet result = (ResultSet) dashboard.getSupplierCountConnection();
                while(result.next()){
                     int supplierCount = result.getInt("supplierCount");
                    supplierCountLbl.setText(String.valueOf(supplierCount));
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "View Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salesBtn = new javax.swing.JButton();
        productsBtn = new javax.swing.JButton();
        categoriesBtn = new javax.swing.JButton();
        suppliersBtn = new javax.swing.JButton();
        reportsBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        stockInProducts = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        stockOutProductsLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        invoiceCount = new javax.swing.JLabel();
        adminNameLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        salesIncomeLbl = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        todaySalesIncomeLbl = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        supplierCountLbl = new javax.swing.JLabel();
        manageProductsBtn = new javax.swing.JButton();
        manageReportBtn = new javax.swing.JButton();
        manageSupplierBtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adminProfileLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(64, 78, 104));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PLAZA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ROYAL MARKET");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Taste The Royal Treatment");

        salesBtn.setBackground(new java.awt.Color(37, 50, 55));
        salesBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        salesBtn.setForeground(new java.awt.Color(255, 255, 255));
        salesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-sales-40 (1).png"))); // NOI18N
        salesBtn.setText("Sales");
        salesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        salesBtn.setFocusPainted(false);
        salesBtn.setFocusable(false);
        salesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salesBtn.setIconTextGap(10);
        salesBtn.setRequestFocusEnabled(false);
        salesBtn.setRolloverEnabled(false);
        salesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBtnActionPerformed(evt);
            }
        });

        productsBtn.setBackground(new java.awt.Color(37, 50, 55));
        productsBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        productsBtn.setForeground(new java.awt.Color(255, 255, 255));
        productsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-cart-40.png"))); // NOI18N
        productsBtn.setText("Products");
        productsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productsBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        productsBtn.setFocusPainted(false);
        productsBtn.setFocusable(false);
        productsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productsBtn.setIconTextGap(10);
        productsBtn.setRequestFocusEnabled(false);
        productsBtn.setRolloverEnabled(false);
        productsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtnActionPerformed(evt);
            }
        });

        categoriesBtn.setBackground(new java.awt.Color(37, 50, 55));
        categoriesBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        categoriesBtn.setForeground(new java.awt.Color(255, 255, 255));
        categoriesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-categories-40.png"))); // NOI18N
        categoriesBtn.setText("Categories");
        categoriesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoriesBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        categoriesBtn.setFocusPainted(false);
        categoriesBtn.setFocusable(false);
        categoriesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoriesBtn.setIconTextGap(10);
        categoriesBtn.setRequestFocusEnabled(false);
        categoriesBtn.setRolloverEnabled(false);
        categoriesBtn.setVerifyInputWhenFocusTarget(false);

        suppliersBtn.setBackground(new java.awt.Color(37, 50, 55));
        suppliersBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        suppliersBtn.setForeground(new java.awt.Color(255, 255, 255));
        suppliersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-lorry-40.png"))); // NOI18N
        suppliersBtn.setText("Suppliers");
        suppliersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppliersBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        suppliersBtn.setDefaultCapable(false);
        suppliersBtn.setFocusPainted(false);
        suppliersBtn.setFocusable(false);
        suppliersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        suppliersBtn.setIconTextGap(10);
        suppliersBtn.setRequestFocusEnabled(false);
        suppliersBtn.setRolloverEnabled(false);
        suppliersBtn.setVerifyInputWhenFocusTarget(false);
        suppliersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersBtnActionPerformed(evt);
            }
        });

        reportsBtn.setBackground(new java.awt.Color(37, 50, 55));
        reportsBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        reportsBtn.setForeground(new java.awt.Color(255, 255, 255));
        reportsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-reports-40.png"))); // NOI18N
        reportsBtn.setText("Reports");
        reportsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        reportsBtn.setFocusPainted(false);
        reportsBtn.setFocusable(false);
        reportsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportsBtn.setIconTextGap(10);
        reportsBtn.setOpaque(true);
        reportsBtn.setRequestFocusEnabled(false);
        reportsBtn.setRolloverEnabled(false);
        reportsBtn.setVerifyInputWhenFocusTarget(false);
        reportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(37, 50, 55));
        logoutBtn.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-logout-40.png"))); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFocusable(false);
        logoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutBtn.setIconTextGap(10);
        logoutBtn.setRequestFocusEnabled(false);
        logoutBtn.setRolloverEnabled(false);
        logoutBtn.setVerifyInputWhenFocusTarget(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(salesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(categoriesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(suppliersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(salesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(categoriesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(suppliersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(643, Short.MAX_VALUE)))
        );

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("DASHBOARD");

        jPanel3.setBackground(new java.awt.Color(251, 254, 251));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(173, 232, 244), 6, true));
        jPanel3.setInheritsPopupMenu(true);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("Stock In Products");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-products.gif"))); // NOI18N

        stockInProducts.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        stockInProducts.setForeground(new java.awt.Color(0, 255, 255));
        stockInProducts.setText("123");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(stockInProducts))
                    .addComponent(jLabel11))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(stockInProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(251, 254, 251));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 198, 255), 6, true));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Stock Out Products");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-product.gif"))); // NOI18N

        stockOutProductsLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        stockOutProductsLbl.setForeground(new java.awt.Color(255, 0, 0));
        stockOutProductsLbl.setText("123");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(stockOutProductsLbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addGap(8, 8, 8)))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(stockOutProductsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(251, 254, 251));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(183, 228, 199), 6, true));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setText("Today Invoices");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-invoice.gif"))); // NOI18N

        invoiceCount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        invoiceCount.setForeground(new java.awt.Color(0, 102, 0));
        invoiceCount.setText("237");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel17)
                .addGap(32, 32, 32)
                .addComponent(invoiceCount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(47, 47, 47))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        adminNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        adminNameLbl.setForeground(new java.awt.Color(0, 0, 204));
        adminNameLbl.setText("Mr.Dumuthu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("Time:");

        timeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(0, 0, 255));
        timeLbl.setText("10.39.12 AM");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Administrator");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("Date:");

        dateLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 255));
        dateLbl.setText("2023-12-24");

        closeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-close-26.png"))); // NOI18N
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(251, 254, 251));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(157, 180, 192), 6, true));
        jPanel6.setPreferredSize(new java.awt.Dimension(248, 149));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setText("Sales Income");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-sales (1).gif"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(157, 180, 192));
        jLabel21.setText("Rs.");

        salesIncomeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        salesIncomeLbl.setForeground(new java.awt.Color(157, 180, 192));
        salesIncomeLbl.setText("127,290.50");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesIncomeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salesIncomeLbl)))
                .addGap(59, 59, 59))
        );

        jPanel7.setBackground(new java.awt.Color(251, 254, 251));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(171, 196, 255), 6, true));
        jPanel7.setPreferredSize(new java.awt.Dimension(248, 149));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-us-dollar-circled.gif"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel29.setText("Today Sales Income");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(157, 180, 192));
        jLabel22.setText("Rs.");

        todaySalesIncomeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        todaySalesIncomeLbl.setForeground(new java.awt.Color(157, 180, 192));
        todaySalesIncomeLbl.setText("127,290.50");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(todaySalesIncomeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(todaySalesIncomeLbl)))
                .addGap(38, 38, 38))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 194, 202), 6, true));
        jPanel8.setPreferredSize(new java.awt.Dimension(248, 149));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel25.setText("Current Suppliers");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-tow-truck.gif"))); // NOI18N

        supplierCountLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        supplierCountLbl.setForeground(new java.awt.Color(255, 153, 255));
        supplierCountLbl.setText("25");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supplierCountLbl)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(38, 38, 38))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(supplierCountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        manageProductsBtn.setBackground(new java.awt.Color(37, 50, 55));
        manageProductsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageProductsBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageProductsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-cart-30.png"))); // NOI18N
        manageProductsBtn.setText("Manage Products");
        manageProductsBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 4, true));
        manageProductsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageProductsBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        manageProductsBtn.setDoubleBuffered(true);
        manageProductsBtn.setFocusable(false);
        manageProductsBtn.setOpaque(true);
        manageProductsBtn.setRequestFocusEnabled(false);
        manageProductsBtn.setRolloverEnabled(false);
        manageProductsBtn.setVerifyInputWhenFocusTarget(false);
        manageProductsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductsBtnActionPerformed(evt);
            }
        });

        manageReportBtn.setBackground(new java.awt.Color(37, 50, 55));
        manageReportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-reports-35.png"))); // NOI18N
        manageReportBtn.setText("Reports");
        manageReportBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 4, true));
        manageReportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageReportBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        manageReportBtn.setFocusPainted(false);
        manageReportBtn.setFocusable(false);
        manageReportBtn.setRequestFocusEnabled(false);
        manageReportBtn.setRolloverEnabled(false);
        manageReportBtn.setVerifyInputWhenFocusTarget(false);
        manageReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReportBtnActionPerformed(evt);
            }
        });

        manageSupplierBtn.setBackground(new java.awt.Color(37, 50, 55));
        manageSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageSupplierBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-lorry-35.png"))); // NOI18N
        manageSupplierBtn.setText("Manage Suppliers");
        manageSupplierBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 4, true));
        manageSupplierBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageSupplierBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        manageSupplierBtn.setFocusPainted(false);
        manageSupplierBtn.setFocusable(false);
        manageSupplierBtn.setRequestFocusEnabled(false);
        manageSupplierBtn.setRolloverEnabled(false);
        manageSupplierBtn.setVerifyInputWhenFocusTarget(false);
        manageSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSupplierBtnActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(37, 50, 55));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-copyright-20.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("2023 All Rights Reserverd. DsignLk Software Solutions (pvt) Ltd.");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(260, 260, 260))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        adminProfileLbl.setBackground(new java.awt.Color(255, 255, 255));
        adminProfileLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-person-40.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(manageProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(manageReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLbl)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminNameLbl)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adminProfileLbl)
                                .addGap(52, 52, 52))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(manageProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
        VLogin login = new VLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeLblMouseClicked

    private void salesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBtnActionPerformed
        // TODO add your handling code here:
        VLogin login = new VLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salesBtnActionPerformed

    private void productsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtnActionPerformed
        // TODO add your handling code here:
         VProducts products = new VProducts();
        products.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_productsBtnActionPerformed

    private void suppliersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersBtnActionPerformed
        // TODO add your handling code here:
        VSuppliers supplier = new VSuppliers();
        supplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_suppliersBtnActionPerformed

    private void reportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsBtnActionPerformed
        // TODO add your handling code here:
        VReports reports = new VReports();
        reports.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportsBtnActionPerformed

    private void manageProductsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductsBtnActionPerformed
        // TODO add your handling code here:
         VProducts products = new VProducts();
        products.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageProductsBtnActionPerformed

    private void manageSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSupplierBtnActionPerformed
        // TODO add your handling code here:
         VSuppliers supplier = new VSuppliers();
        supplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageSupplierBtnActionPerformed

    private void manageReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageReportBtnActionPerformed
        // TODO add your handling code here:
        VReports reports = new VReports();
        reports.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageReportBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        VLogin login = new VLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminNameLbl;
    private javax.swing.JLabel adminProfileLbl;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel invoiceCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageProductsBtn;
    private javax.swing.JButton manageReportBtn;
    private javax.swing.JButton manageSupplierBtn;
    private javax.swing.JButton productsBtn;
    private javax.swing.JButton reportsBtn;
    private javax.swing.JButton salesBtn;
    private javax.swing.JLabel salesIncomeLbl;
    private javax.swing.JLabel stockInProducts;
    private javax.swing.JLabel stockOutProductsLbl;
    private javax.swing.JLabel supplierCountLbl;
    private javax.swing.JButton suppliersBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel todaySalesIncomeLbl;
    // End of variables declaration//GEN-END:variables
}
