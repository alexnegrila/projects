package videoDownloader.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import videoDownloader.models.Video;

/**
 * Created by alexandriann on 04/01/16.
 */
public class DoYouYogaLessonPage {

    @FindBy(tagName = "video")
    private WebElement video;

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@class,'video')]/iframe")
    private WebElement playerFrame;

    public Video getVideo(WebDriver driver) {
        driver.switchTo().frame(playerFrame);
        return new Video(video);
    }

}
