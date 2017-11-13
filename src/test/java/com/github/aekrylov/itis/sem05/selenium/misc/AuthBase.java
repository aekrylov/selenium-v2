package com.github.aekrylov.itis.sem05.selenium.misc;

import org.junit.After;
import org.junit.Before;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 10:54 AM
 */
public class AuthBase extends TestBase {

    @Before
    public void setUpLogin() {
        manager.accounts().login(user);
    }

    @After
    public void tearDownLogin() {
        manager.accounts().logout();
    }
}
