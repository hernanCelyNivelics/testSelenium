package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.RegisterPage;

public class SocialSkinTestJunit {

    private WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void setUp() throws Exception {
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeConnection();
        driver.manage().window().maximize();
        registerPage.visit("https://stg.socialskin.com/comunidad/#");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSocialSkinPage() throws InterruptedException {
        registerPage.registerUser();
        System.out.println("completado");
    }
}
