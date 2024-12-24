package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4jConfig;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MercariTopPage {
    private WebDriver driver;

    public MercariTopPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBar = By.xpath("//input[@placeholder=\"Looking for something?\"]");
    private By categorySearch = By.xpath("//a[@href='/en/categories']/p[text()='Search by category']");
    private By languageButton = By.xpath("(//div[@class=\"merButton tertiary__01a6ef84 small__01a6ef84\"])[1]");
    private By englishRadioButton = By.xpath("//input[@aria-label=\"English - EN\"]");
    private By submitLanguageChange = By.xpath("//button[@type=\"submit\"]");
    private By latestBrowsingHistory = By.xpath("(//div[@class=\"content__884ec505\"])[3]");
    private By searchHistoryItems = By.xpath("//section[@data-testid=\"search-history\"]/div[@role=\"list\"]/div[@data-testid=\"merListItem-container\"]/div[@class=\"content__884ec505\"]/a/p");


    public void openPage(String url) {
        driver.get(url);
        Log4jConfig.info("Opened URL: " + url);
    }

    public void clickLanguageButton() {
        driver.findElement(languageButton).click();
        Log4jConfig.info("Clicked on the language button.");
    }

    public void clickEnglishRadioButton() {
        driver.findElement(englishRadioButton).click();
        Log4jConfig.info("Clicked on the radio button to select english language.");
    }

    public void clickSubmitButton() {
        driver.findElement(submitLanguageChange).click();
        Log4jConfig.info("Clicked on the submit.");
    }

    public void clickSearchBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBarElement = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBarElement.click();
        Log4jConfig.info("Clicked on the search bar.");
    }
    public void SearchBarEnterText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBarElement = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBarElement.sendKeys(text);
        searchBarElement.submit();
        Log4jConfig.info("Entered value in the search bar.");
    }

    public void clickCategorySearch() {
        driver.findElement(categorySearch).click();
        Log4jConfig.info("Clicked on 'Select by category'.");
    }

    public int itemsOfBrowsingHistory(){
        List<WebElement> historyItems = driver.findElements(searchHistoryItems);
        int itemCount = historyItems.size();
        return itemCount;
    }
    public List itemTextOfBrowsingHistory(){
        List<WebElement> historyItems = driver.findElements(searchHistoryItems);
        List<String> listOfHistoryItems = new ArrayList<>();
        for (WebElement historyitem: historyItems
             ) {

            String browsingHistoryItem = historyitem.getText();
            listOfHistoryItems.add(browsingHistoryItem);
        }
        return listOfHistoryItems;
    }

    public String getLatestBrowsingHistoryItemText(){
        String browsingHistoryItem = driver.findElement(latestBrowsingHistory).getText();
        return browsingHistoryItem;
    }


}
