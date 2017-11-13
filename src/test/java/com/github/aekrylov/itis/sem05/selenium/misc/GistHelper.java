package com.github.aekrylov.itis.sem05.selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 11/13/17 9:35 AM
 */
public class GistHelper extends HelperBase {
    public GistHelper(TestManager manager) {
        super(manager);
    }

    public void fillGist(Gist gist) {
        driver.findElement(By.xpath("//input[contains(@placeholder, 'description')]")).sendKeys(gist.getDescription());
        for (int i = 1; i < gist.getFiles().size(); i++) {
            addGistFile();
        }

        List<WebElement> elements = driver.findElements(By.cssSelector(".file.js-code-editor"));

        List<Gist.GistFile> files = gist.getFiles();
        for (int i = 0; i < files.size(); i++) {
            Gist.GistFile file = files.get(i);
            fillGistFile(file, elements.get(i));
        }
    }

    public void addGistFile() {
        wainUntil(5, ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Add file')]")));
        driver.findElement(By.xpath("//button[contains(text(), 'Add file')]")).click();
    }

    public void fillGistFile(Gist.GistFile file, WebElement el) {
        WebElement elFileName = el.findElement(By.xpath(".//input[contains(@placeholder, 'Filename')]"));

        if(file.filename != null)
            elFileName.sendKeys(file.filename);

        el.findElement(By.cssSelector(".commit-create pre")).click();
        driver.switchTo().activeElement().sendKeys(file.fileContents);
    }

    public void pressCreateButton() {
        driver.findElement(By.xpath("//*[contains(text(), 'Create secret gist')]")).click();
    }

}
