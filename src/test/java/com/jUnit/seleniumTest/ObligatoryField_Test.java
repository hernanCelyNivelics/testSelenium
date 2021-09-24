package com.jUnit.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.ObligatoryField;

import static org.junit.Assert.*;

public class ObligatoryField_Test {

    private WebDriver driver;
    ObligatoryField obligatoryFieldTest;

    @Before
    public void setUp() throws Exception {
        try {
            obligatoryFieldTest = new ObligatoryField(driver);
            driver = obligatoryFieldTest.chromeConnection();
            driver.manage().window().maximize();
            obligatoryFieldTest.visit("https://stg.socialskin.com/comunidad/registro/");
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
            assertEquals("Los campos marcados con * son obligatorios", obligatoryFieldTest.incompleteField());
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }
}
