package com.jUnit.seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {

    //se instancia una objeto de tipo webdriver para asignar el tipo de driver
    private WebDriver webDriver;
    JavascriptExecutor js;
    private static final String CHROME_DRIVER_URL = "src/test/resources/chromeDriver/chromedriver.exe";
    private static final String PROPERTY_DRIVER = "webdriver.chrome.driver";
    private static final String FIREFOX_PROPERTY_DRIVER = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_URL = "src/test/resources/geckodriver.exe";
    private static final String TESTNG_FIREFOX_DRIVER_URL = "D:\\Spring boot\\TestSeleniumJunit\\testSelenium\\src\\test\\resources\\geckodriver.exe";

    public Base(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver chromeConnection() {
        //se asigna el nombre del ejecutable y la ruta
        System.setProperty(PROPERTY_DRIVER, CHROME_DRIVER_URL);
        //se asigna el driver de tipo chrome
        webDriver = new ChromeDriver();
        return webDriver;
    }
    public WebDriver firefoxConnection(){
        System.setProperty(FIREFOX_PROPERTY_DRIVER, FIREFOX_DRIVER_URL);
        //se asigna el driver de tipo chrome
        webDriver = new FirefoxDriver();
        return webDriver;
    }
    public WebDriver testNgFirefoxConnection(){
        System.setProperty(FIREFOX_PROPERTY_DRIVER, TESTNG_FIREFOX_DRIVER_URL);
        //se asigna el driver de tipo chrome
        webDriver = new FirefoxDriver();
        return webDriver;
    }
    public JavascriptExecutor initJs() {
        js = (JavascriptExecutor) webDriver;
        return js;
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
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

    public void clickDate(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().build().perform();
    }

    public void selectDay(String date) {
        List<WebElement> rows, cols;
        rows = findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("td"));
            for (WebElement col : cols) {
                String caldt = col.getText();
                if (caldt.equals(date)) {
                    col.click();
                }
            }
        }
    }

    public void useVerticalScrolBar(int num) {
        initJs().executeScript("window.scrollBy(0," + num + ")", "");
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void selectCheckBox(String element) {
        initJs().executeScript("document.getElementById('" + element + "').checked = true");
    }

    public WebDriver driver() {
        return this.webDriver;
    }

    public void ewait(int time) {
        new WebDriverWait(webDriver, Duration.ofSeconds(time));
    }

    public void waitForElementToAppear(int timeWait, int pollingTime, By elementSearch) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(timeWait))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        fwait.until(ExpectedConditions.visibilityOfElementLocated(elementSearch));
    }
    public void waitForElementToClickeable(int timeWait, int pollingTime, By elementSearch) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(timeWait))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        fwait.until(ExpectedConditions.elementToBeClickable(elementSearch));
    }
}
