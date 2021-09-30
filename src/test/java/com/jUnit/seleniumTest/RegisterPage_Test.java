package com.jUnit.seleniumTest;

import Record.ScreenRecorder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.chrome.RegisterPage;

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
    public void RegisterPage_Test() throws Exception {
        ScreenRecorder scr = new ScreenRecorder();
        scr.startRecording("test");
        registerPageSucces.registerUser();
        System.out.println(registerPageSucces.registerMessage());
        System.out.println("Test Regristro completado");
        scr.stopRecording();
    }
}
