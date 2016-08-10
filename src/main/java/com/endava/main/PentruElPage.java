package com.endava.main;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ienache on 8/4/2016.
 */
public class PentruElPage {

    private WebDriver webDriver;
    public PentruElPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@data-category='men']")
    private WebElement pentruElTab;

    @FindBy(xpath = "(//a[@href='/men/accessories'])[1]")
    private WebElement accessoriiTab;

    @FindBy(xpath = "//a[@href='/men/accessories/watches']")
    private WebElement ceasuriTab;

    @FindBy(xpath = "//div[2]/div/section/section/a[3]/div[2]/span[3]")
    private WebElement nameOfLastItem;

    @FindBy(xpath = "//div[2]/div/section/section/a[3]/div[2]/div[2]/span/span[1]")
    private WebElement starsOfLastItem;

    public void selectPentruElTab(){
        pentruElTab.click();
    }

    public void selectCeasuriTab(){
         ceasuriTab.click();
    }

    public void getNameOfLastItem(){
        Assert.assertEquals("Ceas pentru el Elegant Business", nameOfLastItem.getText());
        System.out.println("Name of the item is: " + nameOfLastItem.getText());
        nameOfLastItem.click();
    }

    public void getStarsOfLastItem(){
        Assert.assertEquals("5", starsOfLastItem.getText());
        System.out.println("The number of stars of the item is: " + starsOfLastItem.getText());
    }

}
