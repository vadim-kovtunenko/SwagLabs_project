package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TestProducts extends BaseTest {

    @Test(description = "Product sorting")
    @Description("Checking product sorting by selected value")
    public void testSortingBySelector() {


        loginSteps.loginWithStandardUser();

        List<String> initialNames = productsPage.getProductsNames();

        initialNames.sort(Comparator.naturalOrder());
        productsPage.selectValue("Name (A to Z)");
        Assert.assertEquals(productsPage.getProductsNames(), initialNames);

        initialNames.sort(Comparator.reverseOrder());
        productsPage.selectValue("Name (Z to A)");
        Assert.assertEquals(productsPage.getProductsNames(), initialNames);

        List<Double> initialPrices = productsPage.getProductsPrices();

        productsPage.selectValue("Price (low to high)");
        initialPrices.sort(Comparator.naturalOrder());
        Assert.assertEquals(productsPage.getProductsPrices(), initialPrices);

        productsPage.selectValue("Price (high to low)");
        initialPrices.sort(Comparator.reverseOrder());
        Assert.assertEquals(productsPage.getProductsPrices(), initialPrices);
    }
}
