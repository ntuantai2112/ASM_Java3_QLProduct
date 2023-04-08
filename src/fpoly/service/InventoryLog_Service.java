/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.service;

import fpoly.model.InvetoryLog;
import fpoly.model.Product;
import fpoly.repository.InventoryLog_Repository;
import fpoly.repository.Product_Repository;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public class InventoryLog_Service extends InventoryLog_Repository {

    private InventoryLog_Repository repository = new InventoryLog_Repository();

    @Override
    public void insert(InvetoryLog invetoryLog) {
        repository.insert(invetoryLog);
    }

    public ArrayList<InvetoryLog> getAllProductByCategoryId() {
        return repository.getAllIventoryLog();
    }

    public void insertPrice(InvetoryLog invetoryLog) {
        repository.insertPrice(invetoryLog);
    }

    public ArrayList<InvetoryLog> getTopRevinue() {
        return repository.getTopRevinue();
    }

}
