package view;
import controller.CSales;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MDbConnection;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VSales extends javax.swing.JFrame {
    private String formattedDate;
    private String formattedTime;

    public VSales() {
        initComponents();
        setCurrentDate();
        setCurrentTime();
        balanceAmountLbl.setVisible(false);
        balanceAmountTxt.setVisible(false);
        itemCodeTxt.setEnabled(false);
        searchBtn.setEnabled(false);
        itemQtyTxt.setEnabled(false);
        receivedAmountTxt.setEnabled(false);
        checkoutBtn.setEnabled(false);
         billPanel.setVisible(false);
         printBillBtn.setEnabled(false);
        

    }
    private void setCurrentDate(){
        
        LocalDate currentDate = LocalDate.now();

        // Define a formatter for the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date as a string
       formattedDate = currentDate.format(formatter);
        dateLbl.setText(formattedDate);
    }
    private void setCurrentTime(){
        LocalTime currentTime = LocalTime.now();

        // Define a formatter for the desired time format with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");

        // Format the current time as a string
        formattedTime = currentTime.format(formatter);
        timeLbl.setText(formattedTime);
    }
    private int getProductID(String productName){
        String query = "SELECT productID FROM product WHERE productName = ?";
        int productID= 0;
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, productName);
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                productID = result.getInt("productID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productID;
    }
    
   private int getCurrentOrderID() {
    int currentOrderID = 0;
    String query = "SELECT MAX(orderID) AS maxOrderID FROM `order`"; // Alias the result to give it a name
    try {
        PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            currentOrderID = result.getInt("maxOrderID"); // Retrieve using the alias
        }
    } catch (Exception e) {
        // Handle the exception
        e.printStackTrace();
    }
    return currentOrderID;
}
      
   private float getTotalAmount(int orderID){
       String query = "SELECT SUM(totalPrice) AS sumOfTotal FROM orderItem WHERE orderID = ?";
       float totalAmount = 0.00f;
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setInt(1, orderID);
           ResultSet result = statement.executeQuery();
           
           while(result.next()){
               totalAmount = result.getFloat("sumOfTotal");
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
       return totalAmount;
   }

    private void getOrderItems(int orderID){
        CSales sales = new CSales();
        try {
            String[] columnNames = {"Item Code", "Item Name", "Unit Price (Rs.)", "Qty Price", "Total Amount (Rs.)"};
            // Create a DefaultTableModel with specified column names
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            itemTable.setModel(tableModel);
            
            ResultSet result = sales.getOrderItemsConnection(orderID);
            while(result.next()){
                String orderItemCode = result.getString("orderItemCode");
                String orderItemName = result.getString("orderItemName");
                float orderItemPrice = result.getFloat("orderItemPrice");
                int orderItemQty = result.getInt("orderItemQty");
                float totalPrice = result.getFloat("totalPrice");
                
                tableModel.addRow(new Object[]{orderItemCode, orderItemName, orderItemPrice, orderItemQty, totalPrice});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private int currentProductStock(String productCode){
         String query = "SELECT stockQty FROM product WHERE productCode = ?";
         int stockQty = 0;
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, productCode);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                stockQty = result.getInt("stockQty");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View Stock Update: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return stockQty;
    }
    
    private void updateProductQty(int qty, String code){
        String query = "UPDATE product SET stockQty = ? WHERE productCode = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setInt(1, qty);
            statement.setString(2, code);
            statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View Stock Update: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        supplierTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        cashierNameLbl = new javax.swing.JLabel();
        cashierProfileLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        itemCodeTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        itemNameTxt = new javax.swing.JTextField();
        itemCategoryTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        itemUnitPriceTxt = new javax.swing.JTextField();
        itemQtyTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        paymentPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        balanceAmountLbl = new javax.swing.JLabel();
        receivedAmountTxt = new javax.swing.JTextField();
        totalBillAmountTxt = new javax.swing.JTextField();
        balanceAmountTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        checkoutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        addItemBtn = new javax.swing.JButton();
        removeItemBtn = new javax.swing.JButton();
        printBillBtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        newOrderBtn = new javax.swing.JButton();
        startMessageLbl = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        billPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        invoiceNoLbl = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        invoiceDateLbl = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        issuedTimeLbl = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        totalAmountLbl = new javax.swing.JLabel();
        invoiceNoLbl2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        invoiceNoLbl3 = new javax.swing.JLabel();
        receivedAmountLbl = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        invoiceNoLbl5 = new javax.swing.JLabel();
        balanaceAmount = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();

        supplierTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier Code", "Supplier Name", "Supplier Address", "Supplier Mobile"
            }
        ));
        jScrollPane4.setViewportView(supplierTable1);

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

        dateLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 255));
        dateLbl.setText("2023-12-27");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("Date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("Time:");

        timeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(0, 0, 255));
        timeLbl.setText("10.39.12 AM");

        cashierNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cashierNameLbl.setForeground(new java.awt.Color(0, 0, 204));
        cashierNameLbl.setText("D.M Jayasinghe");

        cashierProfileLbl.setBackground(new java.awt.Color(255, 255, 255));
        cashierProfileLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-person-40.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Cashier");

        orderPanel.setBackground(new java.awt.Color(64, 78, 104));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Code:");

        itemCodeTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item Name:");

        itemNameTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        itemNameTxt.setForeground(new java.awt.Color(0, 0, 255));
        itemNameTxt.setEnabled(false);

        itemCategoryTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        itemCategoryTxt.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Item Category:");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Unit Price(Rs.):");

        itemUnitPriceTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        itemUnitPriceTxt.setEnabled(false);

        itemQtyTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Qty:");

        paymentPanel.setBackground(new java.awt.Color(251, 254, 251));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Total Bill Amount (Rs.):");

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Recieved Amount (Rs.):");

        balanceAmountLbl.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        balanceAmountLbl.setForeground(new java.awt.Color(0, 0, 255));
        balanceAmountLbl.setText("Balanace Amount (Rs.):");

        receivedAmountTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        receivedAmountTxt.setText("0.00");

        totalBillAmountTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        totalBillAmountTxt.setText("0.00");
        totalBillAmountTxt.setEnabled(false);

        balanceAmountTxt.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        balanceAmountTxt.setText("0.00");
        balanceAmountTxt.setEnabled(false);

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalBillAmountTxt)
                        .addGap(33, 33, 33))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(balanceAmountLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(balanceAmountTxt)
                        .addGap(30, 30, 30))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(receivedAmountTxt)
                        .addGap(32, 32, 32))))
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(totalBillAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(receivedAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceAmountLbl)
                    .addComponent(balanceAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        checkoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkoutBtn.setForeground(new java.awt.Color(0, 153, 0));
        checkoutBtn.setText("Proceed Checkout");
        checkoutBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true));
        checkoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(orderPanelLayout.createSequentialGroup()
                                        .addComponent(itemCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchBtn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(itemNameTxt)))
                            .addGroup(orderPanelLayout.createSequentialGroup()
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemQtyTxt)
                                    .addComponent(itemUnitPriceTxt)
                                    .addComponent(itemCategoryTxt))))))
                .addContainerGap())
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(itemCategoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(itemUnitPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(itemQtyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkoutBtn)
                .addGap(30, 30, 30))
        );

        itemTable.setBackground(new java.awt.Color(64, 78, 104));
        itemTable.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        itemTable.setForeground(new java.awt.Color(255, 255, 255));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item Code", "Item Name", "Unit Price (Rs.)", "Qty", "Total Amount (Rs.)"
            }
        ));
        itemTable.setGridColor(new java.awt.Color(204, 204, 255));
        itemTable.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(itemTable);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("Current Sales Items");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Invoice");

        addItemBtn.setBackground(new java.awt.Color(26, 147, 111));
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-add-35.png"))); // NOI18N
        addItemBtn.setText("Add");
        addItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        removeItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeItemBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        removeItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemBtnActionPerformed(evt);
            }
        });

        printBillBtn.setBackground(new java.awt.Color(30, 96, 145));
        printBillBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBillBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBillBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icons8-print-35.png"))); // NOI18N
        printBillBtn.setText("Print");
        printBillBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printBillBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        printBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillBtnActionPerformed(evt);
            }
        });

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
                .addGap(337, 337, 337))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("SALES POINTER");

        newOrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newOrderBtn.setForeground(new java.awt.Color(0, 0, 204));
        newOrderBtn.setText("New Sale");
        newOrderBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 2, true));
        newOrderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOrderBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        newOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderBtnActionPerformed(evt);
            }
        });

        startMessageLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        startMessageLbl.setForeground(new java.awt.Color(204, 0, 0));
        startMessageLbl.setText("Please enter new sales to make a sale");

        jInternalFrame1.setVisible(true);

        billPanel.setBackground(new java.awt.Color(255, 255, 255));

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Qty", "Rate(Rs.)", "Total(Rs.)"
            }
        ));
        billTable.setEnabled(false);
        billTable.setGridColor(new java.awt.Color(255, 255, 255));
        billTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        billTable.setShowGrid(false);
        billTable.setShowVerticalLines(true);
        jScrollPane2.setViewportView(billTable);

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setText("INVOICE");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel20.setText("ROYAL MARKET PLAZA");

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        jLabel21.setText("Taste The Royal Treatment");

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel22.setText("Contact No:");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel23.setText("+94762256800");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel24.setText("Invoice No:");

        invoiceNoLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        invoiceNoLbl.setText("10");

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel26.setText("Invoice Date:");

        invoiceDateLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        invoiceDateLbl.setText("2023-12-28");

        jLabel28.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel28.setText("Issued Time:");

        issuedTimeLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        issuedTimeLbl.setText("10.28.23 am");

        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel25.setText("Email:");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel27.setText("royalmarketplaza@gmail.com");

        jLabel29.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel29.setText("TOTAL AMOUNT");

        totalAmountLbl.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        totalAmountLbl.setText("27500.00");

        invoiceNoLbl2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        invoiceNoLbl2.setText("Rs.");

        jLabel30.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel30.setText("RECEIVED AMOUNT");

        invoiceNoLbl3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        invoiceNoLbl3.setText("Rs.");

        receivedAmountLbl.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        receivedAmountLbl.setText("28000.00");

        jLabel31.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel31.setText("BALANCE");

        invoiceNoLbl5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        invoiceNoLbl5.setText("Rs.");

        balanaceAmount.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        balanaceAmount.setText("500.00");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel32.setText("THANK YOU!");

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel18))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invoiceDateLbl)))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(issuedTimeLbl))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(billPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceNoLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                                .addComponent(invoiceNoLbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(balanaceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                                .addComponent(invoiceNoLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receivedAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(83, 83, 83))))
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceDateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuedTimeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNoLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receivedAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNoLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanaceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNoLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLbl)
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashierNameLbl)
                            .addComponent(jLabel8))
                        .addComponent(cashierProfileLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newOrderBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(85, 85, 85))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(removeItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(printBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jInternalFrame1)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startMessageLbl)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cashierProfileLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cashierNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(startMessageLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newOrderBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(printBillBtn)
                            .addComponent(removeItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(1200, 701));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
       
        VLogin login = new VLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeLblMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        CSales sales = new CSales();
        String prodctCode = itemCodeTxt.getText().trim();
        try {
          ResultSet result = (ResultSet)sales.getSalesItemsConnection(prodctCode);
          if(result.next()){
             String productName = result.getString("productName");
             String categoryName = result.getString("categoryName");
             String unitPrice = result.getString("sellPrice");
             
             itemNameTxt.setText(productName);
             itemCategoryTxt.setText(categoryName);
             itemUnitPriceTxt.setText(unitPrice);
          }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        // TODO add your handling code here:
        CSales sales = new CSales();
        
        String orderItemCode = itemCodeTxt.getText().trim();
        String orderItemName = itemNameTxt.getText().trim();
        float unitPrice = Float.parseFloat(itemUnitPriceTxt.getText().trim());
        int orderItemQty = Integer.parseInt(itemQtyTxt.getText().trim());
        float totalPrice = unitPrice * orderItemQty;
        int productID = getProductID(orderItemName);
        int orderID = getCurrentOrderID();
        
          //Update product qty
         int productStockQty = currentProductStock(orderItemCode);
         int newProductQty = productStockQty - orderItemQty;

        updateProductQty(newProductQty,orderItemCode );

        
        //Update order table
         String currentDate = formattedDate;
         String currentTime = formattedTime;
         float billTotalAmount = Float.parseFloat(totalBillAmountTxt.getText());
         float recievedAmount = Float.parseFloat(receivedAmountTxt.getText());
         float balanceAmount = Float.parseFloat(balanceAmountTxt.getText());
        try {
            sales.setOrderItemsConnection(orderItemCode, orderItemName, unitPrice, orderItemQty, totalPrice, productID, orderID);
            itemCodeTxt.setText("");
            itemNameTxt.setText("");
            itemUnitPriceTxt.setText("");
            itemCategoryTxt.setText("");
            itemQtyTxt.setText("");
            
            //Displaying selling items in the table
            getOrderItems(orderID);
            
            //Updating order table
            billTotalAmount += totalPrice;
            balanceAmount = billTotalAmount - recievedAmount;
            
            totalBillAmountTxt.setText(String.valueOf(billTotalAmount));
            balanceAmountTxt.setText(String.valueOf(balanceAmount));
            sales.updateCurrentOrderConnection(billTotalAmount, recievedAmount, balanceAmount, currentDate, currentTime,  orderID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void newOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderBtnActionPerformed
         // TODO add your handling code here:
         CSales sales = new CSales();
         String currentDate = formattedDate;
         String currentTime = formattedTime;
          totalBillAmountTxt.setText("0.00");
          receivedAmountTxt.setText("0.00");
          balanceAmountTxt.setText("0.00");
          
         float totalAmount = 0.00f;
         float recievedAmount = 0.00f;
         float balanceAmount = 0.00f;
         
         try {
            sales.createNewOrderConnection(currentDate, currentTime, totalAmount, recievedAmount, balanceAmount);
            getOrderItems(getCurrentOrderID());
           
        itemCodeTxt.setEnabled(true);
        searchBtn.setEnabled(true);
        itemQtyTxt.setEnabled(true);
        receivedAmountTxt.setEnabled(true);
        checkoutBtn.setEnabled(true);
        startMessageLbl.setVisible(false);
        newOrderBtn.setEnabled(false);
        billPanel.setVisible(false);

   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newOrderBtnActionPerformed

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        // TODO add your handling code here:
        CSales sales = new CSales();
         String currentDate = formattedDate;
         String currentTime = formattedTime;
          float billTotalAmount = Float.parseFloat(totalBillAmountTxt.getText());
         float recievedAmount = Float.parseFloat(receivedAmountTxt.getText());
         float balanceAmount = Float.parseFloat(balanceAmountTxt.getText());
    
         try {

            balanceAmount = recievedAmount - billTotalAmount;
            
            totalBillAmountTxt.setText(String.valueOf(billTotalAmount));
            balanceAmountTxt.setText(String.valueOf(balanceAmount));
            sales.updateCurrentOrderConnection(billTotalAmount, recievedAmount, balanceAmount, currentDate, currentTime,  getCurrentOrderID());
            balanceAmountLbl.setVisible(true);
            balanceAmountTxt.setVisible(true);
            
            itemCodeTxt.setEnabled(false);
            searchBtn.setEnabled(false);
            itemQtyTxt.setEnabled(false);
            receivedAmountTxt.setEnabled(false);
            checkoutBtn.setEnabled(false);
            newOrderBtn.setEnabled(true);
            startMessageLbl.setVisible(true);
            printBillBtn.setEnabled(true);

        } catch (NumberFormatException e) {
        // Handle the case where parsing fails
        JOptionPane.showMessageDialog(null, "Invalid number format. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Handle other exceptions (logging, displaying error message, etc.)
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_checkoutBtnActionPerformed

    private void removeItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemBtnActionPerformed
        // TODO add your handling code here:
         String currentDate = formattedDate;
         String currentTime = formattedTime;
         float billTotalAmount =0.00f;
         float recievedAmount =0.00f;
         float balanceAmount = 0.00f;
         
        int selectedRow = itemTable.getSelectedRow();

        if (selectedRow != -1) {
            // Retrieve data from the selected row and column
            String orderItemCode = (String) itemTable.getValueAt(selectedRow, 0);

            try {
                // Call the method to delete the order item
                CSales sales = new CSales();
                sales.deleteOrderItemConnection(orderItemCode);

                // Optional: Remove the selected row from the table
                DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
                model.removeRow(selectedRow);

                //Displaying selling items in the table
                getOrderItems(getCurrentOrderID());
                float totalPrice = getTotalAmount(getCurrentOrderID());
                
                //Updating order table
            billTotalAmount += totalPrice;
            balanceAmount = recievedAmount - billTotalAmount;
            
            totalBillAmountTxt.setText(String.valueOf(billTotalAmount));
            balanceAmountTxt.setText(String.valueOf(balanceAmount));
            sales.updateCurrentOrderConnection(billTotalAmount, recievedAmount, balanceAmount, currentDate, currentTime,  getCurrentOrderID());
            balanceAmountLbl.setVisible(false);
            balanceAmountTxt.setVisible(false);
            receivedAmountTxt.setText("0.00");
 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "View" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeItemBtnActionPerformed

    private void printBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBillBtnActionPerformed
        // TODO add your handling code here:
      CSales sales = new CSales();
      String[] columnNames = {"Item", "Qty", "Rate(Rs.)", "Total(Rs.)"};
      // Create a DefaultTableModel with specified column names
      DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
      billTable.setModel(tableModel);
        try {
             ResultSet result = sales.generateBillConnection(getCurrentOrderID());
            while(result.next()){
                int orderID = result.getInt("orderID");
                float totalAmount = result.getFloat("totalAmount");
                float recievedAmount = result.getFloat("recievedAmount");
                float balanceAmount = result.getFloat("balanceAmount");
                String orderDate = result.getString("orderDate");
                String orderTime = result.getString("orderTime");
                String orderItemName = result.getString("orderItemName");
                float orderItemPrice = result.getFloat("orderItemPrice");
                int orderItemQty = result.getInt("orderItemQty");
                float totalPrice = result.getFloat("totalPrice");
                
                invoiceNoLbl.setText(String.valueOf(orderID));
                invoiceDateLbl.setText(orderDate);
                issuedTimeLbl.setText(orderTime);
                totalAmountLbl.setText(String.valueOf(totalAmount));
                receivedAmountLbl.setText(String.valueOf(recievedAmount));
                balanaceAmount.setText(String.valueOf(balanceAmount));

                tableModel.addRow(new Object[]{orderItemName, orderItemQty, orderItemPrice, totalPrice});
                billPanel.setVisible(true);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printBillBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JLabel balanaceAmount;
    private javax.swing.JLabel balanceAmountLbl;
    private javax.swing.JTextField balanceAmountTxt;
    private javax.swing.JPanel billPanel;
    private javax.swing.JTable billTable;
    private javax.swing.JLabel cashierNameLbl;
    private javax.swing.JLabel cashierProfileLbl;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel invoiceDateLbl;
    private javax.swing.JLabel invoiceNoLbl;
    private javax.swing.JLabel invoiceNoLbl2;
    private javax.swing.JLabel invoiceNoLbl3;
    private javax.swing.JLabel invoiceNoLbl5;
    private javax.swing.JLabel issuedTimeLbl;
    private javax.swing.JTextField itemCategoryTxt;
    private javax.swing.JTextField itemCodeTxt;
    private javax.swing.JTextField itemNameTxt;
    private javax.swing.JTextField itemQtyTxt;
    private javax.swing.JTable itemTable;
    private javax.swing.JTextField itemUnitPriceTxt;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton newOrderBtn;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JButton printBillBtn;
    private javax.swing.JLabel receivedAmountLbl;
    private javax.swing.JTextField receivedAmountTxt;
    private javax.swing.JButton removeItemBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel startMessageLbl;
    private javax.swing.JTable supplierTable1;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel totalAmountLbl;
    private javax.swing.JTextField totalBillAmountTxt;
    // End of variables declaration//GEN-END:variables
}
