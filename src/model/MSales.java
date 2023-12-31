package model;
import java.sql.*;
import javax.swing.*;

public class MSales {
    ResultSet result1;
    ResultSet result2;
    ResultSet result3;
    public ResultSet getSalesItems(String productCode){
        String query = "SELECT p.productName, c.categoryName, p.sellPrice FROM product AS p INNER JOIN category AS c ON p.categoryID = c.categoryID WHERE p.productCode = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, productCode);
            result1 = statement.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mdoel"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result1;
    }
    
    public void setOrderItems(String orderItemCode, String orderItemName, float unitPrice, int orderItemQty, float totalPrice, int productID, int orderID){
        String query = "INSERT INTO orderItem (orderItemCode, orderItemName, orderItemPrice, orderItemQty, totalPrice, productID, orderID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, orderItemCode);
            statement.setString(2, orderItemName);
            statement.setFloat(3, unitPrice);
            statement.setInt(4, orderItemQty);
            statement.setFloat(5, totalPrice);
            statement.setInt(6, productID);
            statement.setInt(7, orderID);
            
            statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mdoel"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   public void createNewOrder(String orderDate, String orderTime, float totalAmount, float recievedAmount, float balanceAmount) {
    String query = "INSERT INTO `order` (orderDate, orderTime, totalAmount, recievedAmount, balanceAmount) VALUES (?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
        statement.setString(1, orderDate);
        statement.setString(2, orderTime);
        statement.setFloat(3, totalAmount);
        statement.setFloat(4, recievedAmount);
        statement.setFloat(5, balanceAmount);
        
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "New order created");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Model" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
    }
}
   
   public void updateCurrentOrder(float totalAmount, float recievedAmount, float balanceAmount, String orderDate, String orderTime, int orderID){
       String query = "UPDATE `order` SET totalAmount = ?, recievedAmount = ?, balanceAmount = ?, orderDate = ?, orderTime = ?  WHERE orderID = ?";
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setFloat(1, totalAmount);
            statement.setFloat(2, recievedAmount);
            statement.setFloat(3, balanceAmount);
            statement.setString(4, orderDate);
            statement.setString(5, orderTime);
            statement.setInt(6, orderID);
            
            statement.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Model" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   public ResultSet getOrderItems(int orderID){
       String query = "SELECT orderItemCode, orderItemName, orderItemPrice, orderItemQty, totalPrice FROM orderItem WHERE orderID = ?";
       
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setInt(1, orderID);
           result2 = statement.executeQuery();
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Model Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
       return result2;
   }
   
   public void deleteOrderItem(String orderItemCode){
       String query = "DELETE FROM orderItem WHERE orderItemCode = ?";
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setString(1, orderItemCode);
            int userChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Product?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (userChoice == JOptionPane.YES_OPTION) {  
                    int deletedRows = statement.executeUpdate();
                    if(deletedRows == 1){
                        JOptionPane.showMessageDialog(null, "Order Item deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Deletion not done...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Model Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   public ResultSet generateBill(int orderID){
       String query = "SELECT o.orderID,  o.totalAmount, o.recievedAmount, o.balanceAmount, o.orderDate, o.orderTime, i.orderItemName, i.orderItemPrice, i.orderItemQty, i.totalPrice FROM `order` AS o INNER JOIN orderItem AS i ON o.orderID = i.orderID WHERE o.orderID = ?";
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setInt(1, orderID);
          result3 = statement.executeQuery();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Model Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
       }
       return result3;
   }

}
