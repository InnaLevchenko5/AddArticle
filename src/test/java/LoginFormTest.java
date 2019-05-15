import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.function.Function;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class LoginFormTest extends BaseTest {

    private static By POST_BUTTON = By.cssSelector("button.editor-post-publish-button");
    private static By CONTENT_TEXTAREA = By.cssSelector("textarea.editor-default-block-appender__content");
    private static By SAVE_BUTTON = By.cssSelector("button.editor-post-publish-panel__toggle");
    // start page
    private static String url1 = "http://wordpress.local/wp-login.php";
    //page for adding article
    private static String url2 = "http://wordpress.local/wp-admin/post-new.php";
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    @Test
    @Parameters({"login", "password"})
    public void testLogin(String login, String password) throws IOException {
        getDriver().get(url1);
        WebElement loginIn = getDriver().findElement(By.id("user_login"));
        loginIn.sendKeys(login);
        WebElement passwd = getDriver().findElement(By.id("user_pass"));
        passwd.sendKeys(password);
        getDriver().findElement(By.id("loginform")).submit();
    }


    @Test(dependsOnMethods = "testLogin")
    public void testAddArticle()
    {
        getDriver().get(url2);
        getDriver().findElement(By.id("post-title-0")).sendKeys(titleArticle);
        getDriver().findElement(CONTENT_TEXTAREA).click();
        getDriver().findElement(By.cssSelector(".nux-dot-tip__disable")).click();
        getDriver().findElement(By.cssSelector("p.mce-content-body")).sendKeys(bodyArticle);
        getDriver().findElement(SAVE_BUTTON).click();
        getDriver().findElement(POST_BUTTON).click();

        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.components-notice a")));
    }
    @Test(dependsOnMethods = "testAddArticle")
    public void testCheckPost() throws IOException
    {
            WebElement viewLink = getDriver().findElement(By.cssSelector("div.components-notice a"));
            getDriver().get(viewLink.getAttribute("href"));
            String title = getDriver().findElement(By.xpath("//header/h1")).getText();
            Assert.assertEquals(title, titleArticle);
            String article = getDriver().findElement(By.xpath("//div[@class='entry-content']/p")).getText();
            Assert.assertEquals(article, bodyArticle);

        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/screenshots/screen.png"));
    }
}
