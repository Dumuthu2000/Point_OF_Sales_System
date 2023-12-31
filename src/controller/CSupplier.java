package controller;

import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

import model.MSupplier;

public class CSupplier {
    public void addSupplierConnection(String supplierName, String supplierAddress)throws SQLException, Exception{
        MSupplier supplier = new MSupplier();
        supplier.addSupplier(supplierName, supplierAddress);
    }
    
    public ResultSet getSuppliersConnection()throws SQLException, Exception{
        MSupplier supplier = new MSupplier();
        return supplier.getSuppliers();
    }
    
    public void deleteSupplierConnection(int supplierID)throws SQLException, Exception{
        MSupplier supplier = new MSupplier();
        supplier.deleteSupplier(supplierID);
    }
    
    public void updateSupplierConnection(String supplierName, String supplierAddress, int supplierID)throws SQLException, Exception{
        MSupplier supplier = new MSupplier();
        supplier.updateSupplier(supplierName, supplierAddress, supplierID);
    }
    
    public ResultSet getOneSupplierConnection(int supplierID)throws SQLException, Exception{
        MSupplier supplier = new MSupplier();
        return supplier.getOneSupplier(supplierID);
    }
}
