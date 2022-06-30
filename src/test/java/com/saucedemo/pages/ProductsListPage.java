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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsListPage extends BasePage {

    @FindBys({
            @FindBy (css = ".inventory_item")
    })
    public List<WebElement> productsList;

    @FindBy(tagName = "select")
    public WebElement select;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(css = ".shopping_cart_link")
    public WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartBadge;

    private By addToCartButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productDesc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");

    public ProductsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Products page to load")
    public ProductsListPage isPageOpen() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".inventory_item"), 6));
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("Clicking 'Menu' button")
    public SideMenu clickMenuButton() {
        menuButton.click();
        return new SideMenu(driver);
    }

    @Step("Clicking 'Cart' link")
    public CartPage clickCartLink() {
        cartLink.click();
        return new CartPage(driver);
    }

    @Step("Getting number on cart badge")
    public String numberCartBadge() {
        return cartBadge.getText();
    }

    public WebElement getSelectedProduct(int index) {
        return productsList.get(index);
    }

    public WebElement getAddToCart(int index) {
        return getSelectedProduct(index).findElement(addToCartButton);
    }

    @Step("Adding product to cart")
    public ProductsListPage clickAddToCart(int index) {
        getAddToCart(index).click();
        return this;
    }

    public String getName(int index) {
        return getSelectedProduct(index).findElement(productName).getText();
    }

    public String getDescription(int index) {
        return getSelectedProduct(index).findElement(productDesc).getText();
    }

    public String getPrice(int index) {
        return getSelectedProduct(index).findElement(price).getText();
    }

    public Select getSelect() {
        return new Select(select);
    }

    @Step("Selecting sorting by value")
    public void selectValue(String value) {
        getSelect().selectByVisibleText(value);
    }

    public List<String> getProductsNames() {
        List<String> names = new ArrayList<>();
        for (WebElement product: productsList) {
            names.add(product.findElement(productName).getText());
        }
        return names;
    }

    public List<Double> getProductsPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement product: productsList) {
            prices.add(Double.parseDouble(product.findElement(price).getText().replace("$", "")));
        }
        return prices;
    }
}