/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.service;

import fpoly.interfaces.IProduct_Service;
import fpoly.model.Account;
import fpoly.model.Product;
import fpoly.repository.Product_Repository;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public class Product_Service implements IProduct_Service {

    private Product_Repository repository = new Product_Repository();

    @Override
    public void add(Product product) {
        repository.insert(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id, product);
    }

    public void updateQuantityProduct(int id, int quantity) {
        repository.updateQuantityProduct(id, quantity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return repository.getAllProduct();
    }

    @Override
    public Product getProductByName(String seachName) {
        return repository.getProductByName(seachName);
    }

    @Override
    public ArrayList<Product> getAllProductByCategoryId(int id) {
        return repository.getAllProductByCategoryId(id);
    }

    @Override
    public ArrayList<Product> getAllProductByName(String searchName) {
        return repository.getAllProductByName(searchName);
    }

    @Override
    public void updatePriceProduct(int id, Double price) {
        repository.updatePriceProduct(id, price);
    }

    @Override
    public Product getProductId(int id) {
        return repository.getProductById(id);
    }

}
