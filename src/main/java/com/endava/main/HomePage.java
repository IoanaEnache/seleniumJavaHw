package com.endava.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ienache on 8/3/2016.
 */
public class HomePage {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@data-category='bath-body']")
    private WebElement ingrijireCorpTab;

    public IngrijireCorpPage ingrijireCorp(){
        ingrijireCorpTab.click();

        IngrijireCorpPage ingrijireCorpPage = PageFactory.initElements(webDriver, IngrijireCorpPage.class);
        ingrijireCorpPage.waitForPage();
        return ingrijireCorpPage;
    }

}
