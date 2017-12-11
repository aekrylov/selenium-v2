package com.github.aekrylov.itis.sem05.selenium;

import com.github.aekrylov.itis.sem05.selenium.misc.AuthBase;
import com.github.aekrylov.itis.sem05.selenium.misc.DataHelper;
import com.github.aekrylov.itis.sem05.selenium.misc.Gist;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/31/17 10:52 PM
 */
public class SimpleGists extends AuthBase {

    private static Gist[] gists = DataHelper.readJson("gists.json", Gist[].class);

    @DataProvider
    public static Object[][] getGists() {

        Gist[][] res = new Gist[gists.length][1];
        for (int i = 0; i < gists.length; i++) {
            res[i] = new Gist[]{gists[i]};
        }
        return res;
    }

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
    @UseDataProvider("getGists")
    public void gistWithMultipleFiles(Gist gist) {

        manager.gists().fillGist(gist);

        manager.gists().pressCreateButton();

        assertTrue(manager.gists().gistPresent(gist));
    }
}
