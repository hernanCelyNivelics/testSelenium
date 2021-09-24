package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.VerifyEmailDuplicate;

import static org.junit.Assert.assertEquals;

public class EmailDuplicate_Test {

    private WebDriver driver;
    VerifyEmailDuplicate verifyEmailDuplicate;

    @Before
    public void setUp() throws Exception {
        try {
            verifyEmailDuplicate = new VerifyEmailDuplicate(driver);
            driver = verifyEmailDuplicate.chromeConnection();
            driver.manage().window().maximize();
            verifyEmailDuplicate.visit("https://stg.socialskin.com/comunidad/registro/");
        }catch (Exception e){
            throw  new Exception("the configuration could not be loaded");
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void veriyEmailDuplicate(){
        assertEquals("Este correo ya se encuentra registrado",verifyEmailDuplicate.registerUser());
    }
}
