package pom.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jUnit.seleniumTest.Base;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EnterpriseSelection extends Base {

    private static final String CAD="test nivelics";
    private static final String CAD2="Probado con firefox";
    private static final String URL_VIDEO = "https://www.youtube.com/watch?v=131420WhawI";
    private static final String RANDOM_MAIL="test"+Math.random()+"@mail.com";
    private static final String REGISTER_SUCCES="¡El registro fue exitoso!";
    private static final String REGISTER_FAILED="¡Register failed";
    private static final String PAGE_NOT_FOUND="Page not found";
    private static final String COUNTRY="Colombia";
    private static final String CITY="Sibate";
    private static final String PASSWORD="abxc2154654";
    private static final String DAY="20";
    private static final String ERROR_DATE="Date could not be selected";

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
    By interestPageLocator = By.id("profile_emprendedor");
    String PROJECT_SEARCH_LOCATOR = "busc_invetirP";
    String NETWORK_SEARCH_LOCATOR = "busc_networking";
    String MENTORY_SEARCH_LOCATOR = "bus_recibir";
    String HEALTH_CATEGORY_LOCATOR = "ctg_saludBienestar";
    String CITY_CATEGORY_LOCATOR = "ctg_ciudadesCo";
    String JUSTICE_CATEGORY_LOCATOR = "ctg_transparenciaJ";
    //locator accept terms
    By button_register = By.id("nextBtn");
    By CHECK_BOX_TERM = By.id("check_AceptoT3");
    By CHECK_BOX_P = By.id("check_AceptoP3");
    String CHECK_BOX_Z = "check_autoriz";
    By registerDone = By.xpath("//*[@id=\"eModal-2\"]/div/div/h3/span");
    //project fields selectors
    By projectNameLocator = By.id("nameProject");
    By teamNameLocator = By.id("team");
    By educationCategoryLocator = By.id("cat_proyect_educacionCalidad");
    By enviromentCatergoryLocator = By.id("cat_proyect_impactoMedio");
    By countrySelectorLocator = By.xpath("//*[@id=\"rolEmpren\"]/div[5]/div[2]/div/button");
    By selectCountry = By.id("bs-select-1-0");
    By problemLocator = By.id("pp");
    By solutionLocator = By.id("sol");
    By diferenceLocator = By.id("dif");
    By videoLocator = By.id("video3m");
    By projectSiteLocator = By.id("miproyecto");
    String IMAGE_URL = "C:\\Users\\herna\\Pictures\\Saved Pictures\\descarga.jpg";
    By imageInputLocator = By.id("file-img");
    String SITE_URL = "https://stg.socialskin.com/";

    public EnterpriseSelection(WebDriver webDriver) {
        super(webDriver);
    }

    public String registerUser() {
        waitForElementToAppear(5,1,buttonRegister);
        click(buttonRegister);
        new WebDriverWait(driver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        if (isDisplayed(nameLocator)) {
            typeBasicInformation();
            click(buttonNextPage);
            interestPage();
            selectMentory();
            selectCategory();
            click(buttonNextPage);
            typeInformationProject();
            acceptTerms();
            click(button_register);
            waitForElementToAppear(5, 1, registerDone);
            if (registerMessage()) {
                    return REGISTER_SUCCES;
            } else {
                return REGISTER_FAILED;
            }
        } else {
            System.out.println(PAGE_NOT_FOUND);
            return PAGE_NOT_FOUND;
        }
    }
    //user information fields
    public void typeBasicInformation() {
        useVerticalScrolBar(250);
        typeInFields(CAD, nameLocator);
        typeInFields(CAD, lastNameLocator);
        typeInFields(COUNTRY, countryLocator);
        typeInFields(CITY, cityLocator);
        typeInFields(RANDOM_MAIL, emailLocator);
        typeInFields(PASSWORD, passwordLocator);
        selectDate();
        typeInFields(COUNTRY, countryBornLocator);
    }

    //information project fields
    public void typeInformationProject() {
        typeInFields(CAD, projectNameLocator);
        typeInFields(RANDOM_MAIL, teamNameLocator);
        typeInFields(IMAGE_URL, imageInputLocator);
        click(enviromentCatergoryLocator);
        click(educationCategoryLocator);
        click(countrySelectorLocator);
        click(selectCountry);
        click(countrySelectorLocator);
        typeInFields(CAD, problemLocator);
        typeInFields(CAD, solutionLocator);
        typeInFields(CAD2, diferenceLocator);
        typeInFields(URL_VIDEO, videoLocator);
        typeInFields(SITE_URL, projectSiteLocator);
    }

    public boolean registerMessage() {
        if (isDisplayed(registerDone)) {
            List<WebElement> span = findElements(By.tagName("span"));
            assertEquals(REGISTER_SUCCES, span.get(24).getText());
            return true;
        } else {
            return false;
        }
    }

    public void selectDate() {
        clickDate(findElement(dateLocator));
        if (isDisplayed(dateYearLocator)) {
            click(selectYear);
            selectDay(DAY);
        } else {
            System.out.println(ERROR_DATE);
        }
    }

    //select interest page
    public void interestPage() {
        if (isDisplayed(interestPageLocator)) {
            click(interestPageLocator);
        } else {
            System.out.println(PAGE_NOT_FOUND);
        }
    }
    //select mentory
    public void selectMentory() {
        selectCheckBox(PROJECT_SEARCH_LOCATOR);
        selectCheckBox(NETWORK_SEARCH_LOCATOR);
        selectCheckBox(MENTORY_SEARCH_LOCATOR);
    }

    public void selectCategory() {
        selectCheckBox(JUSTICE_CATEGORY_LOCATOR);
        selectCheckBox(HEALTH_CATEGORY_LOCATOR);
        selectCheckBox(CITY_CATEGORY_LOCATOR);
    }

    public void acceptTerms() {
        click(CHECK_BOX_P);
        click(CHECK_BOX_TERM);
        selectCheckBox(CHECK_BOX_Z);
    }
}
