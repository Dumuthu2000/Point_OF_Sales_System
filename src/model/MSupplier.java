package model;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class MSupplier {
    ResultSet result1;
    ResultSet result2;
    public void addSupplier(String supplierName, String supplierAddress){
            String query = "INSERT INTO supplier (supplierName, supplierAddress) VALUES (?, ?)";
            try {
                PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
                statement.setString(1, supplierName);
                statement.setString(2, supplierAddress);

                int insertedRecoreds = statement.executeUpdate();
                if(insertedRecoreds > 0){
                    JOptionPane.showMessageDialog(null, "New supplier successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Your insertion not success..Try Again!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet getSuppliers(){
        String query = "SELECT s.supplierID, s.supplierName, s.supplierAddress, m.mobile_1, m.mobile_2 FROM supplier AS s  INNER JOIN supplier_mobile AS m ON s.supplierID = m.supplierID";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result1 = statement.executeQuery();
        }catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result1;
    }
    
    public void deleteSupplier(int supplierID){
        String query = "DELETE FROM supplier WHERE supplierID = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setInt(1, supplierID);
            
             int userChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Product?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (userChoice == JOptionPane.YES_OPTION) {  
                    int deletedRows = statement.executeUpdate();
                    if(deletedRows == 1){
                        JOptionPane.showMessageDialog(null, "Order Item deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Deletion not done...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
       } catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateSupplier(String supplierName, String supplierAddress, int supplierID){
        String query = "UPDATE supplier SET supplierName = ?, supplierAddress = ?  WHERE supplierID = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, supplierName);
            statement.setString(2, supplierAddress);
            statement.setInt(3, supplierID);
            
            int updatedRows = statement.executeUpdate();
            if(updatedRows > 0){
                JOptionPane.showMessageDialog(null, "Update Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, "Updation not success...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet getOneSupplier(int supplierID){
        String query = "SELECT s.supplierID, s.supplierName, s.supplierAddress, m.mobile_1, m.mobile_2 FROM supplier AS s  INNER JOIN supplier_mobile AS m ON s.supplierID = m.supplierID WHERE s.supplierID = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setInt(1, supplierID);
            result2 = statement.executeQuery();
        }catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result2;
    }
}
