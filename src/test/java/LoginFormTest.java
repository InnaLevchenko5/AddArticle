import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class LoginFormTest {

    private WebDriver driver;

    @BeforeSuite
    public void init()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://wordpress.local/wp-login.php");
    }

    @Test
    public void testLogin() throws IOException {
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("inna");

        WebElement passwd = driver.findElement(By.id("user_pass"));
        passwd.sendKeys("Inna123!");

        driver.findElement(By.id("loginform")).submit();

        driver.get("http://wordpress.local/wp-admin/post-new.php");
        driver.findElement(By.id("post-title-0")).sendKeys("Локаторы");
        driver.findElement(By.cssSelector("textarea.editor-default-block-appender__content")).click();
        driver.findElement(By.cssSelector(".nux-dot-tip__disable")).click();

        driver.findElement(By.cssSelector("p.mce-content-body")).sendKeys("Различают три вида локаторов");
        driver.findElement(By.cssSelector("button.editor-post-publish-panel__toggle")).click();
        driver.findElement(By.cssSelector("button.editor-post-publish-button")).click();


        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.components-notice a")));
        WebElement viewLink = driver.findElement(By.cssSelector("div.components-notice a"));
        driver.get(viewLink.getAttribute("href"));
        String title = driver.findElement(By.xpath("//header/h1")).getText();
        Assert.assertEquals(title, "Локаторы");
        String article = driver.findElement(By.xpath("//div[@class='entry-content']/p")).getText();
        Assert.assertEquals(article, "Различают три вида локаторов");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // String path = "C:\\Users\\Инна\\Desktop\\Скрины\\screen1.png";

        FileUtils.copyFile(scrFile, new File("C:\\Users\\Инна\\Desktop\\Скрины\\screen2.png"));
    }
    @AfterSuite
    public void after()
    {
        driver.quit();
       // driver.close();
    }
}
