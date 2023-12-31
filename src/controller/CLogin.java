
package controller;

import java.sql.ResultSet;
import java.sql.*;
import model.MLogin;

public class CLogin {
    public ResultSet getCredentialsConnection()throws Exception{
        MLogin login = new MLogin();
        return login.getCredentials();
    }
}
