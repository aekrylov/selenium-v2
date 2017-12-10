package com.github.aekrylov.itis.sem05.selenium.misc;

import org.junit.Before;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 10/30/17 9:37 AM
 */
public class TestBase {

    protected TestManager manager;

    protected long now;

    @Before
    public void setUp() throws Exception {
        manager = TestManager.getInstance();
        now = System.currentTimeMillis();

        manager.nav().goHome();
    }

    public static String randomString(int len) {
        Random random = new Random();
        return IntStream.range(0, len)
                .mapToObj(i -> String.valueOf(((char) ('a' + random.nextInt('z' - 'a')))))
                .collect(Collectors.joining());
    }

}
