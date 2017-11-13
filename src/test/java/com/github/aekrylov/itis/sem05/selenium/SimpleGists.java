package com.github.aekrylov.itis.sem05.selenium;

import com.github.aekrylov.itis.sem05.selenium.misc.Gist;
import com.github.aekrylov.itis.sem05.selenium.misc.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/31/17 10:52 PM
 */
public class SimpleGists extends TestBase {

    @Test
    public void basicGist() {
        Gist gist = new Gist("Test gist " + now, Collections.singletonList(new Gist.GistFile(null, "Lorem ipsum " + now)));

        manager.accounts().login();

        manager.gists().fillGist(gist);

        //hit create button
        manager.gists().pressCreateButton();

        manager.gists().wainUntil(5, ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gist-content .Details")));

        assertEquals(gist.getDescription(), driver.findElement(By.cssSelector(".gist-content .Details")).getText().trim());
        assertEquals(gist.getFiles().get(0).getFileContents(), driver.findElement(By.cssSelector(".data")).getText().trim());
    }

    @Test
    public void gistWithMultipleFiles() {
        manager.accounts().login();

        Gist gist = new Gist();
        gist.setDescription("Test gist " + now);

        gist.getFiles().add(new Gist.GistFile("file1.txt", "File1 contents " + now));
        gist.getFiles().add(new Gist.GistFile("file2.txt", "File2 contents " + now));

        manager.gists().fillGist(gist);

        manager.gists().pressCreateButton();

        //todo asserts
    }
}
