/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.orm;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "creditcart")
public class CreditCart implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10, unique = true)
    private int creditCart_id;
    @Column(name = "number", nullable = false, length = 32, unique = true)
    private int number;
    @Column(name = "registration_date", nullable = false)
    private Date registration_date;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "creditCarts")
    private Set<Account> accounts = new HashSet<Account>(0);


    public CreditCart() {
    }

    public CreditCart(int number, Date registration_date) {
        this.number = number;
        this.registration_date = registration_date;
    }

    public int getCreditCart_id() {
        return creditCart_id;
    }

    public void setCreditCart_id(int creditCart_id) {
        this.creditCart_id = creditCart_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
    
    
    
    
}
