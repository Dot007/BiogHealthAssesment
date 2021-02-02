package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(className = "sl-button")
    @CacheLookup
    private WebElement getStartedBtn;

    @FindBy(className = "sl-header__login")
    @CacheLookup
    private WebElement login;

    @FindBy(tagName = "h1")
    @CacheLookup
    private WebElement pageText;
    //*[@id="sl-flow"]/div[3]/div/div/div/div/div/h1

    @FindBy(id = "sl-flow")
    @CacheLookup
    private WebElement questionFlow;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateHomePageElements() {
        boolean there = false;
        if (getStartedBtn.isDisplayed() && login.isDisplayed()) {
            there = true;}
      return there;
    }

    public void selectLogin() {
        login.click();
    }

    public void selectGetStarted() {
        getStartedBtn.click();
    }

    public void HomePageWitForVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getStartedBtn));
    }


    public boolean verifyFirstOptionIsDisplayed() {
        return questionFlow.isDisplayed();
    }

}
