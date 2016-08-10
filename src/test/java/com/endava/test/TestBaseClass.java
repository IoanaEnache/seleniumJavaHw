package com.endava.test;

import com.endava.main.HomePage;
import com.endava.main.IngrijireCorpPage;
import com.endava.main.NoutatiPage;
import com.endava.main.PentruElPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ienache on 8/3/2016.
 */
public class TestBaseClass {

    private static WebDriver webDriver;
    protected HomePage homePage;
    protected IngrijireCorpPage ingrijireObject;
    protected NoutatiPage noutatiPage;
    protected PentruElPage pentruElPage;

    @BeforeClass
    public static void setUp(){

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oriflame.ro");

    }

    @Before
    public void initPageObjects(){

        homePage = PageFactory.initElements(webDriver, HomePage.class);
        ingrijireObject = PageFactory.initElements(webDriver, IngrijireCorpPage.class);
        noutatiPage = PageFactory.initElements(webDriver, NoutatiPage.class);
        pentruElPage = PageFactory.initElements(webDriver, PentruElPage.class);


    }

    @AfterClass
    public static void tearDown(){

        //webDriver.close();

    }

}
