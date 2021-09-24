package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


import java.time.Duration;
import java.util.List;

public class RegisterPage extends Base {

    WebDriverWait wait;
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
    String PROJECT_SEARCH_LOCATOR = "busc_invetirP";
    String NETWORK_SEARCH_LOCATOR = "busc_networking";
    String MENTORY_SEARCH_LOCATOR = "bus_recibir";
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
    By registerDone = By.xpath("//*[@id=\"eModal-2\"]/div/div/h3/span");


    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void registerUser() throws InterruptedException {

        click(buttonRegister);
        wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        if (isDisplayed(nameLocator)) {
            useVerticalScrolBar(250);
            typeInFields("test", nameLocator);
            typeInFields("test", lastNameLocator);
            typeInFields("colombia", countryLocator);
            typeInFields("sibate", cityLocator);
            typeInFields("test"+Math.random()+"@mail.com", emailLocator);
            typeInFields("ct12345**", passwordLocator);
            ewait(2);
            if (isDisplayed(errorEmail)) {
                System.out.println("ingrese un correo diferente");
            } else {
                verifyDate();
                typeInFields("colombia", countryBornLocator);
                click(buttonNextPage);
                interestPage();
                ewait(2);
                if (registerMessage()) {
                    System.out.println("el registro se realizo correctamente");
                } else {
                    System.out.println("No registered");
                }
            }
        }
    }


    public boolean registerMessage() {
        if (isDisplayed(registerDone)) {
            List<WebElement> span = findElements(By.tagName("span"));
            assertEquals("¡El registro fue exitoso!", span.get(24).getText());
            return true;
        } else {
            return false;
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
        ewait(2);
        if (isDisplayed(interestPageLocator)) {
            //useVerticalScrolBar(180);
            ewait(1);
            click(profileLocator);
            selectMentory();
            selectCategory();
            acceptTerms();
        } else {
            System.out.println("page not found");
        }
    }

    public void selectMentory(){
        tab(searchLocator);
        selectCheckBox(PROJECT_SEARCH_LOCATOR);
        selectCheckBox(NETWORK_SEARCH_LOCATOR);
        selectCheckBox(MENTORY_SEARCH_LOCATOR);
    }

    public void selectCategory(){
        tab(justiceCategoryLocator);
        selectCheckBox(JUSTICE_CATEGORY_LOCATOR);
        selectCheckBox(HEALTH_CATEGORY_LOCATOR);
        selectCheckBox(CITY_CATEGORY_LOCATOR);
    }

    public void acceptTerms() throws InterruptedException {
        selectCheckBox(CHECK_BOX_TERM);
        selectCheckBox(CHECK_BOX_P);
        selectCheckBox(CHECK_BOX_Z);
        scrollIntoView(findElement(button_register));
        Thread.sleep(1000);
        click(button_register);
    }

}
