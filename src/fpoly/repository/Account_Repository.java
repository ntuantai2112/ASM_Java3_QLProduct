/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.repository;

import fpoly.interfaces.IAccount_Repository;
import fpoly.model.Account;
import fpoly.utility.Utility;
import java.sql.Connection;
//import static fpoly.repository.Product_Repository.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO T560
 */
public class Account_Repository implements IAccount_Repository {

    @Override
    public ArrayList<Account> getAllAccount() {
        Connection connection = Utility.getConnection();
        ArrayList<Account> listAccount = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String userNam = rs.getString("Username");
                String password = rs.getString("Password");
                String role = rs.getString("Role");

                Account account = new Account(userNam, password, role);
                listAccount.add(account);

            }
            ps.close();
            rs.close();
            connection.close();
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

        return listAccount;
    }

    @Override
    public Account getAccountByName(String seachName) {
        String sql = "select  Username,Password,Role  from Account where Account.Username like ?";
        Connection connection = Utility.getConnection();
        Account account = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + seachName + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String userNam = rs.getString("Username");
                String password = rs.getString("Password");
                String role = rs.getString("Role");

                account = new Account(userNam, password, role);

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

        return account;
    }

}
