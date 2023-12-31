package controller;
import model.*;
import java.sql.*;

public class CProduct {
    public void addProductItemConnection(String productCode, String productName, float purchasedPrice, float sellPrice, int stockQty, String purchasedDate, int categoryID,  int supplierID) throws Exception{
        MProducts products = new MProducts();
        products.addProductItem(productCode, productName, purchasedPrice, sellPrice, stockQty, purchasedDate, categoryID, supplierID);
    }
    
    public ResultSet getProductItemConnection()throws Exception{
        MProducts products = new MProducts();
        return products.getProducts();
    }
    
    public ResultSet searchProductItemsConnection(String productCode)throws Exception{
        MProducts products = new MProducts();
        return products.searchProductItem(productCode);
    }
    
    public void updateProductConnection(String productCode, String productName, float purchasedPrice, float sellPrice, int stockQty, String purchasedDate, int categoryID,  int supplierID, String searchItem)throws Exception{
        MProducts products = new MProducts();
        products.updateProductItem(productCode, productName, purchasedPrice, sellPrice, stockQty, purchasedDate, categoryID, supplierID, searchItem);
    }
    
    public void deleteProductConnection(String productCode){
        MProducts products = new MProducts();
        products.deleteProductItem(productCode);
    }
}
