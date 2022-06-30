package com.saucedemo.steps;


import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPageSteps {

    private LoginPage loginPage;

    public CheckoutPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Opening and loading Checkout page")
    public CheckoutPageSteps openingCheckoutPage() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage
                .isPageOpen()
                .loginWithStandardUser();
        CartPage cartPage = productsPage
                .isPageOpen()
                .clickCartLink();
        CheckoutPage checkoutPage = cartPage
                .isPageOpen()
                .clickCheckoutButton();
        checkoutPage.isPageOpen();
        return this;
    }
}

