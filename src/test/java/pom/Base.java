package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Base {

    private WebDriver webDriver;
    private static final String CHROME_DRIVER_URL = "src/test/resources/chromeDriver/chromedriver.exe";
    private static final String PROPERTY_DRIVER = "webdriver.chrome.driver";

    public Base(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver chromeConnection() {
        System.setProperty(PROPERTY_DRIVER, CHROME_DRIVER_URL);
        webDriver = new ChromeDriver();
        return webDriver;
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return webDriver.findElement(locator).getText();
    }

    public void typeInFields(String input, By locator) {
        webDriver.findElement(locator).sendKeys(input);
    }

    public void click(By locator) {
        webDriver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return webDriver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tab(By locator) {
        webDriver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void visit(String url) {
        webDriver.get(url);
    }

    public void clickDate(WebElement element){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().build().perform();
    }
}
