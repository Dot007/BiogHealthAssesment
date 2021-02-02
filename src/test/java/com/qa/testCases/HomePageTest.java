package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase{
    LogInPage loginPage;
    HomePage homePage;
    TestUtil testUtil;


    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Onboarding Sleep Test - Sleepio","Home Page Title Not Matched");
    }
    @Test(priority=2)
    public void verifyHomePageElementsTest(){
        Assert.assertTrue(homePage.validateHomePageElements());
    }

    @Test(priority=3)
    public void verifyUserCanSelectSelectGetStartedTest(){
        homePage.selectGetStarted();
        Assert.assertTrue(homePage.verifyFirstOptionIsDisplayed());
    }

    @AfterMethod(enabled=true)
    public void tearDown(){
        driver.quit();
    }

}
