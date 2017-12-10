package com.github.aekrylov.itis.sem05.selenium.misc;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * By Anton Krylov (anthony.kryloff@gmail.com)
 * Date: 12/10/17 10:59 PM
 */
public class Generator {

    private static Random random = new Random();

    public static void main(String[] args) throws IOException {
        String what = args[0];
        int count = Integer.parseInt(args[1]);

        String outputFile = args[2];

        Object[] data;

        switch (what) {
            case "account":
                data = loop(count, Generator::generateAccountData);
                break;
            case "gist_simple":
                data = loop(count, Generator::generateSimpleGist);
                break;
            case "gist":
                data = loop(count, Generator::generateGist);
                break;
            default:
                data = new Object[0];
                break;
        }

        DataHelper.writeJson(Paths.get(outputFile), data);
    }

    private static <T> Object[] loop(int count, Supplier<T> supplier) {
        List<T> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(supplier.get());
        }

        return data.toArray();
    }

    private static AccountData generateAccountData() {
        return new AccountData(TestBase.randomString(8), TestBase.randomString(12));
    }

    private static Gist generateSimpleGist() {
        return new Gist(TestBase.randomString(24), Collections.singletonList(generateGistFile()));
    }

    private static Gist generateGist() {
        int numFiles = 1 + random.nextInt(5);
        Gist gist = new Gist();
        gist.setDescription(TestBase.randomString(24));
        for (int i = 0; i < numFiles; i++) {
            gist.getFiles().add(generateGistFile());
        }

        return gist;
    }

    private static Gist.GistFile generateGistFile() {
        return new Gist.GistFile(TestBase.randomString(8), TestBase.randomString(64));
    }
}
