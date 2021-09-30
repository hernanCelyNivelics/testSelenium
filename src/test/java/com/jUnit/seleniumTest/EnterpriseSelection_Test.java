package com.jUnit.seleniumTest;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.firefox.EnterpriseSelection;
import static org.junit.Assert.assertEquals;

public class EnterpriseSelection_Test {

    private WebDriver driver;
    EnterpriseSelection enterpriseSelection;

    @BeforeClass
    public void setUp() throws Exception {
        try {
//            //se asigna el driver de tipo firefox
            enterpriseSelection= new EnterpriseSelection(driver);
            driver= enterpriseSelection.testNgFirefoxConnection();
            driver.manage().window().maximize();
            enterpriseSelection.visit("https://stg.socialskin.com/comunidad/");
        } catch (Exception e) {
            throw new Exception("the configuration could not be loaded");
        }
    }
    @Test
    public void EnterpriseSelectionTest() throws Exception {
        try {
            assertEquals("¡El registro fue exitoso!", enterpriseSelection.registerUser());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }


}