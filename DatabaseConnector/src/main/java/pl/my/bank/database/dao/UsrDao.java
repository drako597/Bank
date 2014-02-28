/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.dao;

import java.util.List;
import pl.my.bank.database.orm.Usr;

/**
 *
 * @author karol
 */
public interface UsrDao {

    void saveUsr(Usr user);

    void deleteUsr(String key);

    void updateUsr(Usr user);

    List<Usr> listUsr();

}
