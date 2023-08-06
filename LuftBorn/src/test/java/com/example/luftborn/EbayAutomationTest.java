package com.example.luftborn;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EbayAutomationTest {
    private WebDriver driver;
    private EbayMainPage mainPage;
    private EbaySearchResultsPage resultsPage;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainPage = new EbayMainPage(driver);
        resultsPage = new EbaySearchResultsPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }


    @Test(priority = 1)
    public void testEbaySearch() {
        mainPage.open();
        assert mainPage.isLoaded();
    }

    @Test(priority = 2)
    public void testSearchItem() {
      //  mainPage.open();
        mainPage.searchItem("mazda mx-5");
        assert resultsPage.validateResults();
    }

    @Test(priority = 3)
    public void testGetResultsCount() {
       // mainPage.open();
       // mainPage.searchItem("mazda mx-5");
        assert resultsPage.getNumberOfResults() > 0;
    }

    @Test(priority = 4)
    public void testFilterByTransmission() {
        //mainPage.open();
        //mainPage.searchItem("mazda mx-5");
        resultsPage.filterByTransmission("Manual");
        assert resultsPage.validateResults();
    }
}