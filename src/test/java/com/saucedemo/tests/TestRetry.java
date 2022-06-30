package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import com.saucedemo.tests.base.Retry;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetry extends BaseTest {

    @Test(timeOut = 5800, retryAnalyzer = Retry.class, description = "Login with 'Retry'")
    @Description("Checking login with performance glitch using 'retryAnalyzer'")
    public void testRetry() {
        loginSteps.openingLoginPage();
        loginPage.login("performance_glitch_user", reader.getPassword());
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }
}