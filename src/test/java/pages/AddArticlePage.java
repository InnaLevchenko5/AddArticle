package pages;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddArticlePage
{
    private WebDriver driver;

    private static By POST_BUTTON = By.cssSelector("button.editor-post-publish-button");
    private static By CONTENT_TEXTAREA = By.cssSelector("textarea.editor-default-block-appender__content");
    private static By SAVE_BUTTON = By.cssSelector("button.editor-post-publish-panel__toggle");
    //page for adding article
    private static String url2 = "http://wordpress.local/wp-admin/post-new.php";
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    public AddArticlePage(WebDriver driverIn)
    {
        driver = driverIn;
    }

    public void AddArticle()
    {
        driver.get(url2);
        driver.findElement(By.id("post-title-0")).sendKeys(titleArticle);
        driver.findElement(CONTENT_TEXTAREA).click();
        driver.findElement(By.cssSelector(".nux-dot-tip__disable")).click();
        driver.findElement(By.cssSelector("p.mce-content-body")).sendKeys(bodyArticle);
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(POST_BUTTON).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.components-notice a")));
    }
}
