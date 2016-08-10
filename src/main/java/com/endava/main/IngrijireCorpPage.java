package com.endava.main;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ienache on 8/3/2016.
 */
public class IngrijireCorpPage {

    private WebDriver webDriver;
    public IngrijireCorpPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalproductsNumberField;

    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement changeFilter;

    @FindBy(xpath = "//li[contains(.,'Preț – Cel mai mare la Cel mai mic')]")
    private WebElement highestPrice;

    @FindBy(xpath = "//span[contains(.,'Tratament anticelulitic Bioclinic')]")
    private WebElement firstItemReturned;

    @FindBy(xpath = "//h1[contains(.,'Tratament anticelulitic Bioclinic')]")
    private WebElement itemDescription;

    @FindBy(xpath = "//span[contains(.,'Înapoi')]")
    private WebElement inapoiLink;


    public Integer getTotalProductsNumber(){
        String totalproductsNumber = totalproductsNumberField.getText();
        return Integer.parseInt(totalproductsNumber);
    }

    public void waitForPage(){
       WebDriverWait wait = new WebDriverWait(webDriver, 10);
       wait.until(ExpectedConditions.visibilityOf(totalproductsNumberField));
       wait.until(ExpectedConditions.textToBePresentInElement(totalproductsNumberField, ""));
    }

    public void changeTheFilter(){
        changeFilter.click();
    }

    public void setHighestPrice(){
        highestPrice.click();
    }

    public void selectFirstItemReturned(){
        firstItemReturned.click();
    }

    public void inapoiIngrijireCorp(){
        inapoiLink.click();
    }

    public void printDetails(){
        String maxItemName = webDriver.findElement(By.xpath("//span[contains(.,'Tratament anticelulitic Bioclinic')]")).getText();
        String maxItemPrice = webDriver.findElement(By.xpath("//*[@id='grid']/div/div[2]/section/section/a[1]/div[2]/div[1]/span")).getText();
        System.out.println("Nume produs: " + maxItemName);
        System.out.println("Pret produs: " + maxItemPrice);
    }

    public void verifyProduct(){
        Assert.assertEquals("Tratament anticelulitic Bioclinic", itemDescription.getText());
        System.out.println("Produsul este cel dorit!");
    }

}
