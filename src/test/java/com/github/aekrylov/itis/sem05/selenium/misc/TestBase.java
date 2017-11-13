package com.github.aekrylov.itis.sem05.selenium.misc;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/30/17 9:37 AM
 */
public class TestBase {

    protected static AccountData user = new AccountData("test879454", "ajsdbd7aolad09");

    protected TestManager manager;

    protected long now;

    @Before
    public void setUp() throws Exception {
        manager = new TestManager();

        now = System.currentTimeMillis();
    }

}
