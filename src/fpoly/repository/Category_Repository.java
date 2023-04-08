/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.repository;

import fpoly.interfaces.ICategory_Repository;
import fpoly.interfaces.IProduct_Repository;
import fpoly.model.Account;
import fpoly.model.Category;
import fpoly.model.Product;
//import static fpoly.repository.Product_Repository.connection;
import fpoly.utility.Utility;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO T560
 */
public class Category_Repository implements ICategory_Repository {

    private ArrayList<Category> listCategory = new ArrayList<>();

    @Override
    public Category getCategoryByName(String seachName) {
        String sql = "SELECT * FROM Cateogory WHERE CategoryName like N'%%' ";
        Category category = null;
        Connection connection = Utility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String categoryName = rs.getString("CategoryName");

                category = new Category(id, categoryName);
            }
            ps.close();
            rs.close();
            connection.close();
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
        return category;
    }

    @Override
    public ArrayList<Category> getAllCategorys() {
        String sql = "select * from Category ";
        Connection connection = Utility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String categoryName = rs.getString("CategoryName");
                Category category = new Category(id, categoryName);
                listCategory.add(category);
            }

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

        return listCategory;
    }

}
