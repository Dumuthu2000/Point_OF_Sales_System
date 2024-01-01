package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class MProducts {
    ResultSet result1, result2, result3;
    public void addProductItem(String productCode, String productName, float purchasedPrice, float sellPrice, int stockQty, String purchasedDate, int categoryID,  int supplierID){
        String query = "INSERT INTO product (productCode, productName, purchasePrice, sellPrice, stockQty , purchasedDate, categoryID, supplierID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);

            statement.setString(1, productCode);
            statement.setString(2, productName);
            statement.setFloat(3, purchasedPrice);
            statement.setFloat(4, sellPrice);
            statement.setInt(5, stockQty);
            statement.setString(6, purchasedDate);
            statement.setInt(7, categoryID);
            statement.setInt(8, supplierID);

            int insertedRows = statement.executeUpdate();
            if (insertedRows > 0) {
                JOptionPane.showMessageDialog(null, productName + " is successfully added");
            } else {
                JOptionPane.showMessageDialog(null, productName + " is not added....Please try again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Fetching all products to the table
    public ResultSet getProducts(){
        String query = "SELECT p.productCode, p.productName, c.categoryName, p.purchasePrice, p.sellPrice, p.stockQty, p.purchasedDate FROM product AS p INNER JOIN category AS c ON p.categoryID = c.categoryID";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            result1 = statement.executeQuery();
        } catch (SQLException e) {
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
    
    public ResultSet searchProductItem(String productCode){
        String query = "SELECT productCode, productName, purchasePrice, sellPrice, stockQty , purchasedDate, categoryID, supplierID  FROM product WHERE productCode = ?";
        try {
             PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
             statement.setString(1, productCode);
             result2 = statement.executeQuery();
        } catch (SQLException e) {
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
    
    //Update products method
    public void updateProductItem(String productCode, String productName, float purchasedPrice, float sellPrice, int stockQty, String purchasedDate, int categoryID,  int supplierID, String searchItem){
        String query = "UPDATE product SET productCode = ?, productName = ?, purchasePrice = ?, sellPrice = ?, stockQty = ?, purchasedDate = ?, categoryID = ?, supplierID = ? WHERE productCode = ?";
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1, productCode);
            statement.setString(2, productName);
            statement.setFloat(3, purchasedPrice);
            statement.setFloat(4, sellPrice);
            statement.setInt(5, stockQty);
            statement.setString(6, purchasedDate);
            statement.setInt(7, categoryID);
            statement.setInt(8, supplierID);
            statement.setString(9, searchItem);
            
            int updatedRows = statement.executeUpdate();
            if(updatedRows == 1){
                JOptionPane.showMessageDialog(null, "Updation Successfull");
            }else{
                JOptionPane.showMessageDialog(null, "Updation not done...Try Again!!!!", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    //Method for delete a product from the table
    public void deleteProductItem(String productCode){
        String query = "DELETE FROM product WHERE productCode = ?";
        
        try {
            PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
            statement.setString(1,productCode );
            
            
             int userChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Product?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (userChoice == JOptionPane.YES_OPTION) {  
                    int updatedRows = statement.executeUpdate();
                    if(updatedRows == 1){
                        JOptionPane.showMessageDialog(null, "Product deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    
    public ResultSet getSuppliersForComboBox(){
        String query = "SELECT supplierName FROM supplier";
        try {
             PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
             result3 = statement.executeQuery();
        } catch (SQLException e) {
                // Handle SQL exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An error occurred while processing the database operation.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
            // Handle other exceptions
                e.printStackTrace(); // You might want to log the exception or handle it in a way suitable for your application.
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result3;
    }
}
