package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginDataProvider extends BaseTest {

    @DataProvider(name = "Correct data")
    public Object[][] inputCorrectData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "PRODUCTS"},
                {"problem_user", "secret_sauce",  "PRODUCTS"},
                {"performance_glitch_user", "secret_sauce",  "PRODUCTS"}
        };
    }

    @Test(dataProvider = "Correct data", description = "Login with correct data")
    @Description("Checking login with correct data passed using the 'DataProvider' annotation")
    public void testLoginCorrectData(String username, String password, String expectedResult) {
        loginSteps.openingLoginPage();
        loginPage.login(username, password);
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle(), expectedResult);
    }

    @DataProvider(name = "Incorrect data")
    public Object[][] inputIncorrectData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce",  "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"qwer", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "1111", "Epic sadface: Username and password do not match any user in this service"},
                {"qwer", "1111", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"     ", "     ", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Incorrect data", description = "Login with incorrect data")
    @Description("Checking login with incorrect data passed using the 'DataProvider' annotation")
    public void testLoginIncorrectData(String username, String password, String expectedResult) {
        loginSteps.openingLoginPage();
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), expectedResult);
    }
}
