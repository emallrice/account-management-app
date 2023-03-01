/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package org.swt301.account.management.test;

import org.testng.Assert;
import org.testng.annotations.*;

import org.swt301.account.management.core.Account;
import org.swt301.account.management.core.AccountManagement;

/**
 *
 * @author Yemufu
 */

public class AccountManagementTest {
    private AccountManagement accountManager;

    @BeforeTest
    public void setUp() {
        accountManager = new AccountManagement();
    }

    @Test
    public void testAddAccount() {
        Account account = new Account(1, "Alice", "alice@gmail.com", "123456789");
        accountManager.addAccount(account);
        Assert.assertEquals(accountManager.getAccountById(1), account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = accountManager.getAccountById(1);
        account.setEmail("alice@yahoo.com");
        accountManager.updateAccount(account);
        Assert.assertEquals(accountManager.getAccountById(1).getEmail(), "alice@yahoo.com");
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account(2, "John", "john@gmail.com", "123456789");
        accountManager.addAccount(account);
        Assert.assertEquals(accountManager.getAccountById(2), account);
    }

    @Test
    public void testGetAllAccounts() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "123456789");
        Account account2 = new Account(3, "Bob", "bob@gmail.com", "987654321");
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);
        Assert.assertEquals(accountManager.getAccounts().size(), 3);
    }
}

