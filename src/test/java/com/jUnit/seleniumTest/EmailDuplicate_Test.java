package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pom.chrome.VerifyEmailDuplicate;

import static org.junit.Assert.assertEquals;

public class EmailDuplicate_Test {

    WebDriver driver;
    VerifyEmailDuplicate verifyEmailDuplicate;

    @Before
    public void setUp() throws Exception {
        try {
            verifyEmailDuplicate = new VerifyEmailDuplicate(driver);
            driver = verifyEmailDuplicate.chromeConnection();
            driver.manage().window().maximize();
            verifyEmailDuplicate.visit("https://stg.socialskin.com/comunidad/registro/");
        } catch (Exception e) {
            throw new Exception("the configuration could not be loaded");
        }
    }

    @Test
    public void veriyEmailDuplicate() {
        assertEquals("Este correo ya se encuentra registrado", verifyEmailDuplicate.registerUser());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}