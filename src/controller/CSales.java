package controller;
import model.MSales;
import java.sql.*;

public class CSales {
    public ResultSet getSalesItemsConnection(String productCode)throws Exception{
        MSales sales = new MSales();
        return sales.getSalesItems(productCode);
    }
    public void setOrderItemsConnection(String orderItemCode, String orderItemName, float unitPrice, int orderItemQty, float totalPrice, int productID, int orderID)throws Exception{
        MSales sales = new MSales();
        sales.setOrderItems(orderItemCode, orderItemName, unitPrice, orderItemQty, totalPrice, productID, orderID);
    }
    
    public void createNewOrderConnection(String orderDate, String orderTime, float totalAmount, float recievedAmount, float balanceAmount)throws Exception{
        MSales sales = new MSales();
        sales.createNewOrder(orderDate, orderTime, totalAmount, recievedAmount, balanceAmount);
    }
    
    public void updateCurrentOrderConnection(float totalAmount, float recievedAmount, float balanceAmount, String orderDate, String orderTime, int orderID)throws Exception{
        MSales sales = new MSales();
        sales.updateCurrentOrder(totalAmount, recievedAmount, balanceAmount, orderDate, orderTime, orderID);
    }
    
    public ResultSet getOrderItemsConnection(int orderID)throws Exception{
        MSales sales = new MSales();
        return sales.getOrderItems(orderID);
    }
    
    public void deleteOrderItemConnection(String orderItemCode)throws Exception{
        MSales sales = new MSales();
        sales.deleteOrderItem(orderItemCode);
    }
    
    public ResultSet generateBillConnection(int orderID){
        MSales sales = new MSales();
        return sales.generateBill(orderID);
    }
}
