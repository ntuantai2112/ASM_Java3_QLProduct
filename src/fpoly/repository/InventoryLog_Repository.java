/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.repository;

import fpoly.interfaces.I_InventoryLog_Repository;
import fpoly.model.InvetoryLog;
import fpoly.model.Product;
//import  fpoly.repository.Product_Repository.connection;
import fpoly.utility.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO T560
 */
public class InventoryLog_Repository implements I_InventoryLog_Repository {

    @Override
    public ArrayList<InvetoryLog> getAllIventoryLog() {
        Connection connection = Utility.getConnection();
        ArrayList<InvetoryLog> listInvetoryLog = new ArrayList<>();

        String sql = "select ProductId,IEDate,Quantity,Price,IoE from InventoryLog";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("ProductId");
                Date IEDate = rs.getDate("IEDate");
                int quantity = rs.getInt("Quantity");
                Double price = rs.getDouble("Price");
                int iOE = rs.getInt("IoE");

                InvetoryLog invetoryLog = new InvetoryLog(productId, IEDate, iOE, quantity, price);
                listInvetoryLog.add(invetoryLog);

            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return listInvetoryLog;
    }

    @Override
    public void insert(InvetoryLog invetoryLog) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "Insert into InventoryLog(ProductId,Quantity,Price,IoE) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, invetoryLog.getProductId());
            preparedStatement.setInt(2, invetoryLog.getQuality());
            preparedStatement.setDouble(3, invetoryLog.getPrice());
            preparedStatement.setInt(4, invetoryLog.getIoE());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    public void insertPrice(InvetoryLog invetoryLog) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "Insert into InventoryLog(ProductId,Price) values(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, invetoryLog.getProductId());
            preparedStatement.setDouble(2, invetoryLog.getPrice());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<InvetoryLog> getTopRevinue() {
        ArrayList<InvetoryLog> listInvetoryLog = new ArrayList<>();
        Connection connection = Utility.getConnection();
        try {
            String sql = "SELECT TOP 10 ProductId, ProductName, CurrentPrice, Product.Quantity, SUM(InventoryLog.Quantity * Price)  AS revenue \n"
                    + "FROM Product join InventoryLog on Product.Id = InventoryLog.ProductId WHERE IoE = 0 and IEDate  BETWEEN '2023-04-01' AND '2023-06-30'\n"
                    + "GROUP BY ProductId, ProductName, CurrentPrice, Product.Quantity\n"
                    + "ORDER BY revenue DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                Double revenue = rs.getDouble("revenue");

                InvetoryLog invetoryLog = new InvetoryLog();
                invetoryLog.setProductId(productId);
                invetoryLog.setTenSP(productName);
                invetoryLog.setPrice(price);
                invetoryLog.setQuality(quantity);
                invetoryLog.setRevenie(revenue);
                listInvetoryLog.add(invetoryLog);

            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return listInvetoryLog;
    }

}
