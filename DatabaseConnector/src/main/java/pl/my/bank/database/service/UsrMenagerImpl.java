/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.my.bank.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.my.bank.database.dao.UsrDao;
import pl.my.bank.database.orm.Usr;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karol
 */
@Service
public class UsrMenagerImpl implements UsrMenager{

    @Autowired
    private UsrDao usrDao;
    
    @Transactional
    public void addUsr(Usr usr) {
       usrDao.saveUsr(usr);
    }
    
    
    
}
