package com.saucedemo.pages;

import com.saucedemo.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SideMenu extends BasePage {

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    public SideMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Side menu to load")
    public SideMenu isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bm-menu-wrap")));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Waiting for Login page to load")
    public LoginPage clickLogoutLink() {
        logoutLink.click();
        AllureUtils.takeScreenshot(driver);
        return new LoginPage(driver);
    }
}
