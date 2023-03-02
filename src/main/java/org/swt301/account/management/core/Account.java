/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.swt301.account.management.core;

/**
 *
 * @author Yemufu
 */
public class Account {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Account(int id, String name, String email, String phone) {
        if (id>0 && id<100) {
            this.id = id;
        }
        if (!name.isEmpty() && name.length()<100) {
            this.name = name;
        }   
        if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") && !email.isEmpty()) {
            this.email = email;
        }
        if (phone!=null) {
            if (phone.length()<=10 && phone.length()>0 && phone.startsWith("0")) {
                this.phone = phone;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id>0 && id<100) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty() && name.length()<100) {
            this.name = name;
        }   
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") && !email.isEmpty()) {
            this.email = email;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone!=null) {
            if (phone.length()<=10 && phone.length()>0 && phone.startsWith("0")) {
                this.phone = phone;
            }
        }
    }
}
