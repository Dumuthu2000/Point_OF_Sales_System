
package controller;
import java.awt.*;
import model.MDashboard.*;
import java.sql.*;
import model.MDashboard;

public class CDashboard {
    public ResultSet getInvoicesCountConnection(String orderDate)throws Exception{
        MDashboard dashboard = new MDashboard();
        return dashboard.getInvoicesCount(orderDate);
    }
    
    public ResultSet getSalesIncomeConnection()throws Exception{
        MDashboard dashboard = new MDashboard();
        return dashboard.getSalesIncome();
    }
    
    public ResultSet getTodaySalesIncomeConnection(String todayDate)throws Exception{
        MDashboard dashboard = new MDashboard();
        return dashboard.getTodaySalesAmount(todayDate);
    }
    
     public ResultSet getProductsCountConnection()throws Exception{
        MDashboard dashboard = new MDashboard();
        return dashboard.getProductsCount();
    }
     
     public ResultSet getStockOutProductsCountConnection()throws Exception{
        MDashboard dashboard = new MDashboard();
        return dashboard.getStockOutProductsCount();
    }
     
     public ResultSet getSupplierCountConnection(){
         MDashboard dashboard = new MDashboard();
        return dashboard.getSupplierCount();
     }
}
