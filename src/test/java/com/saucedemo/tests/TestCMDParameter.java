package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCMDParameter extends BaseTest {

    @Test(description = "Login with parameter from command line")
    @Description("command - mvn -Dtest=TestCMDParameter -Dparameter=performance_glitch_user test")
    public void testCMDParameter() {
        String name = System.getProperty("parameter");

        System.out.println("Parameter name: " + System.getProperty("parameter"));

        loginSteps.openingLoginPage();
        loginPage.login(name, reader.getPassword());
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }
}