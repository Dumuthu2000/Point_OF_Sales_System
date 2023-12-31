package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import model.*;
import controller.*;
import javax.swing.table.DefaultTableModel;

public class VProducts extends javax.swing.JFrame {
    public VProducts() {
        initComponents();
        getProducts();
    }
    
    // Method to retrieve categoryId based on the selected category name
    private int getCategoryId(Object categoryName){
        int categoryID = 0;
        String query = "SELECT categoryID FROM category WHERE categoryName = ?";
        
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setObject(1, categoryName);
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                categoryID = result.getInt("categoryID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        
        return categoryID;
    }
    
    private String getCategoryName(int categoryID){
        String categoryName = "";
        String query = "SELECT categoryName FROM category WHERE categoryID = ?";
        
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setInt(1, categoryID);
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                categoryName = result.getString("categoryName");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        
        return categoryName;
    }
    
    // Method to retrieve supplierID based on the selected category name
    private int getSupplierId(Object supplierName){
        int supplierID = 0;
        String query = "SELECT supplierID FROM supplier WHERE supplierName = ?";
        
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setObject(1, supplierName);
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                supplierID = result.getInt("supplierID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        
        return supplierID;
    }
        private String getSupplierName(int supplierID){
        String supplierName = "";
        String query = "SELECT supplierName FROM supplier WHERE supplierID = ?";
        
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setInt(1, supplierID);
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                supplierName = result.getString("supplierName");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        
        return supplierName;
    }
    //Method retrieve all products to the table
    private void getProducts(){
        CProduct products = new CProduct();
        try {
            String[] columnNames = {"Item Code", "Item Name", "Category", "Purchase Price", "Selling Price", "Stock Qty", "Purchase Date"};

        // Create a DefaultTableModel with specified column names
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            itemTable.setModel(tableModel);
            
            ResultSet result = products.getProductItemConnection();
            while(result.next()){
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                String categoryName = result.getString("categoryName");
                float purchasePrice = result.getFloat("purchasePrice");
                float sellingPrice = result.getFloat("sellPrice"); 
                int stockQty = result.getInt("stockQty");
                String purchasedDate = result.getString("purchasedDate");
                
                tableModel.addRow(new Object[]{productCode, productName, categoryName, purchasePrice, sellingPrice, stockQty, purchasedDate});
            }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        supplierTxt = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemCodeTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        itemNameTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        purchasePriceTxt = new javax.swing.JTextField();
        sellingPriceTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        itemCategoryCombo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        itemQrtTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        purchaseDateTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        supplierCombo = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addItemBtn = new javax.swing.JButton();
        removeItemBtn = new javax.swing.JButton();
        updateItemBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        searchLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(64, 78, 104));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROYAL MARKET PLAZA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Point of Sales Managing System");

        closeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-close-26 (2).png"))); // NOI18N
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222)
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

        itemTable.setBackground(new java.awt.Color(64, 78, 104));
        itemTable.setForeground(new java.awt.Color(255, 255, 255));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item Code", "Item Name", "Category", "Purchase Price", "Selling Price", "Stock Qty", "Purchased Date"
            }
        ));
        jScrollPane1.setViewportView(itemTable);

        supplierTxt.setBackground(new java.awt.Color(64, 78, 104));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Code:");

        itemCodeTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item Name:");

        itemNameTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Item Category:");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Purchase Price:");

        purchasePriceTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        sellingPriceTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Selling Price:");

        itemCategoryCombo.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        itemCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fresh Produce", "Dairy and Eggs", "Meat and Seafood", "Bakery", "Beverages", "Snacks and Biscuits", "Household and Cleaning", "Health and Beauty", " " }));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Stock Quantity:");

        itemQrtTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Purchased Date:");

        purchaseDateTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Supplier:");

        supplierCombo.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        supplierCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier", "Ceylon Biscuit Limited (CBL) (pvt) Ltd", "Malliban Biscuit  (pvt) Ltd", "Fontera Srilanka", "Risbarry Chocalte (pvt) Ltd", "Unillivar Srilanka", "Ceylon tea (pvt) Ltd", "Nestlay Srilanka", "Perera & Sons" }));

        javax.swing.GroupLayout supplierTxtLayout = new javax.swing.GroupLayout(supplierTxt);
        supplierTxt.setLayout(supplierTxtLayout);
        supplierTxtLayout.setHorizontalGroup(
            supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierTxtLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, supplierTxtLayout.createSequentialGroup()
                        .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(48, 48, 48)
                        .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemQrtTxt)
                            .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(itemNameTxt)
                                .addComponent(itemCodeTxt)
                                .addComponent(purchasePriceTxt)
                                .addComponent(sellingPriceTxt)
                                .addComponent(itemCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, supplierTxtLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(43, 43, 43)
                        .addComponent(purchaseDateTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, supplierTxtLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(supplierTxtLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(99, 99, 99)
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        supplierTxtLayout.setVerticalGroup(
            supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierTxtLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(purchasePriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(sellingPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(itemQrtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(purchaseDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supplierTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
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

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Products Details");

        addItemBtn.setBackground(new java.awt.Color(0, 102, 255));
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-add-35.png"))); // NOI18N
        addItemBtn.setText("Add");
        addItemBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });

        removeItemBtn.setBackground(new java.awt.Color(230, 57, 70));
        removeItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-remove-35.png"))); // NOI18N
        removeItemBtn.setText("Remove");
        removeItemBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        removeItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemBtnActionPerformed(evt);
            }
        });

        updateItemBtn.setBackground(new java.awt.Color(26, 147, 111));
        updateItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-update-35.png"))); // NOI18N
        updateItemBtn.setText("Update");
        updateItemBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updateItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(64, 78, 104));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Search:");

        searchTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        searchLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-search-35.png"))); // NOI18N
        searchLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(updateItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(removeItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(supplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateItemBtn)
                            .addComponent(removeItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 702));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        // TODO add your handling code here:
            // Gets user inputs and assigns them to variables
            String productCode = itemCodeTxt.getText().trim();
            String productName = itemNameTxt.getText().trim(); 
            float purchasedPrice = Float.parseFloat(purchasePriceTxt.getText().trim());
            float sellPrice = Float.parseFloat(sellingPriceTxt.getText().trim());
            int stockQty = Integer.parseInt(itemQrtTxt.getText().trim());
            String purchasedDate = purchaseDateTxt.getText().trim();
            int categoryID = getCategoryId(itemCategoryCombo.getSelectedItem());
            int supplierID = getSupplierId(supplierCombo.getSelectedItem());
            CProduct  product = new CProduct();
        try {
            
             if (productCode.isEmpty() || productName.isEmpty() || stockQty <= 0 || purchasedDate.isEmpty() || categoryID <= 0 || supplierID <= 0 || purchasedPrice < 0.0f || sellPrice < 0.00f) {
                    JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                }
             else{
                 
                product.addProductItemConnection(productCode, productName, purchasedPrice, sellPrice, stockQty, purchasedDate, categoryID, supplierID);
                getProducts(); 
             }
                itemCodeTxt.setText("");
                itemNameTxt.setText("");
                purchasePriceTxt.setText("");
                sellingPriceTxt.setText("");
                itemQrtTxt.setText("");
                purchaseDateTxt.setText("");
                itemCategoryCombo.setSelectedIndex(0);
                supplierCombo.setSelectedIndex(0);
 
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "All fields are requied", "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
        VDashboard dashboard = new VDashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeLblMouseClicked

    private void updateItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemBtnActionPerformed
        // TODO add your handling code here:
            String productCode = itemCodeTxt.getText().trim();
            String productName = itemNameTxt.getText().trim(); 
            float purchasedPrice = Float.parseFloat(purchasePriceTxt.getText().trim());
            float sellPrice = Float.parseFloat(sellingPriceTxt.getText().trim());
            int stockQty = Integer.parseInt(itemQrtTxt.getText().trim());
            String purchasedDate = purchaseDateTxt.getText().trim();
            int categoryID = getCategoryId(itemCategoryCombo.getSelectedItem());
            int supplierID = getSupplierId(supplierCombo.getSelectedItem());
            String searchItem = searchTxt.getText().trim();
        try {
             if (productCode.isEmpty() || productName.isEmpty() || stockQty <= 0 || purchasedDate.isEmpty() || categoryID <= 0 || supplierID <= 0) {
                    JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                }
             else{
                CProduct  product = new CProduct();
                product.updateProductConnection(productCode, productName, purchasedPrice, sellPrice, stockQty, purchasedDate, categoryID, supplierID, searchItem);
                
                getProducts();
                itemCodeTxt.setText("");
               itemNameTxt.setText("");
               purchasePriceTxt.setText("");
               sellingPriceTxt.setText("");
               itemQrtTxt.setText("");
               purchaseDateTxt.setText("");
               itemCategoryCombo.setSelectedIndex(0);
               supplierCombo.setSelectedIndex(0);
               searchTxt.setText("");
             }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateItemBtnActionPerformed

    private void searchLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLblMouseClicked
        // TODO add your handling code here:
        CProduct products = new CProduct();
        String searchItem = searchTxt.getText().trim();
        try {
            ResultSet result = products.searchProductItemsConnection(searchItem);
            if(result.next()){
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                float purchasePrice = result.getFloat("purchasePrice");
                float sellingPrice = result.getFloat("sellPrice"); 
                int stockQty = result.getInt("stockQty");
                String purchasedDate = result.getString("purchasedDate");
                int categoryID = result.getInt("categoryID");
                int supplierID = result.getInt("supplierID");
                
                
                itemCodeTxt.setText(productCode);
                itemNameTxt.setText(productName);
                purchasePriceTxt.setText(String.valueOf(purchasePrice));
                sellingPriceTxt.setText(String.valueOf(sellingPrice));
                itemQrtTxt.setText(String.valueOf(stockQty));
                purchaseDateTxt.setText(purchasedDate);
                itemCategoryCombo.setSelectedItem(getCategoryName(categoryID));
                supplierCombo.setSelectedItem(getSupplierName(supplierID));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchLblMouseClicked

    private void removeItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemBtnActionPerformed
        // TODO add your handling code here:
        CProduct products = new CProduct();
        try {
            String searchItem = searchTxt.getText();
            products.deleteProductConnection(searchItem);
            getProducts();
            searchTxt.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeItemBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JComboBox<String> itemCategoryCombo;
    private javax.swing.JTextField itemCodeTxt;
    private javax.swing.JTextField itemNameTxt;
    private javax.swing.JTextField itemQrtTxt;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField purchaseDateTxt;
    private javax.swing.JTextField purchasePriceTxt;
    private javax.swing.JButton removeItemBtn;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField sellingPriceTxt;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JPanel supplierTxt;
    private javax.swing.JButton updateItemBtn;
    // End of variables declaration//GEN-END:variables
}
