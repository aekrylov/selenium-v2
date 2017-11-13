package com.github.aekrylov.itis.sem05.selenium;

import com.github.aekrylov.itis.sem05.selenium.misc.AccountData;
import com.github.aekrylov.itis.sem05.selenium.misc.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/24/17 10:11 PM
 */
public class Authorization extends TestBase {

    @Test
    public void testLogin() {
        manager.accounts().login(user);
        assertTrue(manager.accounts().isLoggedIn(user));
    }

    @Test
    public void testLoginIncorrect() {
        manager.accounts().login(new AccountData("wrongUser", "wrongPassword"));
        assertFalse(manager.accounts().isLoggedIn());
    }

}
