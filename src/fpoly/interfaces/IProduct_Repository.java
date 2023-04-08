/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpoly.interfaces;

import fpoly.model.Account;
import fpoly.model.Product;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public interface IProduct_Repository {

    public void insert(Product product);

    public void update(int id, Product product);


    public void updateQuantityProduct(int id, int quantity);
    
    public void updatePriceProduct(int id, Double price);

    public void delete(int id);

    public ArrayList<Product> getAllProduct();

    public ArrayList<Product> getAllProductByCategoryId(int id);

    public Product getProductByName(String seachName);
    
      public Product getProductById(int id);

    public ArrayList<Product> getAllProductByName(String searchName);

}
