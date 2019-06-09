package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();

    public BasePage(WebDriver driver)
    {
        this.driver =driver;
        wait = new WebDriverWait(driver, 15);
    }

    //wait wrapper
    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }


    public void writeText(By elementBy, String text)
    {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void hardAssertEquals(By elementBy, String ExpectedText)
    {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), ExpectedText);
    }
    @Step
    public SoftAssert softAssertEquals(By elementBy, String ExpectedText)
    {
        waitVisibility(elementBy);
        softAssert.assertEquals(readText(elementBy),ExpectedText);
        return softAssert;
    }

    public String readText(By elementBy)
    {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

}
