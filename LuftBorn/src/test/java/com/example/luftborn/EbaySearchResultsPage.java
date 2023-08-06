package com.example.luftborn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbaySearchResultsPage {
    private WebDriver driver;

    public EbaySearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateResults() {
        return driver.getPageSource().toLowerCase().contains("results for");
    }

    public int getNumberOfResults() {
//        String resultCountText = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1/span[1]")).getText();
        String resultCountText = driver.findElement(By.xpath("//h1[contains(text(),'results for')]")).getText();
        System.out.println(resultCountText);
        return Integer.parseInt(resultCountText.split(" ")[0]);

//        return Integer.parseInt(resultCountText);
    }

    public void filterByTransmission(String transmission) {
        driver.findElement(By.xpath("//*[@id=\"s0-53-17-6-3-4[0]-3-2-1-list\"]/li[1]/div/a")).click();
//        driver.findElement(By.xpath(String.format("//span[text()='%s']", transmission))).click();
    }
}