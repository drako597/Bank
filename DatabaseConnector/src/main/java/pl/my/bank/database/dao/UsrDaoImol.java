/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.dao;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pl.my.bank.database.orm.Usr;

/**
 *
 * @author karol
 */
@Repository("usrDao")
public class UsrDaoImol extends castomHibernateDaoSupport implements UsrDao {
    private static Logger log = Logger.getLogger(UsrDaoImol.class);

    @Transactional
    public void saveUsr(Usr usr) {
        
        getHibernateTemplate().save(usr);
        log.info("SAVE Usr: "+usr.getLogin());
    }

    @Transactional
    public void deleteUsr(Usr usr) {

        getSessionFactory().getCurrentSession().delete(usr);
        log.info("DELETE Usr: "+usr.getLogin());
    }

    @Transactional
    public void updateUsr(Usr user) {
        getHibernateTemplate().update(user);
    }

    @Transactional
    public List<Usr> listUsr() {
        log.info("CREATE LIST Usr");
        return getSessionFactory().getCurrentSession().createQuery("from Usr").list();
    }

}
