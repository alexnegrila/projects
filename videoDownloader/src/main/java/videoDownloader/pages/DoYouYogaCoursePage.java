package videoDownloader.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import videoDownloader.models.Module;
import videoDownloader.models.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandriann on 04/01/16.
 */
public class DoYouYogaCoursePage implements StartPage {

    @FindBy(className = "course-title")
    private WebElement courseTitle;

    @FindBy(className = "course-author")
    private WebElement courseAuthor;

    @FindBy(className = "module")
    private List<WebElement> moduleElements;

    @FindBy(xpath = "//div[contains(@class,'video')]/iframe")
    private List<WebElement> playerFrames;

    @FindBy(tagName = "video")
    private WebElement video;

    public WebElement getCourseTitle() {
        return courseTitle;
    }

    public WebElement getCourseAuthor() {
        return courseAuthor;
    }

    public List<Module> getModules() {
        List<Module> modules = new ArrayList<Module>();
        for (WebElement element : moduleElements) {
            modules.add(new Module(element));
        }
        return modules;
    }

    public List<Video> getVideos(WebDriver driver) {
        List<Video> videos = new ArrayList<Video>();
        for (WebElement playerFrame : playerFrames) {
            driver.switchTo().frame(playerFrame);
            videos.add(new Video(video));
            driver.switchTo().defaultContent();
        }
        return videos;
    }
}
