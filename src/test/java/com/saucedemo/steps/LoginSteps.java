package com.saucedemo.steps;


import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Opening and loading Login page")
    public LoginSteps openingLoginPage() {
        loginPage.openPage();
        loginPage.isPageOpen();
        return this;
    }

    @Step("Login with standard user and loading Products page")
    public LoginSteps loginWithStandardUser() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage
                .isPageOpen()
                .loginWithStandardUser();
        productsPage.isPageOpen();
        return this;
    }
}
