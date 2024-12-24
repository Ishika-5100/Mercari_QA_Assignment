package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.MercariTopPage;
import pages.ResultPage;
import pages.SearchPage;
import utilities.Log4jConfig;

import java.time.Duration;

public class LatestBrowsingHistoryTest extends BaseTest {
    private MercariTopPage mercariTopPage;
    private SearchPage searchPage;
    private ResultPage resultPage;


    @BeforeClass
    public void initialize() {
        setup();
        mercariTopPage = new MercariTopPage(driver);
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);



        new SearchConditionsTest();
        new SearchConditionsTest();

    }

    @Test
    public void testLatestBrowsingHistory(){
        Assertion softAssert = new SoftAssert();
        Log4jConfig.info("Starting test: testLatestBrowsingHistory");

        Log4jConfig.info("Creating first browsing history");
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
        searchPage.selectTier3Category_Entertainment();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        resultPage.clickMercariLogo();

        Log4jConfig.info("Creating second browsing history");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mercariTopPage.clickSearchBar();
        mercariTopPage.clickCategorySearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        searchPage.selectTier1Category();
        searchPage.selectTier2Category();
        searchPage.selectTier3Category();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Log4jConfig.info("Going to Mercari top page");
        resultPage.clickMercariLogo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mercariTopPage.clickSearchBar();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Log4jConfig.info("Verifying 2 browsing histories");
        softAssert.assertEquals(mercariTopPage.itemsOfBrowsingHistory(),2);

        Log4jConfig.info("Verifying latest browsing history is Computer It");
        softAssert.assertEquals(mercariTopPage.itemTextOfBrowsingHistory().get(0),"Computer It");

        mercariTopPage.clickSearchBar();
        mercariTopPage.SearchBarEnterText("javascript");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        resultPage.clickMercariLogo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        Log4jConfig.info("Verifying 3 browsing histories");
        softAssert.assertEquals(mercariTopPage.itemsOfBrowsingHistory(),3);

        Log4jConfig.info("Verifying latest browsing history is javascript");
        softAssert.assertEquals(mercariTopPage.itemTextOfBrowsingHistory().get(0),"javascript");


    }
    @AfterClass
    public void cleanup() {
        teardown();
    }

}
