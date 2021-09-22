package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.List;

public class RegisterPage extends Base {


    By buttonRegister = By.cssSelector("a.psf-login__link--register");
    By nameLocator = By.id("sktab1_first_name");
    By lastNameLocator = By.id("sktab1_last_name");
    By countryLocator = By.id("sktab1_country");
    By cityLocator = By.id("sktab1_city");
    By emailLocator = By.id("email01");
    By passwordLocator = By.id("password-register");
    By dateLocator = By.cssSelector("input#date");
    By countryBornLocator = By.id("sktab1_born");
    By selectYear = By.xpath("/html/body/div[16]/div/div/select/option[1]");
    By dateYearLocator = By.cssSelector("select.ui-datepicker-year");
    By errorEmail = By.xpath("//*[@id=\"adver-5\"]/p[2]");
    //locators interest page
    By buttonNextPage = By.id("nextBtn");
    By interestPageLocator = By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/article/form/div[2]/h2");
    By profileLocator = By.id("profile_volun");
    String proyectSearchLocator = "busc_invetirP";
    String networkSearchLocator = "busc_networking";
    String mentoriySearchLocator = "bus_recibir";
    String HEALTH_CATEGORY_LOCATOR = "ctg_saludBienestar";
    String CITY_CATEGORY_LOCATOR = "ctg_ciudadesCo";
    String JUSTICE_CATEGORY_LOCATOR = "ctg_transparenciaJ";
    By justiceCategoryLocator = By.id("ctg_transparenciaJ");
    By searchLocator = By.xpath("//*[@id=\"bus_mentor\"]");
    //locator accept terms
    By button_register = By.id("nextBtn");
    String CHECK_BOX_TERM = "check_AceptoT";
    String CHECK_BOX_P = "check_AceptoP";
    String CHECK_BOX_Z = "check_autoriz";


    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void registerUser() throws InterruptedException {
        click(buttonRegister);
        Thread.sleep(2000);
        if (isDisplayed(nameLocator)) {
            useVerticalScrolBar(250);
            typeInFields("test", nameLocator);
            typeInFields("test", lastNameLocator);
            typeInFields("colombia", countryLocator);
            typeInFields("sibate", cityLocator);
            typeInFields("test@mail.com", emailLocator);
            typeInFields("ct12345**", passwordLocator);
            Thread.sleep(2000);
            if (isDisplayed(errorEmail)){
                System.out.println("ingrese un correo diferente");
            }else{
                verifyDate();
                typeInFields("colombia", countryBornLocator);
                click(buttonNextPage);

                interestPage();
            }
        } else {
            System.out.println("No registered");
        }


    }

    public void verifyDate() {
        clickDate(findElement(dateLocator));
        if (isDisplayed(dateYearLocator)) {
            click(selectYear);
            selectDay("20");
        } else {
            System.out.println("Date no click");
        }
    }
//test interest page

    public void interestPage() throws InterruptedException {
        Thread.sleep(2000);
        if (isDisplayed(interestPageLocator)) {
            //useVerticalScrolBar(180);
            Thread.sleep(1000);
            click(profileLocator);
            selectMentory();
            selectCategory();
            acceptTerms();

        } else {
            System.out.println("page not found");
        }
    }

    public void selectMentory() throws InterruptedException {
        tab(searchLocator);
        selectCheckBox(proyectSearchLocator);
        selectCheckBox(networkSearchLocator);
        selectCheckBox(mentoriySearchLocator);
    }

    public void selectCategory() throws InterruptedException {
        tab(justiceCategoryLocator);
        selectCheckBox(JUSTICE_CATEGORY_LOCATOR);
        selectCheckBox(HEALTH_CATEGORY_LOCATOR);
        selectCheckBox(CITY_CATEGORY_LOCATOR);
    }

    public void acceptTerms() throws InterruptedException {
        tab(button_register);

        selectCheckBox(CHECK_BOX_TERM);
        selectCheckBox(CHECK_BOX_P);
        selectCheckBox(CHECK_BOX_Z);
        Thread.sleep(500);
        click(button_register);
    }


//    public void registeredMessage(){
//
//    }
}
