package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters extends BaseTest {

    @Test(description = "Login")
    @Description("Checking login with data passed using the 'Parameters' annotation")
    @Parameters({"username", "password", "expectedResult"})
    public void testParameters(@Optional("") String username,
                               @Optional("11111") String password,
                               @Optional("Epic sadface: Username is required") String expectedResult) {
        loginSteps.openingLoginPage();
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), expectedResult);
    }
}
