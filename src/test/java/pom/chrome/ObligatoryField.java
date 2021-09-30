package pom.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jUnit.seleniumTest.Base;

import java.time.Duration;

public class ObligatoryField extends Base {

    // se crean localizadores en base a ID-xpath-o clases
    By pageLocator = By.cssSelector("#regForm>div.tab.activo>h2");
    By buttonNextPage = By.id("nextBtn");
    By incompleteFields = By.xpath("//*[@id=\"adver\"]/p[2]/span");
    By nameLocator = By.id("sktab1_first_name");

    public ObligatoryField(WebDriver webDriver) {
        super(webDriver);
    }

    public String incompleteField() {
        waitForElementToAppear(5, 1, pageLocator);
        if (isDisplayed(pageLocator)) {
            useVerticalScrolBar(250);
            typeInFields("test", nameLocator);
            new WebDriverWait(driver(), Duration.ofSeconds(2));
            click(buttonNextPage);
            if (incompleteFieldMessage()) {
                return getText(incompleteFields);
            } else {
                System.out.println("Field not localized ");
            }
        } else {
            System.out.println("Locator not displayed");
        }
        return "Page not found ";
    }

    public boolean incompleteFieldMessage() {
        waitForElementToAppear(5, 1, incompleteFields);
        return isDisplayed(incompleteFields);
    }

}
