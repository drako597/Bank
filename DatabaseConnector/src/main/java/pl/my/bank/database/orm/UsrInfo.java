/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.my.bank.database.orm;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "usrinfo")
public class UsrInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrinfo_id")
    private int userinfo_id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "surname", length = 20, nullable = false)
    private String surname;
    @Column(name = "address", length = 20, nullable = false)
    private String address;
    @Column(name = "registracion_date", nullable = false)
    private Date date;

    public UsrInfo() {
    }

    public UsrInfo(String name, String surname, String address, Date date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.date = date;

    }

    public int getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(int userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
