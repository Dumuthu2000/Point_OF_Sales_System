package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class MDbConnection {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/pointOfSales";
    private static String user = "root";
    private static String password = "";
    
    public static Connection createConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return connection;
    }

    static void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
