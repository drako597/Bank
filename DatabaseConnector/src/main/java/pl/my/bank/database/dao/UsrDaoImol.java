/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pl.my.bank.database.orm.Usr;

/**
 *
 * @author karol
 */
@Repository("usrDao")
public class UsrDaoImol extends castomHibernateDaoSupport implements UsrDao {
    @Transactional
    public void saveUsr(Usr user) {
//        Transaction t = getSessionFactory().getCurrentSession().beginTransaction();
        getHibernateTemplate().save(user);
//        t.commit();
    }

    public void deleteUsr(String key) {
        getHibernateTemplate().delete(key);
    }

    public void updateUsr(Usr user) {
        getHibernateTemplate().update(user);
    }

    public List<Usr> listUsr() {
//        getHibernateTemplate().
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

}
