package pages;

import org.openqa.selenium.*;
import java.io.IOException;

public class ViewPostPage extends BasePage{

    public ViewPostPage(WebDriver driver)
    {
        super(driver);
    }
    //private static By VIEW_LINK = By.cssSelector("p.mce-content-body");
    private static By VIEW_LINK = By.xpath("//div[@class = 'post-publish-panel__postpublish-buttons']/a");
    private static By TITLE_TEXT = By.xpath("//header/h1");
    private static By ARTICLE_TEXT = By.xpath("//div[@class='entry-content']/p");
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    public void ViewPost()
    {
        WebElement viewLink = driver.findElement(VIEW_LINK);
        driver.get(viewLink.getAttribute("href"));
        readText(TITLE_TEXT);
        readText(ARTICLE_TEXT);
        assertEquals(TITLE_TEXT, titleArticle);
        assertEquals(ARTICLE_TEXT,bodyArticle);
    }
}

