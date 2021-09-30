package pom.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jUnit.seleniumTest.Base;

import java.time.Duration;

public class CorrectWriteEmail extends Base {


    By incorrectFormatEmailLocator = By.cssSelector("#response>strong");
    By pageLocator = By.cssSelector("#regForm>div.tab.activo>h2");
    By buttonNextPage = By.id("nextBtn");
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
    By incompleteFields = By.xpath("//*[@id=\"adver\"]/p[2]/span");
    By closeMessageButton = By.id("closeM");

    public CorrectWriteEmail(WebDriver webDriver) {
        super(webDriver);
    }

    public String verifyCorrectEmail() {

        new WebDriverWait(driver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(pageLocator));

        if (isDisplayed(pageLocator)) {
            useVerticalScrolBar(250);
            typeInFields("test", nameLocator);
            typeInFields("test", lastNameLocator);
            typeInFields("colombia", countryLocator);
            typeInFields("sibate", cityLocator);
            typeInFields("test", emailLocator);
            typeInFields("ct12345**", passwordLocator);
            typeInFields("colombia", countryBornLocator);
            verifyDate();
            click(buttonNextPage);
            ewait(2);
            if (isDisplayed(incompleteFields)) {
                click(closeMessageButton);
                return getText(incorrectFormatEmailLocator);
            } else {
                System.out.println("Page not found");
            }
        }
        return "page not found";
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
}
