/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.service;

import fpoly.interfaces.ICatogory_Service;
import fpoly.repository.Category_Repository;
import fpoly.model.Category;
import java.util.ArrayList;


/**
 *
 * @author LENOVO T560
 */
public class Category_Service implements ICatogory_Service{
    private Category_Repository repository = new Category_Repository();
    

    @Override
     public Category getCategoryByName(String seachName) {
        return repository.getCategoryByName(seachName);
    }

    @Override
    public ArrayList<Category> getAllCategorys() {
        return repository.getAllCategorys();
        
    }

   

   
}
