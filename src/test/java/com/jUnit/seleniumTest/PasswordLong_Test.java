package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.chrome.PasswordLong;
import static org.junit.Assert.assertEquals;

public class PasswordLong_Test {

    private WebDriver driver;
    PasswordLong passwordLong;
    @Before
    public void setUp() throws Exception {
        try {
            passwordLong = new PasswordLong(driver);
            driver = passwordLong.chromeConnection();
            driver.manage().window().maximize();
            passwordLong.visit("https://stg.socialskin.com/comunidad/registro/");
        } catch (Exception e) {
            throw new Exception("the configuration could not be loaded");
        }
    }

    @After
    public void tearDown(){
        driver.close();

    }
    @Test
    public void passwordLongTest(){
        assertEquals("Debe tener al menos 8 caracteres ✕",passwordLong.writePassword());
    }
}
