package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Log4jConfig;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tier1Category = By.xpath("//a[@href='/en/categories?category_id=5' and @data-location='categories:category_list:category_transition_row' and @location-2='category_transition_row' and text()='Books, Magazines, Manga']");
    private By tier2Category = By.xpath("//a[@href='/en/categories?category_id=72' and text()='Book']");
    private By tier3Category = By.xpath("//a[@href='/en/search?category_id=674' and text()='Computer It']");
    private By tier3Category_Entertainment = By.xpath("//a[@href='/en/search?category_id=10104' and text()='Entertainment']");

    public void selectTier1Category() {
        driver.findElement(tier1Category).click();
        Log4jConfig.info("Selected Tier 1 category");
    }

    public void selectTier2Category() {
        driver.findElement(tier2Category).click();
        Log4jConfig.info("Selected Tier 2 category");
    }

    public void selectTier3Category() {
        driver.findElement(tier3Category).click();
        Log4jConfig.info("Selected Tier 3 category");
    }

    public void selectTier3Category_Entertainment() {
        driver.findElement(tier3Category_Entertainment).click();
        Log4jConfig.info("Selected Tier 3 category as Entertainment");
    }

}
