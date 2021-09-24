package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyEmailDuplicate extends Base {
    By emailLocator = By.id("email01");
    By passwordLocator = By.id("password-register");
    By nameLocator = By.id("sktab1_first_name");
    By errorEmail = By.xpath("//*[@id=\"adver-5\"]/p[2]");

    public VerifyEmailDuplicate(WebDriver webDriver) {
        super(webDriver);
    }

    public String registerUser() {

        if (isDisplayed(nameLocator)) {
            useVerticalScrolBar(250);
            typeInFields("test@mail.com", emailLocator);
            click(passwordLocator);

            if (verifyEmailDuplicate()) {
                return getText(errorEmail);
            }
        } else {
            System.out.println("Page not found");
        }
        return "El email no existe";
    }

    public boolean verifyEmailDuplicate() {
        waitForElementToAppear(10,2,errorEmail);
        if (isDisplayed(errorEmail)) {
            System.out.println("Ingrese un correo diferente");
            return true;
        }
        return false;
    }

}
