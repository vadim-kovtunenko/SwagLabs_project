package com.saucedemo.tests.base;


import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.saucedemo.utils.AllureUtils;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Started-----", iTestResult.getName()));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Success-----", iTestResult.getName()));
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Failure-----", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Skipped-----", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Success-----", iTestResult.getName()));
    }

    public void onTestFailedWithTimeout(ITestResult iTestResult) {
        System.out.println(String.format("-----%s - status Failure-----", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    public void onStart(ITestContext context) {
        System.out.println("-----On Start " + context.getStartDate() + "-----");
    }

    public void onFinish(ITestContext context) {
        System.out.println("-----On Finish " + context.getEndDate() + "-----");
    }

    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if(driver != null) {
                return AllureUtils.takeScreenshot(driver);
            } else {
                return new byte[] {};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[] {};
        }
    }
}
