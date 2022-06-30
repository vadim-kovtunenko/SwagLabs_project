package com.saucedemo.pages;

import com.saucedemo.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.saucedemo.utils.PropertyReader;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3")
    public WebElement errorMessage;

    PropertyReader reader = new PropertyReader();

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Login page to load")
    public LoginPage isPageOpen() {
        wait.until(ExpectedConditions.urlToBe(reader.getLoginUrl()));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Opening www.saucedemo.com")
    public void openPage() {
        driver.get(reader.getLoginUrl());
    }

    public String Url() {
        return driver.getCurrentUrl();
    }

    public LoginPage setUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        AllureUtils.takeScreenshot(driver);
        return errorMessage.getText();
    }

    public ProductsListPage clickLogin() {
        loginButton.click();
        return new ProductsListPage(driver);
    }

    @Step("Login with username '{username}', password '{password}'")
    public ProductsListPage login(String username, String password) {
        setUserName(username).setPassword(password).clickLogin();
        return new ProductsListPage(driver);
    }

    @Step("Login with standard user")
    public ProductsListPage loginWithStandardUser() {
        login(reader.getUsername(),reader.getPassword());
        return new ProductsListPage(driver);
    }
}