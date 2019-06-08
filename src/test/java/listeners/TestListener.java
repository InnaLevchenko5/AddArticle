package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.internal.BaseTestMethod;

import java.io.File;
import java.io.IOException;

public class TestListener extends TestListenerAdapter {
    private WebDriver driver = null;
    private String filePath = "target\\screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*****Error " + result.getName() + " test has failed****");
        String methodName = result.getName().trim();
        ITestContext context = result.getTestContext();

        Object obj = result.getInstance();
        driver = ((IGetDriver) obj).getDriver();

        takeScreenShot(methodName,driver);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("*****Success " + result.getName() + " test has done successfully****");
        String methodName = result.getName().trim();
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("driver");

        Object obj = result.getInstance();
        driver = ((IGetDriver) obj).getDriver();

        takeScreenShot(methodName,driver);
    }

    private void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + "\\" + methodName + ".png"));
            System.out.println("***Placed screenshot in " + filePath + "**");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
