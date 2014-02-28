/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.my.bank.database.dao;

import java.util.List;
import pl.my.bank.database.orm.Account;

/**
 *
 * @author karol
 */
public interface AccountDOA {
    
    void saveAccount(Account user);

    void deleteAccount(String key);

    void updateAccount(Account user);

    List<Account> listAccount();
    
}
