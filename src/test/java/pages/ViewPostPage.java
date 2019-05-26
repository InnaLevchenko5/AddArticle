package pages;

import org.openqa.selenium.*;
import java.io.IOException;

public class ViewPostPage extends BasePage{

    public ViewPostPage(WebDriver driver)
    {
        super(driver);
    }

    private static By TITLE_TEXT = By.xpath("//header/h1");
    private static By ARTICLE_TEXT = By.xpath("//div[@class='entry-content']/p");
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    public void ViewPost(String viewLink)
    {
        driver.get(viewLink);
        readText(TITLE_TEXT);
        readText(ARTICLE_TEXT);
        assertEquals(TITLE_TEXT, titleArticle);
        assertEquals(ARTICLE_TEXT,bodyArticle);
    }
}

