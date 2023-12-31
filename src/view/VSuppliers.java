package view;
import controller.CSupplier;
import controller.CSupplierMobile;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class VSuppliers extends javax.swing.JFrame {

    public VSuppliers() {
        initComponents();
        //Display all suppliers when page displaying
        getSuppliers();
    }
    private void getSuppliers(){
        try {
            String[] columnNames = {"Supplier ID", "Supplier Name", "Supplier Address", "Mobile 1", "Mobile 2"};

        // Create a DefaultTableModel with specified column names
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            supplierTable.setModel(tableModel);
            
            CSupplier supplier = new CSupplier();
            ResultSet result = supplier.getSuppliersConnection();
            while(result.next()){
                String supplierID = result.getString("supplierID");
                String supplierName = result.getString("supplierName");
                String supplierAddress = result.getString("supplierAddress");
                String mobile_1 = result.getString("mobile_1");
                String mobile_2 = result.getString("mobile_2");
                
                //Add data to the table
                tableModel.addRow(new Object[]{supplierID, supplierName, supplierAddress, mobile_1, mobile_2});
            }
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        addSupplierBtn = new javax.swing.JButton();
        removeSupplierBtn = new javax.swing.JButton();
        updateSuppierBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchSupplier = new javax.swing.JTextField();
        searchLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        supplierNameTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        supplierAddressTxt = new javax.swing.JTextField();
        supplierMobile1Txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        supplierMobile2Txt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        supplierTable.setBackground(new java.awt.Color(64, 78, 104));
        supplierTable.setForeground(new java.awt.Color(255, 255, 255));
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Supplier Address", "Mobile 1", "Mobile 2"
            }
        ));
        supplierTable.setGridColor(new java.awt.Color(255, 255, 255));
        supplierTable.setShowHorizontalLines(true);
        supplierTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(supplierTable);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Suppliers Details");

        addSupplierBtn.setBackground(new java.awt.Color(0, 102, 255));
        addSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addSupplierBtn.setForeground(new java.awt.Color(255, 255, 255));
        addSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-add-35.png"))); // NOI18N
        addSupplierBtn.setText("Add");
        addSupplierBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierBtnActionPerformed(evt);
            }
        });

        removeSupplierBtn.setBackground(new java.awt.Color(230, 57, 70));
        removeSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeSupplierBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeSupplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-remove-35.png"))); // NOI18N
        removeSupplierBtn.setText("Remove");
        removeSupplierBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        removeSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSupplierBtnActionPerformed(evt);
            }
        });

        updateSuppierBtn.setBackground(new java.awt.Color(26, 147, 111));
        updateSuppierBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateSuppierBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateSuppierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-update-35.png"))); // NOI18N
        updateSuppierBtn.setText("Update");
        updateSuppierBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updateSuppierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSuppierBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(64, 78, 104));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Search:");

        searchSupplier.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

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
                .addComponent(searchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(searchSupplier, javax.swing.GroupLayout.Alignment.LEADING))
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

        jPanel5.setBackground(new java.awt.Color(64, 78, 104));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Supplier Name:");

        supplierNameTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Supplier Address:");

        supplierAddressTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        supplierMobile1Txt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Supplier Mobile 1:");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Supplier Mobile 2:");

        supplierMobile2Txt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supplierMobile2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(supplierAddressTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(supplierNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(supplierMobile1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(43, 43, 43))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(supplierNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(supplierAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(supplierMobile1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(supplierMobile2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
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
                .addContainerGap(308, Short.MAX_VALUE)
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
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(addSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(updateSuppierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(removeSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateSuppierBtn)
                            .addComponent(removeSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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

        setSize(new java.awt.Dimension(1200, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
        VDashboard dashboard = new VDashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeLblMouseClicked

    private void addSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierBtnActionPerformed
        // TODO add your handling code here:
        String supplierMobile2 = null;
        String supplierName = supplierNameTxt.getText().trim();
        String supplierAddress = supplierAddressTxt.getText().trim();
        String supplierMobile1 = supplierMobile1Txt.getText().trim();
        supplierMobile2 = supplierMobile2Txt.getText().trim();

        try {
            if(supplierName.isEmpty() || supplierAddress.isEmpty() || supplierMobile1.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if(supplierMobile1.length() != 10){
                    JOptionPane.showMessageDialog(null, "Please enter valid mobile number", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                 //Import supplier class from CSupplier package
                CSupplier supplier = new CSupplier();
                supplier.addSupplierConnection(supplierName, supplierAddress);

                //Import supplier class from CSupplier package
                CSupplierMobile supplierMobile = new CSupplierMobile();
                supplierMobile.addSupplierMobileConnection(supplierMobile1, supplierMobile2);
                
                //Remove all input text in fields
                supplierNameTxt.setText("");
                supplierAddressTxt.setText("");
                supplierMobile1Txt.setText("");
                supplierMobile2Txt.setText("");
                
                //Display new supplier in the table
                getSuppliers();
                }
                 
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addSupplierBtnActionPerformed

    private void removeSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSupplierBtnActionPerformed
        // TODO add your handling code here:
         int selectedRow = supplierTable.getSelectedRow();
    
        if (selectedRow != -1){
            String supplierIDString = (String) supplierTable.getValueAt(selectedRow, 0);
            int supplierID = Integer.parseInt(supplierIDString);

            try {
                // Call the method to delete the supplier
                CSupplier supplier = new CSupplier();
                supplier.deleteSupplierConnection(supplierID);

                // Call the method to delete the supplier_mobile
                CSupplierMobile supplierMobile = new CSupplierMobile();
                supplierMobile.deleteSupplierMobileConnection(supplierID);

                // Remove the selected row from the table
                DefaultTableModel model = (DefaultTableModel) supplierTable.getModel();
                model.removeRow(selectedRow);

                // Optional: Display table after deleting
                getSuppliers(); // Ensure this method is implemented correctly

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeSupplierBtnActionPerformed

    private void updateSuppierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSuppierBtnActionPerformed
        // TODO add your handling code here:
        String supplierMobile2 = null;
        String supplierName = supplierNameTxt.getText().trim();
        String supplierAddress = supplierAddressTxt.getText().trim();
        String supplierMobile1 = supplierMobile1Txt.getText().trim();
        int supplierID = Integer.parseInt(searchSupplier.getText().trim());
        supplierMobile2 = supplierMobile2Txt.getText().trim();

        try {
            if(supplierName.isEmpty() || supplierAddress.isEmpty() || supplierMobile1.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if(supplierMobile1.length() != 10){
                    JOptionPane.showMessageDialog(null, "Please enter valid mobile number", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                 //Import supplier class from CSupplier package
                CSupplier supplier = new CSupplier();
                supplier.updateSupplierConnection(supplierName, supplierAddress, supplierID);

                //Import supplier class from CSupplier package
                CSupplierMobile supplierMobile = new CSupplierMobile();
                supplierMobile.updateSupplierMobile(supplierMobile1, supplierMobile2, supplierID);
                
                //Remove all input text in fields
                supplierNameTxt.setText("");
                supplierAddressTxt.setText("");
                supplierMobile1Txt.setText("");
                supplierMobile2Txt.setText("");
                searchSupplier.setText("");
                
                //Display new supplier in the table
                getSuppliers();
                }
                 
            }
        } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
    }//GEN-LAST:event_updateSuppierBtnActionPerformed

    private void searchLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLblMouseClicked
        // TODO add your handling code here:
        CSupplier supplier = new CSupplier();
        String searchText = searchSupplier.getText().trim();

    // Check if the text is not empty
    if (!searchText.isEmpty()) {
        try {
            int supplierID = Integer.parseInt(searchText);

            ResultSet result = supplier.getOneSupplierConnection(supplierID);
            
            if(result.next()){
                String supplierName = result.getString("supplierName");
                String supplierAddress = result.getString("supplierAddress");
                String mobile_1 = result.getString("mobile_1");
                String mobile_2 = result.getString("mobile_2");
                
                supplierNameTxt.setText(supplierName);
                supplierAddressTxt.setText(supplierAddress);
                supplierMobile1Txt.setText(mobile_1);
                supplierMobile2Txt.setText(mobile_2);
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid supplier ID: " + searchText, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Handle the case where the input is empty
        JOptionPane.showMessageDialog(null, "Please enter a valid supplier ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_searchLblMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VSuppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSupplierBtn;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeSupplierBtn;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JTextField searchSupplier;
    private javax.swing.JTextField supplierAddressTxt;
    private javax.swing.JTextField supplierMobile1Txt;
    private javax.swing.JTextField supplierMobile2Txt;
    private javax.swing.JTextField supplierNameTxt;
    private javax.swing.JTable supplierTable;
    private javax.swing.JButton updateSuppierBtn;
    // End of variables declaration//GEN-END:variables
}
