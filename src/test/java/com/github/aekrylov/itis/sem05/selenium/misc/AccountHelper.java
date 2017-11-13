package com.github.aekrylov.itis.sem05.selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 9:33 AM
 */
public class AccountHelper extends HelperBase {

    public AccountHelper(TestManager manager) {
        super(manager);
    }

    public void login(AccountData account) {
        if (isLoggedIn())
            return;

        driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();

        wainUntil(10, ExpectedConditions.titleContains("Sign in"));

        driver.switchTo().activeElement().sendKeys(account.getUsername() + Keys.TAB);
        driver.switchTo().activeElement().sendKeys(account.getPassword());
        driver.switchTo().activeElement().submit();

        wainUntil(10, ExpectedConditions.titleContains("Create a new Gist"));
    }

    public boolean isLoggedIn() {
        return driver.findElements(By.cssSelector(".header-nav-current-user strong")).size() > 0;
    }

    public boolean isLoggedIn(AccountData user) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".header-nav-current-user strong"));
        return elements.size() > 0 && elements.get(0)
                .getText().equals(user.getUsername());
    }

    /**
     * Logs out from current session. If user is not logged in, then does nothing
     *
     * @return true if user was logged in
     */
    public boolean logout() {
        if(!isLoggedIn())
            return false;

        driver.findElement(By.cssSelector(".btn-link.HeaderNavlink.name")).click();
        driver.findElement(By.cssSelector("button.dropdown-signout")).click();

        wainUntil(10, presenceOfElementLocated(By.xpath("//*[contains(text(), 'Are you sure you want to sign out?')]")));
        driver.findElement(By.cssSelector("input.btn")).click();
        
        wainUntil(10, urlMatches("https://github.com/"));
        return true;
    }

}
