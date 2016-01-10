package videoDownloader.models;

import org.openqa.selenium.WebElement;

import static videoDownloader.Utils.getParent;

/**
 * Created by alexandriann on 09/01/16.
 */
public class Lesson {

    private final WebElement lessonLinkElement;
    private final String title;
    private final String url;

    public Lesson(WebElement lessonLinkElement) {
        this.lessonLinkElement = lessonLinkElement;
        this.title = getParent(lessonLinkElement).getText();
        this.url = lessonLinkElement.getAttribute("href");
    }

    public String getTitle(){
        return title;
    }

    public String getURL(){
        return url;
    }
}
