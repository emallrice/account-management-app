/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.swt301.account.management.core;

/**
 *
 * @author Yemufu
 */
import java.util.ArrayList;

public class AccountManagement {

    private ArrayList<Account> accounts;

    public AccountManagement() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        Account accountById = getAccountById(account.getId());
        if (accountById == null) {
            accounts.add(account);
        }
    }
    
    public void clearList() {
        accounts.clear();
    }

    public void updateAccount(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == account.getId()) {
                accounts.set(i, account);
                break;
            }
        }
    }
    
    public boolean deleteAccountByName(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equalsIgnoreCase(name)) {
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Account getAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getId() == id) {
                return acc;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
