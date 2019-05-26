package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddArticlePage extends BasePage
{
    public AddArticlePage(WebDriver driver)
    {
        super(driver);
    }

    private static By POST_BUTTON = By.cssSelector("button.editor-post-publish-button");
    private static By CONTENT_TEXTAREA = By.cssSelector("textarea.editor-default-block-appender__content");
    private static By SAVE_BUTTON = By.cssSelector("button.editor-post-publish-panel__toggle");
    private static By TITLE_AREA = By.id("post-title-0");
    private static By TEXT_AREA = By.cssSelector("p.mce-content-body");
    private static By VIEW_LINK = By.cssSelector("div.components-notice a");

    //page for adding article
    private static String url2 = "http://wordpress.local/wp-admin/post-new.php";
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    public String AddArticle()
    {
        driver.get(url2);
        writeText(TITLE_AREA, titleArticle);
        click(CONTENT_TEXTAREA);
        click(By.cssSelector(".nux-dot-tip__disable"));
        writeText(TEXT_AREA,bodyArticle);
        click(SAVE_BUTTON);
        click(POST_BUTTON);
//        (new WebDriverWait(driver, 10))
////                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.components-notice a")));
        waitVisibility(VIEW_LINK);
        WebElement viewLink = driver.findElement(VIEW_LINK);
        return viewLink.getAttribute("href");
    }
}
