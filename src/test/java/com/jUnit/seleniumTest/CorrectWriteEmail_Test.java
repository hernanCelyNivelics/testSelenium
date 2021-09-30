package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.chrome.CorrectWriteEmail;

import static org.junit.Assert.assertEquals;

public class CorrectWriteEmail_Test {

    private WebDriver driver;
    CorrectWriteEmail correctWriteEmail;

    @Before
    public void setUp() throws Exception {
        try {
            correctWriteEmail = new CorrectWriteEmail(driver);
            driver = correctWriteEmail.chromeConnection();
            driver.manage().window().maximize();
            correctWriteEmail.visit("https://stg.socialskin.com/comunidad/registro/");
        } catch (Exception e) {
            throw new Exception("the configuration could not be loaded");
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void obligatoryFieldTest() throws Exception {
        try {
            assertEquals("El formato del correo es incorrecto", correctWriteEmail.verifyCorrectEmail());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
