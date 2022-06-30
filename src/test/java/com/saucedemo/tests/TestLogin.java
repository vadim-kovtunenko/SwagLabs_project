package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test(description = "Success login")
    @Description("Validation of login with standard user")
    public void testSuccessLogin() {
        loginSteps.loginWithStandardUser();

        Assert.assertEquals(productsPage.getPageTitle(),reader.getProductsPageTitle());
    }

    @Test(description = "Failed login with empty password")
    @Description("Validation of login with empty password")
    public void testEmptyPassword() {
        loginSteps.openingLoginPage();
        loginPage.login(reader.getUsername(), "");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test(description = "Failed login with incorrect credentials")
    @Description("Validation of login with incorrect credentials")
    public void testFailedLogin() {
        loginSteps.openingLoginPage();
        loginPage.login("aaaa", "1111");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Failed login with empty username")
    @Description("Validation of login with empty username")
    public void testEmptyUserName() {
        loginSteps.openingLoginPage();
        loginPage.login("", reader.getPassword());

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(description = "Login with locked out user")
    @Description("Validation of login with username 'locked_out_user'")
    public void testLockedOutUser() {
        loginSteps.openingLoginPage();
        loginPage.login("locked_out_user", reader.getPassword());

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Login with performance glitch")
    @Description("Validation of login with username 'performance_glitch_user'")
    public void testPerformanceGlitchUser() {
        loginSteps.openingLoginPage();
        loginPage.login("performance_glitch_user", reader.getPassword());
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }
}