package com.saucedemo.pages;

import com.saucedemo.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartLink;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(xpath = "//h3")
    public WebElement errorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Checkout page to load")
    public CheckoutPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".form_group")));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Clicking 'Cancel' button")
    public CartPage clickCancelButton() {
        cancelButton.click();
        return new CartPage(driver);
    }

    @Step("Clicking 'Continue' button")
    public CartPage clickContinueButton() {
        continueButton.click();
        return new CartPage(driver);
    }

    @Step("Clicking 'Cart' link")
    public CartPage clickCartLink() {
        cartLink.click();
        return new CartPage(driver);
    }

    @Step("Input '{firstName}' into 'First Name' field")
    public CheckoutPage setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Input '{lastName}' into 'Last Name' field")
    public CheckoutPage setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        AllureUtils.takeScreenshot(driver);
        return errorMessage.getText();
    }
}