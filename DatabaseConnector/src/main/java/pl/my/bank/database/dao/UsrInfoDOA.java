/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.dao;

import java.util.List;
import pl.my.bank.database.orm.Account;
import pl.my.bank.database.orm.Usr;
import pl.my.bank.database.orm.UsrInfo;

/**
 *
 * @author karol
 */
public interface UsrInfoDOA {
    
    void saveUsrInfo(UsrInfo user);

    void deleteUsrInfo(String key);

    void updateUsrInfo(UsrInfo user);

    List<UsrInfo> listUsrInfo();

}
