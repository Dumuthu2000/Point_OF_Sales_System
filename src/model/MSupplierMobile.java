package model;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class MSupplierMobile {
   public void addSupplierMobile(String mobile_1, String mobile_2) {
    String query = "INSERT INTO supplier_mobile (mobile_1, mobile_2) VALUES (?, ?)";
    try {
        PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
        statement.setString(1, mobile_1);
        statement.setString(2, mobile_2);

        int insertedRecords = statement.executeUpdate();
        if (insertedRecords > 0) {
            //JOptionPane.showMessageDialog(null, "New supplier mobile details successfully created", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Your insertion was not successful. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        // Handle SQL exceptions
        e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
        JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // Handle other exceptions
        e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
        JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   
   public void deleteSupplierMobile(int supplierID){
       String query = "DELETE FROM supplier_mobile WHERE supplierID = ?";
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setInt(1, supplierID);
           statement.executeUpdate();
           
//           int userChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Product?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (userChoice == JOptionPane.YES_OPTION) {  
//                    int deletedRows = statement.executeUpdate();
//                    if(deletedRows == 1){
//                        JOptionPane.showMessageDialog(null, "Order Item deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Deletion not done...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
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
   
   public void updateSupplierMobile(String mobile_1, String mobile_2, int supplierID){
       String query = "UPDATE supplier_mobile SET mobile_1 = ? , mobile_2 = ?  WHERE supplierID = ?";
       try {
           PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
           statement.setString(1, mobile_1);
           statement.setString(2, mobile_2);
           statement.setInt(3, supplierID);
           
           statement.executeUpdate();
//            if(updatedRows > 0){
//                JOptionPane.showMessageDialog(null, "Update Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
//            }else{
//                 JOptionPane.showMessageDialog(null, "Updation not success...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
//            }
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
}
