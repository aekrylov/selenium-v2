package com.github.aekrylov.itis.sem05.selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 9:33 AM
 */
public class AccountHelper extends HelperBase {

    private static AccountData account = new AccountData("test879454", "ajsdbd7aolad09");

    public AccountHelper(TestManager manager) {
        super(manager);
    }

    public void login() {
        driver.get(baseUrl);

        driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();

        wainUntil(10, ExpectedConditions.titleContains("Sign in"));

        driver.switchTo().activeElement().sendKeys(account.getUsername() + Keys.TAB);
        driver.switchTo().activeElement().sendKeys(account.getPassword());
        driver.switchTo().activeElement().submit();

        wainUntil(10, ExpectedConditions.titleContains("Create a new Gist"));
    }

}
