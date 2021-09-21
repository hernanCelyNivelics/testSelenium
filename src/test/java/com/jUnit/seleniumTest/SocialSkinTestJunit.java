package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.InterestPage;
import pom.RegisterPage;


public class SocialSkinTestJunit {

    private WebDriver driver;
    RegisterPage registerPage;
    InterestPage interestPage;

    @Before
    public void setUp() throws Exception {
        registerPage = new RegisterPage(driver);
        interestPage = new InterestPage(driver);
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
//        System.out.println("test completado pagina datos usuario");
    }
//    @Test
//    public void testInterestPage() throws InterruptedException {
//        System.out.println("test completado pagina intereses");
//    }
}
