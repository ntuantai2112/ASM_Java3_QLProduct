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
public interface IAccount_Service {
     public ArrayList<Account> getAllAccount();
     public Account getAccountByName(String tenCanTim);
     public boolean accountVerification(String pwdRaw,String pwdHash);
     
}
