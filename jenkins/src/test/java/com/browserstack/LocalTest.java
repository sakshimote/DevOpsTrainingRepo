package com.browserstack;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertTrue;

public class LocalTest extends BrowserStackJUnitTest {

    @Test
    public void test() throws URISyntaxException, IOException {
        try {
            driver.get("http://bs-local.com:45454/");

            assertTrue(driver.getTitle().contains("BrowserStack Local"));
            mark(driver, "passed", "Local content validated!");

        } catch (Throwable t) {
            mark(driver, "failed", "Local content not validated!");
            System.out.println("Exception: " + t);
        }
    }
}
