package com.example.luftborn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class EbayMainPage {
    private WebDriver driver;
    private String url = "https://www.ebay.com/";

    public EbayMainPage(WebDriver driver) {
        this.driver = driver;
}
    public void open() {
        driver.get(url);
    }
    public boolean isLoaded() {
        return driver.getTitle().toLowerCase().contains("ebay");
    }
    public void searchItem(String item) {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.clear();
        searchBox.sendKeys(item);
        searchBox.submit();
    }
}
