package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {

    @Test(description = "Clicking 'Continue Shopping' button")
    @Description("Check of clicking 'Continue Shopping' button and opening Products page")
    public void testContinueShoppingButton() {
        cartPageSteps.openingCartPage();
        cartPage.clickContinueShoppingButton();
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }

    @Test(description = "Clicking 'Checkout' button")
    @Description("Check of clicking 'Checkout' button and opening Checkout page")
    public void testCheckoutButton() {
        checkoutPageSteps.openingCheckoutPage();

        Assert.assertEquals(checkoutPage.getPageTitle(), reader.getCheckoutPageTitle());
    }

    @Test(description = "Adding and removing item")
    @Description("Check adding and removing item in cart")
    public void testAddRemoveItem() {
        loginSteps.loginWithStandardUser();

        String expectedProductName = productsPage.getName(5);
        String expectedDescription = productsPage.getDescription(5);
        String expectedPrice = productsPage.getPrice(5);

        productsPage.clickAddToCart(5);

        Assert.assertEquals(productsPage.numberCartBadge(), "1");  //Проверка отображения количества товаров в корзине.

        productsPage.clickCartLink();
        cartPage.isPageOpen();

        Assert.assertEquals(cartPage.getName(), expectedProductName);       //Проверка правильности отображения названия товара.
        Assert.assertEquals(cartPage.getDescription(), expectedDescription);//Проверка правильности отображения описания товара.
        Assert.assertEquals(cartPage.getPrice(), expectedPrice);            //Проверка правильности отображения цены товара.

        cartPage.clickRemoveButton(0);

        Assert.assertEquals(cartPage.getSizeProductList(),0); //Проверка отсутствия товара в корзине после его удаления.
    }

}
