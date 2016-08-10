package com.endava.main;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ienache on 8/3/2016.
 */
public class NoutatiPage {

    private WebDriver webDriver;

    public NoutatiPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@href='/bath-body/new']")
    private WebElement noutatiTab;

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalNoutatiNumber;

    @FindBy(xpath = "//span[contains(.,'Gel exfoliant de duş cu extract din kiwi Nature Secrets')]")
    private WebElement secondProduct;

    @FindBy(id = "addToBasketButton")
    private WebElement addToCart;

    @FindBy(xpath = "//span[@class='v-icon-mini-bag']")
    private WebElement hoverCart;

    @FindBy(className = "name")
    private WebElement itemInCart;

    @FindBy(xpath = "//span[@title='Increase value']")
    private WebElement increaseValue;

    @FindBy(xpath = "//span[@class='total-bp']")
    private WebElement totalPoints;

    @FindBy(xpath = "//span[@class='price']/span[@class='value']")
    private WebElement totalPrice;

    public void selectNoutatiTab(){
        noutatiTab.click();
    }

    public Integer getTotalNoutatiNumber() throws InterruptedException {
        Thread.sleep(3000);
        String totalNoutati = totalNoutatiNumber.getText();
        return Integer.parseInt(totalNoutati);
    }

    public void selectSecondProduct(){
        secondProduct.click();
    }

    public void verificareButon() {

        boolean actualButton = addToCart.isDisplayed();

        if (actualButton)
            System.out.println("Button is displayed");
        else
            System.out.println("Button is not displayed");
    }

    public void clickToAddButton(){
        addToCart.click();
        System.out.println("Produs adaugat cu succes in cosul de cumparaturi!");
    }

    public void hoverOnCart() throws InterruptedException {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(hoverCart).perform();
        System.out.println("Hover successfully!");
        Thread.sleep(4000);
        Assert.assertEquals("Gel exfoliant de duş cu extract din kiwi Nature Secrets", itemInCart.getText());
        System.out.println("Cart updated with the new item");
    }

    public void increaseTheQuantity(){
        hoverCart.click();
        increaseValue.click();
        increaseValue.click();
    }

    public String getTotalPoints() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String totalPuncte = totalPoints.getText();
        return totalPuncte;
    }

    public String getTotalPrice() throws InterruptedException {
        Thread.sleep(3000);
        String totalPret = totalPrice.getText();
        return totalPret;
    }


}
