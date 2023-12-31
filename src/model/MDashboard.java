package model;
import java.sql.*;
import javax.swing.*;

public class MDashboard {
    ResultSet result1;
    ResultSet result2;
    ResultSet result3;
    ResultSet result4;
    ResultSet result5;
    ResultSet result6;
    
    public ResultSet getInvoicesCount(String orderDate){
        String query= "SELECT COUNT(orderID ) AS ordersCount FROM `order` WHERE orderDate = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, orderDate);
            result1 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result1;
    }
    
    public ResultSet getSalesIncome(){
        String query= "SELECT SUM(totalAmount ) AS salesAmount FROM `order` ";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result2 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result2;
    }
    
    public ResultSet getTodaySalesAmount(String todayDate){
         String query= "SELECT SUM(totalAmount ) AS salesAmount FROM `order` WHERE orderDate = ? ";
         try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, todayDate);
            result3 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result3;
    }
    
    public ResultSet getProductsCount(){
        String query= "SELECT COUNT(productID ) AS productsCount FROM product";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result4 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result4;
    }
    
    public ResultSet getStockOutProductsCount(){
        String query= "SELECT COUNT(productID ) AS productsCount FROM product WHERE stockQty = 0";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result5 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result5;
    }
    
    public ResultSet getSupplierCount(){
        String query= "SELECT COUNT(supplierID ) AS supplierCount FROM supplier";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result6 = statement.executeQuery();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Model Dashboard"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result6;
    }
}
