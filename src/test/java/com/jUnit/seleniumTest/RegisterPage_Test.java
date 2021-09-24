package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.RegisterPage;

import static org.junit.Assert.*;

public class RegisterPage_Test {

    private WebDriver driver;
    RegisterPage registerPageSucces;

    @Before
    public void setUp() throws Exception {
        try {
            registerPageSucces = new RegisterPage(driver);
            driver = registerPageSucces.chromeConnection();
            driver.manage().window().maximize();
            registerPageSucces.visit("https://stg.socialskin.com/comunidad/");
        } catch (Exception e) {
            throw new Exception("the configuration could not be loaded");
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testSocialSkinPage() throws InterruptedException {
        registerPageSucces.registerUser();
        System.out.println(registerPageSucces.registerMessage());
        System.out.println("Test Regristro completado");
    }


}
