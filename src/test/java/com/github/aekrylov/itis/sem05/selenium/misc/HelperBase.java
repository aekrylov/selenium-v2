package com.github.aekrylov.itis.sem05.selenium.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 9:26 AM
 */
public class HelperBase {

    protected WebDriver driver;
    protected TestManager manager;
    protected final String baseUrl = "https://gist.github.com/";


    public HelperBase(TestManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    public void wainUntil(int seconds, Function<? super WebDriver, ?> conditions) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(conditions);
    }

}
