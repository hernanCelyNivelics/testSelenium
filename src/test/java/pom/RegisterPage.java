package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

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
    //locators interest page
    By buttonNextPage = By.id("nextBtn");
    By interestPageLocator = By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/article/form/div[2]/h2");
    By profileLocator = By.id("profile_volun");
    String proyectSearchLocator = "busc_invetirP";
    String networkSearchLocator = "busc_networking";
    String mentoriySearchLocator = "bus_recibir";
    By healthCategoryLocator = By.id("ctg_saludBienestar");
    By cityCategoryLocator = By.id("ctg_ciudadesCo");
    By justiceCategoryLocator = By.id("ctg_transparenciaJ");
    By searchLocator = By.xpath("//*[@id=\"bus_mentor\"]");

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
            verifyDate();
            typeInFields("colombia", countryBornLocator);
            interestPage();

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
        click(buttonNextPage);
        Thread.sleep(2000);
        if (isDisplayed(interestPageLocator)) {
            //useVerticalScrolBar(180);
            Thread.sleep(1000);
            click(profileLocator);
            selectMentory();
            selectCategory();
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
        selectCheckBox("ctg_impactoMedio");
        selectCheckBox("ctg_saludBienestar");
        selectCheckBox("ctg_transparenciaJ");
    }


//    public void registeredMessage(){
//
//    }
}
