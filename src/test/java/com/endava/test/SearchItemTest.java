package com.endava.test;

import com.endava.main.IngrijireCorpPage;
import org.junit.Test;

/**
 * Created by ienache on 8/3/2016.
 */
public class SearchItemTest extends TestBaseClass{

    @Test
    public void searchItems() throws InterruptedException {

        IngrijireCorpPage ingrijireCorpPage = homePage.ingrijireCorp();
        System.out.println("Total articole: " + ingrijireCorpPage.getTotalProductsNumber());
        ingrijireObject.changeTheFilter();
        ingrijireObject.setHighestPrice();
        ingrijireObject.printDetails();
        ingrijireObject.selectFirstItemReturned();
        ingrijireObject.verifyProduct();
        ingrijireObject.inapoiIngrijireCorp();
        noutatiPage.selectNoutatiTab();
        System.out.println("Total noutati: " + noutatiPage.getTotalNoutatiNumber());
        noutatiPage.selectSecondProduct();
        noutatiPage.verificareButon();
        noutatiPage.clickToAddButton();
        noutatiPage.hoverOnCart();
        noutatiPage.increaseTheQuantity();
        System.out.println("Total price: " + noutatiPage.getTotalPrice());
        System.out.println("Total points: " + noutatiPage.getTotalPoints());
        pentruElPage.selectPentruElTab();
        pentruElPage.selectCeasuriTab();
        pentruElPage.getNameOfLastItem();
        pentruElPage.getStarsOfLastItem();
    }

}
