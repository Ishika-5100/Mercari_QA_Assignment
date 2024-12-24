package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4jConfig;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setup() {
        Log4jConfig.info("Initializing WebDriver setup.");
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt(ConfigReader.getProperty("explicitWait", "10"))
        ));

        Log4jConfig.info("WebDriver setup completed.");
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
            Log4jConfig.info("Browser closed and WebDriver teardown completed.");
        }
    }
}
