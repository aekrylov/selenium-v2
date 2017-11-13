package com.github.aekrylov.itis.sem05.selenium;

import com.github.aekrylov.itis.sem05.selenium.misc.AuthBase;
import com.github.aekrylov.itis.sem05.selenium.misc.Gist;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/31/17 10:52 PM
 */
public class SimpleGists extends AuthBase {

    @Test
    public void basicGist() {
        Gist gist = new Gist("Test gist " + now, Collections.singletonList(new Gist.GistFile(null, "Lorem ipsum " + now)));

        manager.gists().fillGist(gist);

        //hit create button
        manager.gists().pressCreateButton();

        manager.gists().wainUntil(5, ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gist-content .Details")));

        assertTrue(manager.gists().gistPresent(gist));
    }

    @Test
    public void gistWithMultipleFiles() {
        Gist gist = new Gist();
        gist.setDescription("Test gist " + now);

        gist.getFiles().add(new Gist.GistFile("file1.txt", "File1 contents " + now));
        gist.getFiles().add(new Gist.GistFile("file2.txt", "File2 contents " + now));

        manager.gists().fillGist(gist);

        manager.gists().pressCreateButton();

        assertTrue(manager.gists().gistPresent(gist));
    }
}
