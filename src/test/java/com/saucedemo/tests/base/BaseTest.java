package com.saucedemo.tests.base;

import com.saucedemo.steps.CartPageSteps;
import com.saucedemo.steps.CheckoutPageSteps;
import com.saucedemo.pages.*;
import com.saucedemo.steps.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.saucedemo.utils.PropertyReader;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    protected PropertyReader reader;
    protected LoginPage loginPage;
    protected ProductsListPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected LoginSteps loginSteps;
    protected CartPageSteps cartPageSteps;
    protected CheckoutPageSteps checkoutPageSteps;

    @BeforeMethod(alwaysRun = true, description = "Opening Browser")
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        context.setAttribute("driver", driver);

        driver = new ChromeDriver(options);
        reader = new PropertyReader();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsListPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginSteps = new LoginSteps(driver);
        cartPageSteps = new CartPageSteps(driver);
        checkoutPageSteps = new CheckoutPageSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("-----Before Class-----");
    }

    @AfterClass
    void afterClass() {
        System.out.println("-----After Class-----");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("-----Before Test-----");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("-----After Test-----");
    }
}
