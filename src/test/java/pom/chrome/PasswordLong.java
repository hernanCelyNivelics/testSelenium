package pom.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jUnit.seleniumTest.Base;

import java.time.Duration;

public class PasswordLong extends Base {

    By passwordLocator = By.id("password-register");
    By pageLocator = By.cssSelector("#regForm>div.tab.activo>h2");
    By lastNameLocator = By.id("sktab1_last_name");
    By passwordShortError = By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/article/form/div[1]/div[3]/div[2]/span");

    public PasswordLong(WebDriver webDriver) {
        super(webDriver);
    }

    public String writePassword() {
        new WebDriverWait(driver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(pageLocator));
        if (isDisplayed(pageLocator)) {
            typeInFields("test", passwordLocator);
            click(lastNameLocator);
            if (isDisplayed(passwordShortError)) {
                return getText(passwordShortError);
            } else {
                System.out.println("Validation not active");
            }
        } else {
            System.out.println("Page not found");
        }
        return "Page not found";
    }
}
