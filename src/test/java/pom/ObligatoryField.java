package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObligatoryField extends Base {

    public ObligatoryField(WebDriver webDriver) {
        super(webDriver);
    }

    By buttonNextPage = By.id("nextBtn");
    By interestPageLocator = By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/article/form/div[2]/h2");
    By profileLocator = By.id("profile_volun");
    By proyectSearchLocator = By.id("busc_networking");
    By networkSearchLocator = By.id("busc_networking");
    By mentoriySearchLocator = By.id("bus_recibir");
    By healthCategoryLocator = By.id("ctg_saludBienestar");
    By cityCategoryLocator = By.id("ctg_ciudadesCo");
    By justiceCategoryLocator = By.id("ctg_transparenciaJ");

    public void interestPage() throws InterruptedException {
        click(buttonNextPage);
        Thread.sleep(2000);
        if (isDisplayed(interestPageLocator)) {
            useVerticalScrolBar(250);
            click(profileLocator);
            selectMentory();
            selectCategory();
        }else {
            System.out.println("page not found");
        }
    }

    public void selectMentory() {
//        click(proyectSearchLocator);
//        click(networkSearchLocator);
//        click(mentoriySearchLocator);
//        useVerticalScrolBar(250);
    }
    public void selectCategory(){
//        click(cityCategoryLocator);
//        click(justiceCategoryLocator);
//        click(healthCategoryLocator);
    }

}
