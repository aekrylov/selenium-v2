package com.github.aekrylov.itis.sem05.selenium.misc;

import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 11:40 AM
 */
public class NavigationHelper extends HelperBase {

    protected final String baseUrl;

    public NavigationHelper(TestManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void goHome() {
        driver.navigate().to(baseUrl);
    }

    public void waitUntilHome(int seconds) {
        wainUntil(seconds, urlToBe(baseUrl));
    }
}
