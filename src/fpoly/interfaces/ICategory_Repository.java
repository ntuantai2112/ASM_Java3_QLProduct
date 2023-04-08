/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpoly.interfaces;

import fpoly.model.Category;
import fpoly.model.Product;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public interface ICategory_Repository {
    
    public ArrayList<Category> getAllCategorys();

    public Category getCategoryByName(String seachName);
    
   
}
