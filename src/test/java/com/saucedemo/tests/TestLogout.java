package com.saucedemo.tests;

import com.saucedemo.pages.SideMenu;
import com.saucedemo.tests.base.BaseTest;
import com.saucedemo.tests.base.Retry;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogout extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Logout")
    @Description("Checking logout")
    public void testLogout() {
        loginSteps.loginWithStandardUser();
        SideMenu sideMenu = productsPage.clickMenuButton();
        sideMenu.isPageOpen();
        sideMenu.clickLogoutLink();

        Assert.assertEquals(loginPage.Url(), reader.getLoginUrl());
    }
}
