/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.my.bank.database.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "usr")
public class Usr implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 10,unique = true)
    private int user_id;
    @Column(nullable = false,length = 10,unique = true)
    private int login;
    @Column(nullable = false,length = 255,unique = false)
    private String password;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "usr", cascade = CascadeType.ALL)
    private UsrInfo usrInfo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usr")    
    private Set<Account> accounts = new HashSet<Account>();

    public Usr() {
    }

    public Usr(int login, String password) {
        this.login = login;
        this.password = password;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsrInfo getUsrInfo() {
        return usrInfo;
    }

    public void setUsrInfo(UsrInfo usrInfo) {
        this.usrInfo = usrInfo;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
    
    
    
}
