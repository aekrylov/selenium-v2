package com.github.aekrylov.itis.sem05.selenium.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 9:24 AM
 */
public class TestManager {

    private final WebDriver driver;
    private final AccountHelper accounts;
    private final GistHelper gists;
    private final NavigationHelper nav;

    private static final TestManager instance = new TestManager();

    protected final Properties props = DataHelper.read("app.properties");

    public static TestManager getInstance() {
        return instance;
    }

    private TestManager() {
        System.setProperty("webdriver.gecko.driver","/home/anth/prog/lib/selenium/geckodriver"); // TODO

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        String baseUrl = props.getProperty("base.url");

        accounts = new AccountHelper(this);
        gists = new GistHelper(this);
        nav = new NavigationHelper(this, baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AccountHelper accounts() {
        return accounts;
    }

    public GistHelper gists() {
        return gists;
    }

    public NavigationHelper nav() {
        return nav;
    }
}
