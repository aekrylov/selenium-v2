package com.github.aekrylov.itis.sem05.selenium.misc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Properties;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 10:54 AM
 */
public class AuthBase extends TestBase {

    protected static Properties authProperties = DataHelper.read("auth.properties");

    protected static AccountData user = new AccountData(
            authProperties.getProperty("username"),
            authProperties.getProperty("password")
    );

    @BeforeClass
    public static void beforeClass() {
        manager.nav().goHome();
        manager.accounts().login(user);
    }

    @AfterClass
    public static void afterClass() {
        manager.accounts().logout();
    }
}
