
package controller;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
import model.MSupplier;

import model.MSupplierMobile;

public class CSupplierMobile {
    public void addSupplierMobileConnection(String mobile_1, String mobile_2)throws SQLException, Exception{
        MSupplierMobile supplierMobile = new MSupplierMobile();
        supplierMobile.addSupplierMobile(mobile_1, mobile_2);
    }
    
    public void deleteSupplierMobileConnection(int supplerID)throws SQLException, Exception{
        MSupplierMobile supplierMobile = new MSupplierMobile();
        supplierMobile.deleteSupplierMobile(supplerID);
    }
    
    public void updateSupplierMobile(String mobile_1, String mobile_2, int supplierID)throws SQLException, Exception{
        MSupplierMobile supplierMobile = new MSupplierMobile();
        supplierMobile.updateSupplierMobile(mobile_1, mobile_2, supplierID);
    }
}
