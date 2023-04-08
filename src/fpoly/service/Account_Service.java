/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.service;

import fpoly.interfaces.IAccount_Service;
import fpoly.model.Account;
import fpoly.repository.Account_Repository;
import fpoly.utility.Utility;
import java.util.ArrayList;

/**
 *
 * @author LENOVO T560
 */
public class Account_Service implements IAccount_Service {

    private Account_Repository repository = new Account_Repository();

    @Override
    public ArrayList<Account> getAllAccount() {
        return repository.getAllAccount();
    }

    @Override
    public Account getAccountByName(String tenCanTim) {
        return repository.getAccountByName(tenCanTim);
    }

    @Override
    public boolean accountVerification(String pwdRaw,String pwdHash) {
      return Utility.checkPwd(pwdRaw, pwdHash);
    }

}
