package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pom.RegisterPage;

public class SocialSkinTestJunit {

    private WebDriver driver;
    RegisterPage registerPageSucces;

    @Before
    public void setUp() {
        registerPageSucces = new RegisterPage(driver);
        driver = registerPageSucces.chromeConnection();
        driver.manage().window().maximize();
        registerPageSucces.visit("https://stg.socialskin.com/comunidad/");
    }

    @After
    public void tearDown() {
    }
//
//    @Test
//    public void testSocialSkinPage() throws InterruptedException {
//        registerPageSucces.registerUser();
//        System.out.println(registerPageSucces.registerMessage());
//        System.out.println("Test Regristro completado");
//    }


}
