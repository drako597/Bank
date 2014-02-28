/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.orm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10, unique = true)
    private int account_id;
    @Column(name = "bill_number", nullable = false, length = 32, unique = true)
    private int bill_number;
    @Column(name = "registration_date", nullable = false)
    private Date registration_date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "account_creditcart", joinColumns = {
        @JoinColumn(name = "account_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "creditCart_id",
                        nullable = false, updatable = false)})
    private Set<CreditCart> creditCarts = new HashSet<CreditCart>(0);

//    @ManyToOne
//    private Usr usr;
    public Account() {
    }

    public Account(int bill_number, Date registration_date) {
        this.bill_number = bill_number;
        this.registration_date = registration_date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getBill_number() {
        return bill_number;
    }

    public void setBill_number(int bill_number) {
        this.bill_number = bill_number;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Set<CreditCart> getCreditCarts() {
        return creditCarts;
    }

    public void setCreditCarts(Set<CreditCart> creditCarts) {
        this.creditCarts = creditCarts;
    }

//    public Usr getUsr() {
//        return usr;
//    }
//
//    public void setUsr(Usr usr) {
//        this.usr = usr;
//    }
}
