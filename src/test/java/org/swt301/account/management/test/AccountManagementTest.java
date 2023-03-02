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

    // #Test case 1: add account
    // call addAccount function to add account to ArrayList
    // Expected value: Account(1, "Alice", "alice@gmail.com", "012345678")
    @Test
    public void testAddAccount() {
        Account account = new Account(1, "Alice", "alice@gmail.com", "012345678");
        accountManager.addAccount(account);
        Assert.assertEquals(accountManager.getAccountById(1), account);
    }

    // #Test case 2: update Account
    // call updateAccount function to update account in ArrayList
    // Expected value: change acc.Email to "alice@yahoo.com"
    @Test
    public void testUpdateAccount() {
        Account account = accountManager.getAccountById(1);
        account.setEmail("alice@yahoo.com");
        accountManager.updateAccount(account);
        Assert.assertEquals(accountManager.getAccountById(1).getEmail(), "alice@yahoo.com");
    }
    
    // #Test case 3: test delete first account found by name in a list of accounts
    @Test
    public void testDeleteAccountByName() {
        Account account1 = new Account(1, "Alice", "alice@gmail.com", "012345678");
        accountManager.addAccount(account1);
        Account account2 = new Account(2, "David", "david@gmail.com", "0726938172");
        accountManager.addAccount(account2);
        Account account3 = new Account(3, "John", "john@gmail.com", "0561827391");
        accountManager.addAccount(account3);
        Assert.assertEquals(accountManager.deleteAccountByName("David"), true);
    }

    // #Test case 4: get account by id
    // call getAccountById function to get account that have id 1
    // Expected value: Account(2, "John", "john@gmail.com", "012345678")
    @Test
    public void testGetAccountById() {
        Account account = new Account(2, "John", "john@gmail.com", "012345678");
        accountManager.addAccount(account);
        Assert.assertEquals(accountManager.getAccountById(2), account);
    }

    // Test case 5: get all accounts
    // call getAllAccounts to display all account in arrayList
    // Expected value: getAccounts().size() = 4
    @Test
    public void testGetAllAccounts() {
        Account account1 = new Account(3, "Mary", "mary@yahoo.com", "012345678");
        Account account2 = new Account(4, "Bob", "bob@gmail.com", "098765432");
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);
        Assert.assertEquals(accountManager.getAccounts().size(), 4);
    }
    
    //test model Account
    
    // #Test case 6: test with null phone
    @Test
    public void testNullPhoneNumber() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setPhone("");
        Assert.assertEquals(account1.getPhone(), "012345678");
    }  
    
    // #Test case 7: test phone number must be 10 degits
    @Test
    public void testTooLongPhoneNumber() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setPhone("123456789101112");
        Assert.assertEquals(account1.getPhone(), "012345678");
    }
    
    // #Test case 8: test phone have format=0xxxxxxxxx
    @Test
    public void testPhoneCanNotHaveWrongFormat() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setPhone("123456789");
        Assert.assertEquals(account1.getPhone(), "012345678");
    }
    
    // #Test case 9: test email must have @gmail.com or @yahoo.com in tail
    @Test
    public void testEmailMustHaveCorrectEmailFormat() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setEmail("haha@hihi.com");
        Assert.assertEquals(account1.getEmail(), "alice@yahoo.com");
    }
    
    // #Test case 10: test email can not be empty 
    @Test
    public void testEmailCanNotBeEmpty() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setEmail("");
        Assert.assertEquals(account1.getEmail(), "alice@yahoo.com");
    }
    
    // #Test case 11: test name can not be empty
    @Test
    public void testNameCanNotBeEmpty() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setName("");
        Assert.assertEquals(account1.getName(), "Alice");
    }
    
    // #Test case 12: test name length can not have more than 100 leters
    @Test
    public void testNameCanNotTooLong() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setName("AliceAliceAliceAliceAliceAliceAliceAliceAliceAlice"
                + "AliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAlice"
                + "AliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAlice"
                + "AliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAlice"
                + "AliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAliceAlice");
        Assert.assertEquals(account1.getName(), "Alice");
    }
    
    // #Test case 13: test id can not smaller than 1 and can not bigger than 99 
    @Test
    public void testRangeOfIdNumber() {
        Account account1 = new Account(1, "Alice", "alice@yahoo.com", "012345678");
        account1.setId(0);
        Assert.assertEquals(account1.getId(), 1);
        account1.setId(-5);
        Assert.assertEquals(account1.getId(), 1);
        account1.setId(100);
        Assert.assertEquals(account1.getId(), 1);
        account1.setId(15);
        Assert.assertEquals(account1.getId(), 15);
    }
    
    @AfterTest
    public void cleanup() {
        // Code to cleanup resources after all test cases have run
        accountManager.clearList();
    }
}
