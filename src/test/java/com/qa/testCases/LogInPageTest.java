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

public class LogInPageTest extends TestBase{
    HomePage homePage;
    LogInPage logInPage;
    TestUtil testUtil;

    public LogInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        logInPage = new LogInPage();
        homePage = new HomePage();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    @Test(priority=1)
    public void verifyLoginPageTitleTest(){
        homePage.selectLogin();
        String loginPageTitle = logInPage.validateLoginPageTitle();
        Assert.assertEquals(loginPageTitle, "Login - Sleepio","Login Page Title Not Matched");
    }

    @Test(priority=2)
    public void verifyLogInPageElementsTest(){
        homePage.selectLogin();
        Assert.assertTrue(logInPage.verifyLoginPageElements());
    }

    @Test(priority=3)
    public void verifyThatTheUserCanLogInTest(){
        homePage.selectLogin();
        logInPage.loginUser();
        //should fail cause of invalid user
        Assert.assertTrue(logInPage.verifyUserIsNotLoggedIn());
    }


    @AfterMethod(enabled=true)
    public void tearDown(){
        driver.quit();
    }

}
