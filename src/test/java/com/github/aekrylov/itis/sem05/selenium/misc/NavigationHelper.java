package com.github.aekrylov.itis.sem05.selenium.misc;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 11:40 AM
 */
public class NavigationHelper extends HelperBase {

    protected final static String baseUrl = "https://gist.github.com/";

    public NavigationHelper(TestManager manager) {
        super(manager);
    }

    public void goHome() {
        driver.navigate().to(baseUrl);
    }
}
