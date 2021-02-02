package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {

    @FindBy(id = "sl-login-email")
    @CacheLookup
    private WebElement loginEmail;

    @FindBy(id = "sl-login-password")
    @CacheLookup
    private WebElement password;

    @FindBy(className = "sl-new-login-button")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(className = "sl-header__text")
    @CacheLookup
    private WebElement headerTxt;

    @FindBy(xpath = "//*[@id='sl-flow']/header/div/a[2]")
    @CacheLookup
    private WebElement logOutTxt;

    @FindBy(id = "sl-login")
    @CacheLookup
    private WebElement stillOnLoginPage;


    public LogInPage() {
        PageFactory.initElements(driver, this);	;
    }
    HomePage homePage = new HomePage();

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyLoginPageElements(){
        if(loginBtn.isDisplayed() && password.isDisplayed() && loginBtn.isDisplayed() ){
            return true;
        }
        else return false;
    }

    public void loginUser(){
        loginEmail.sendKeys("dot@dot.com");
        password.sendKeys("password");
        loginBtn.click();
    }

    public void loginUserWithoutUser(){
        loginEmail.clear();
        password.clear();
        loginBtn.click();
    }

    public boolean verifyLoginError(){
        return stillOnLoginPage.isDisplayed();
    }

    public boolean verifyUserIsNotLoggedIn(){
        return loginEmail.isDisplayed();
    }

}
