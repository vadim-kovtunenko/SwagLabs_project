package com.saucedemo.pages;

import com.saucedemo.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.saucedemo.utils.PropertyReader;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBys({
            @FindBy(css = ".cart_item_label")
    })
    public List<WebElement> productList;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(css = ".inventory_item_desc")
    public WebElement desc;

    @FindBy(css = ".inventory_item_price")
    public WebElement price;

    private By productName = By.cssSelector(".inventory_item_name");

    PropertyReader reader = new PropertyReader();

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Cart page to load")
    public CartPage isPageOpen() {
        wait.until(ExpectedConditions.urlToBe(reader.getCartPageUrl()));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public List<String> getProductNamesList() {
        List<String> names = new ArrayList<>();
        for (WebElement product : productList) {
            names.add(product.findElement(productName).getText());
        }
        return names;
    }

    @Step("Getting ProductList size")
    public int getSizeProductList() {
        return getProductNamesList().size();
    }

    @Step("Clicking 'Continue shopping' button")
    public ProductsListPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsListPage(driver);
    }

    @Step("Clicking 'Checkout' button")
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    @Step("Clicking 'Remove' button")
    public CartPage clickRemoveButton(int productNumberInList) {
        productList.get(productNumberInList);
        removeButton.click();
        return this;
    }

    @Step("Getting product name")
    public String getName() {
        return driver.findElement(productName).getText();
    }

    @Step("Getting product description")
    public String getDescription() {
        return desc.getText();
    }

    @Step("Getting product price")
    public String getPrice() {
        return price.getText();
    }
}
