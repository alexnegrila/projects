package videoDownloader.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandriann on 09/01/16.
 */
public class Module {

    private final WebElement moduleElement;
    private final String title;
    private final List<Lesson> lessons;

    public Module(WebElement moduleElement) {
        this.moduleElement = moduleElement;
        this.title = moduleElement.findElement(By.tagName("h2")).getText();
        this.lessons = initLessons();
    }

    private List<Lesson> initLessons() {
        List<Lesson> lessons = new ArrayList<Lesson>();
        final List<WebElement> elements = moduleElement.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            lessons.add(new Lesson(element));
        }
        return lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public String getTitle() {
        return title;
    }
}
