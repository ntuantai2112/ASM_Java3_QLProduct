/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.repository;

import fpoly.interfaces.IProduct_Repository;
import fpoly.model.Account;
import fpoly.model.Category;
import fpoly.model.Product;
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
public class Product_Repository implements IProduct_Repository {

    @Override
    public void insert(Product product) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "INSERT INTO Product (CategoryId, ProductName, CurrentPrice, Quantity, Topic1, Topic2) VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(
                    1, product.getCategoryId());
            preparedStatement.setString(
                    2, product.getTenSP());
            preparedStatement.setDouble(
                    3, product.getGia());
            preparedStatement.setInt(
                    4, product.getSoLuong());
            preparedStatement.setString(
                    5, product.getTopic1());
            preparedStatement.setString(
                    6, product.getTopic2());
            int rs = preparedStatement.executeUpdate();

            System.out.println(rs);

            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public void update(int id, Product product) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "Update Product set  categoryId = ? ,ProductName = ? ,Topic1 = ?, Topic2 = ?  where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getCategoryId());
            preparedStatement.setString(2, product.getTenSP());
            preparedStatement.setString(3, product.getTopic1());
            preparedStatement.setString(4, product.getTopic2());
            preparedStatement.setInt(5, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public void delete(int id) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "Delete from Product where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            //preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();

        Connection connection = Utility.getConnection();
        String sql = "SELECT * FROM Product join Category on Product.CategoryId = Category.Id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                int categoryId = rs.getInt("CategoryId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                String topic1 = rs.getString("Topic1");
                String topic2 = rs.getString("Topic2");
                String categoryName = rs.getString("CategoryName");

                Product product = new Product(id, categoryId, productName, price, quantity, topic1, topic2);

                product.setCategoryName(categoryName);
                listProduct.add(product);
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

        return listProduct;
    }

    @Override
    public Product getProductByName(String seachName) {
        Connection connection = Utility.getConnection();
        String sql = "SELECT * FROM PRODUCT WHERE ProductName LIKE '%%' ";
        Product product = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                int categoryId = rs.getInt("CategoryId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                String topic1 = rs.getString("Topic1");
                String topic2 = rs.getString("Topic2");
                String categoryName = rs.getString("CategoryName");

                product = new Product(id, categoryId, productName, price, quantity, topic1, topic2);
                product.setCategoryName(categoryName);
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

        return product;
    }

    @Override
    public ArrayList<Product> getAllProductByCategoryId(int id) {
        Connection connection1 = Utility.getConnection();
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM Product join Category on Product.CategoryId = Category.Id where categoryID = ?";
        try {
            PreparedStatement ps = connection1.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("Id");
                int categoryId = rs.getInt("CategoryId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                String topic1 = rs.getString("Topic1");
                String topic2 = rs.getString("Topic2");
                String categoryName = rs.getString("CategoryName");

                Product product = new Product(id, categoryId, productName, price, quantity, topic1, topic2);
                product.setCategoryName(categoryName);
                listProduct.add(product);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Product_Repository.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return listProduct;
    }

    @Override
    public ArrayList<Product> getAllProductByName(String searchName) {
        Connection connection = Utility.getConnection();
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM Product join Category on Product.CategoryId = Category.Id where ProductName like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + searchName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int categoryId = rs.getInt("CategoryId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                String topic1 = rs.getString("Topic1");
                String topic2 = rs.getString("Topic2");
                String categoryName = rs.getString("CategoryName");

                Product product = new Product(id, categoryId, productName, price, quantity, topic1, topic2);
                product.setCategoryName(categoryName);
                listProduct.add(product);
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

        return listProduct;
    }

    @Override
    public void updateQuantityProduct(int id, int quatity) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "UPDATE Product SET Quantity = ? where id = ?";
            System.out.println(id);
            System.out.println(quatity);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, quatity);
            preparedStatement.setInt(2, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public void updatePriceProduct(int id, Double price) {
        Connection connection = Utility.getConnection();
        try {
            String sql = "UPDATE Product SET CurrentPrice = ? where id = ?";
            System.out.println(id);
            System.out.println(price);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Product_Repository.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    public Product getProductById(int id) {
        String sql = "SELECT * FROM PRODUCT where Id = ? ";
        Product product = null;
        Connection connection = Utility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("Id");
                int categoryId = rs.getInt("CategoryId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("CurrentPrice");
                int quantity = rs.getInt("Quantity");
                String topic1 = rs.getString("Topic1");
                String topic2 = rs.getString("Topic2");

                product = new Product(id, categoryId, productName, price, quantity, topic1, topic2);
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

        return product;
    }

}
