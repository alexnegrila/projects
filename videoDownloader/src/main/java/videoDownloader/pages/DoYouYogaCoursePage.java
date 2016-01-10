package videoDownloader.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import videoDownloader.models.Module;

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

    public WebElement getCourseTitle() {
        return courseTitle;
    }

    public WebElement getCourseAuthor() {
        return courseAuthor;
    }

    public List<Module> getModules() {
        List<Module> modules = new ArrayList<Module>();
        for (WebElement element : moduleElements){
            modules.add(new Module(element));
        }
        return modules;
    }
}
