package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {

    private LoginPage loginPage;

    public CartPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Opening and loading Cart page")
    public CartPageSteps openingCartPage() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage
                .isPageOpen()
                .loginWithStandardUser();
        CartPage cartPage = productsPage
                .isPageOpen()
                .clickCartLink();
        cartPage.isPageOpen();
        return this;
    }
}
