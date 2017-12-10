package com.github.aekrylov.itis.sem05.selenium;

import com.github.aekrylov.itis.sem05.selenium.misc.AccountData;
import com.github.aekrylov.itis.sem05.selenium.misc.DataHelper;
import com.github.aekrylov.itis.sem05.selenium.misc.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/24/17 10:11 PM
 */
public class Authorization extends TestBase {

    protected static Properties authProperties = DataHelper.read("auth.properties");

    protected static AccountData user = new AccountData(
            authProperties.getProperty("username"),
            authProperties.getProperty("password")
    );

    @Before
    public void logoutBefore() {
        manager.accounts().logout();
    }

    @Test
    public void testLogin() {
        manager.accounts().login(user);
        manager.nav().waitUntilHome(5);
        assertTrue(manager.accounts().isLoggedIn(user));
    }

    @Test
    public void testLoginIncorrect() {
        manager.accounts().login(new AccountData("wrongUser", "wrongPassword"));
        assertFalse(manager.accounts().isLoggedIn());
    }

    @Test
    public void testLogout() {
        manager.accounts().login(user);
        manager.nav().goHome();
        manager.accounts().logout();
        assertFalse(manager.accounts().isLoggedIn());
    }

}
