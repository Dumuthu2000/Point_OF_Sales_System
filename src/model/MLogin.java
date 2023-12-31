package model;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

public class MLogin {
    ResultSet result; // class-level variable

public ResultSet getCredentials() {
    String query = "SELECT email, password FROM user";
    try {
        PreparedStatement statement = MDbConnection.createConnection().prepareStatement(query);
        result = statement.executeQuery();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Model Login" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return result;
}

}
