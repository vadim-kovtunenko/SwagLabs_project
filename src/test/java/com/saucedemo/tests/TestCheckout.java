package com.saucedemo.tests;


import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckout extends BaseTest {

    @Test(description = "Clicking 'Cansel' button")
    @Description("Check of clicking 'Cansel' button and opening Cart page")
    public void testCancelButton() {
        checkoutPageSteps.openingCheckoutPage();
        checkoutPage.clickCancelButton();
        cartPage.isPageOpen();

        Assert.assertEquals(cartPage.getPageTitle(), reader.getCartPageTitle());
    }

    @Test(description = "Clicking 'Continue' button with empty fields")
    @Description("Check of clicking 'Continue' button with empty fields")
    public void testContinueButton() {
        checkoutPageSteps.openingCheckoutPage();
        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test(description = "Clicking 'Cart' link")
    @Description("Check of clicking 'Cart' link and opening Cart page")
    public void testCartLink() {
        checkoutPageSteps.openingCheckoutPage();
        checkoutPage.clickCartLink();
        cartPage.isPageOpen();

        Assert.assertEquals(cartPage.getPageTitle(), reader.getCartPageTitle());
    }

    @Test(description = "Clicking 'Continue' button with empty 'Zip/Postal Code' field")
    @Description("Check of clicking 'Continue' button with empty 'Zip/Postal Code' field")
    public void testEmptyPostalCode() {
        checkoutPageSteps.openingCheckoutPage();
        checkoutPage.setFirstName("James").setLastName("Bond").clickContinueButton();

        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required");
    }
}

