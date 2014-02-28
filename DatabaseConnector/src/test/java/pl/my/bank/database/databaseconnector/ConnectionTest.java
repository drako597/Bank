/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.databaseconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Test połącznia z bazą dznych
 *
 * @author karol
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/SpringConfig.xml"})
public class ConnectionTest {
    
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    
    private BasicDataSource basicDataSource;
    private Connection con;
    private static Logger log = Logger.getLogger(ConnectionTest.class);
    public ConnectionTest() {
    }
    
    @Before
    public void init() {
        this.con=null;
        this.basicDataSource = new BasicDataSource();
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        
    }
    
    @Test
    public void ConnectionDBTest() {
        try {
            con = basicDataSource.getConnection();
        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
            log.fatal(ex.getMessage());
        }
        assertNotNull(con);     
    }
    @After
    public void destroy(){
        try {
            this.con.close();
        } catch (SQLException | NullPointerException ex) {
//            System.out.println("Get Exception in ConnectionTest.destroy(): "+ex.getMessage());
            log.fatal("Get Exception in ConnectionTest.destroy(): "+ex.getMessage());
        }
    }
    
}
