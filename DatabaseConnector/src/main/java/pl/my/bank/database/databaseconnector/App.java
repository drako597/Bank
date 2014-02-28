package pl.my.bank.database.databaseconnector;

import java.sql.Date;
import java.util.Random;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.my.bank.database.dao.UsrDao;
import pl.my.bank.database.dao.UsrDaoImol;
import pl.my.bank.database.orm.Account;
import pl.my.bank.database.orm.CreditCart;
import pl.my.bank.database.orm.Usr;
import pl.my.bank.database.orm.UsrInfo;
import pl.my.bank.database.service.UsrMenager;
import pl.my.bank.database.service.UsrMenagerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "SpringConfig.xml");
       
        UsrMenager dao = (UsrMenager) ctx.getBean("usrMenagerImpl");
        Random rand = new Random();
        System.out.println(rand.nextInt());
       Date date =  new Date(System.currentTimeMillis());
       Account account = new Account(rand.nextInt(), date);
       
        Usr usr = new Usr(rand.nextInt(), "qaz4");
        CreditCart cart = new CreditCart(rand.nextInt(), date);
        account.getCreditCarts().add(cart);
        UsrInfo info = new UsrInfo(Integer.toString(rand.nextInt()), Integer.toString(rand.nextInt()), Integer.toString(rand.nextInt()), date);
        usr.setUsrInfo(info);
        usr.getAccounts().add(account);
        dao.addUsr(usr);
    }
}
