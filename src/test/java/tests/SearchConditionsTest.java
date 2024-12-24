package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MercariTopPage;
import pages.SearchPage;
import pages.ResultPage;
import utilities.Log4jConfig;

import java.time.Duration;

public class SearchConditionsTest extends BaseTest {
    private MercariTopPage mercariTopPage;
    private SearchPage searchPage;
    private ResultPage resultPage;

    @BeforeClass
    public void initialize() {
        setup();
        mercariTopPage = new MercariTopPage(driver);
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
    }

    @Test
    public void testSearchConditions() {
        Log4jConfig.info("Starting test: testSearchConditions");
        mercariTopPage.openPage(ConfigReader.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mercariTopPage.clickLanguageButton();
        mercariTopPage.clickEnglishRadioButton();
        mercariTopPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mercariTopPage.clickSearchBar();
        mercariTopPage.clickCategorySearch();
        searchPage.selectTier1Category();
        searchPage.selectTier2Category();
        searchPage.selectTier3Category();

        Log4jConfig.info("Verifying search conditions on the sidebar.");

        Assert.assertEquals(resultPage.getTier1CategoryText(), "Books, Magazines, Manga");
        Log4jConfig.info("Tier 1 category verified successfully: Books, Magazines, Manga");

        Assert.assertEquals(resultPage.getTier2CategoryText(), "Book");
        Log4jConfig.info("Tier 2 category verified successfully: Book");

        Assert.assertTrue(resultPage.getTier3Category());
        Log4jConfig.info("Tier 3 category verified successfully: Computer It");

        Log4jConfig.info("All search conditions are set correctly.");
    }

    @AfterClass
    public void cleanup() {
        teardown();
    }
}
