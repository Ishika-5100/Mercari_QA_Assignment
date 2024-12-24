package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selectedTier1Category = By.xpath("//option[@value='5' and text()='Books, Magazines, Manga']");
    private By selectedTier2Category = By.xpath("//option[@value='72' and text()='Book']");
    private By selectedTier3Category = By.xpath("//input[@type='checkbox' and @name='category_id' and @value='674' and @aria-checked='true']");
    private By mercariLogo = By.xpath("//*[local-name()='svg' and @role='img' and @viewBox='0 0 182 49']");

    public String getTier1CategoryText() {
        String str1 = driver.findElement(selectedTier1Category).getText();
        return str1;
    }

    public String getTier2CategoryText() {
        String str2 = driver.findElement(selectedTier2Category).getText();
        return str2;
    }

    public boolean getTier3Category() {
        boolean str3 = driver.findElement(selectedTier3Category).isSelected();
        return str3;
    }

    public void clickMercariLogo(){
        driver.findElement(mercariLogo).click();
    }

}
