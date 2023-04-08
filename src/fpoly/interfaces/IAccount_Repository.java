/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpoly.interfaces;

import fpoly.model.Account;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public interface IAccount_Repository {
    public ArrayList<Account> getAllAccount();
     public Account getAccountByName(String tenCanTim);
     
     
}
