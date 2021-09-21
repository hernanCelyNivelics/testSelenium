package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class RegisterPage extends Base{

    By buttonRegister = By.cssSelector("a.psf-login__link--register");
    By nameLocator = By.id("sktab1_first_name");
    By lastNameLocator = By.id("sktab1_last_name");
    By countryLocator = By.id("sktab1_country");
    By cityLocator = By.id("sktab1_city");
    By emailLocator = By.id("email01");
    By passwordLocator = By.id("password-register");
    By dateLocator = By.cssSelector("input#date");
    By countryBornLocator = By.id("sktab1_born");

    By dateYearLocator = By.cssSelector("select.ui-datepicker-year");

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void registerUser() throws InterruptedException {
        click(buttonRegister);
        Thread.sleep(2000);
        if (isDisplayed(nameLocator)){
            typeInFields("test",nameLocator);
            typeInFields("test",lastNameLocator);
            typeInFields("colombia",countryLocator);
            typeInFields("sibate",cityLocator);
            typeInFields("test@mail.com",emailLocator);
            typeInFields("ct12345**",passwordLocator);

            verifyDate();
            typeInFields("colombia",countryBornLocator);

        }else{
            System.out.println("No registered");
        }
    }
    public void verifyDate(){
        click(dateLocator);
        if (isDisplayed(dateLocator)){
            System.out.println(getText(dateLocator));
        }else{
            System.out.println("date no click");
        }
    }
//    public void registeredMessage(){
//
//    }
}
