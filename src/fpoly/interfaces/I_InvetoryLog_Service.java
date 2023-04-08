/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpoly.interfaces;

import fpoly.model.InvetoryLog;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public interface I_InvetoryLog_Service {

    public ArrayList<InvetoryLog> getAllIventoryLog();

    public void insert(InvetoryLog invetoryLog);

    public void insertPrice(InvetoryLog invetoryLog);

    public ArrayList<InvetoryLog> getTopRevinue();
}
