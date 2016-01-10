package videoDownloader.strategies;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import videoDownloader.Constants;
import videoDownloader.models.Lesson;
import videoDownloader.models.Module;
import videoDownloader.models.Video;
import videoDownloader.pages.DoYouYogaCoursePage;
import videoDownloader.pages.DoYouYogaLessonPage;

import java.io.File;
import java.util.List;

import static videoDownloader.Utils.*;

/**
 * Created by alexandriann on 04/01/16.
 */
public class DoYouYogaStrategy implements Strategy {

    private final DoYouYogaCoursePage startPage;
    private final WebDriver driver;

    public DoYouYogaStrategy(DoYouYogaCoursePage startPage, WebDriver driver) {
        this.startPage = startPage;
        this.driver = driver;
    }

    public void crawl() {
        final DoYouYogaCoursePage page = startPage;
        final String courseTitle = page.getCourseTitle().getText();
        final String courseAuthor = page.getCourseAuthor().getText();
        File courseFolder = getFolder(courseTitle + " " + courseAuthor);
        final List<Module> modules = page.getModules();
        for (int i = 0; i < modules.size(); i++) {
            Module module = modules.get(i);
            final int moduleIndex = i + 1;
            final File moduleFolder = getFolder(courseFolder.getName() + Constants.SLASH + moduleIndex + Constants.DOT + module.getTitle());
            final List<Lesson> lessons = module.getLessons();
            for (int j = 0; j < lessons.size(); j++) {
                final Lesson lesson = lessons.get(j);

                String lessonTitle = lesson.getTitle();
                final String lessonURL = lesson.getURL();
                final DoYouYogaLessonPage doYouYogaLessonPage = loadLessonPage(lessonURL);

                Video video = doYouYogaLessonPage.getVideo(driver);
                final String videoUrl = video.getDownloadURL();
                final int lessonIndex = j + 1;
                downloadVideo(videoUrl, new File(moduleFolder + Constants.SLASH + lessonIndex + Constants.DOT + lessonTitle + ".mp4"));
                simulateViewing(lessonTitle);
            }
        }
    }

    private File getFolder(String folderName) {
        File folder = new File(getDownloadFolder().getAbsolutePath() + "/" + folderName);
        folder.mkdir();
        return folder;
    }

    private void simulateViewing(String lessonTitle) {
        final String videoLength = lessonTitle.split("\\(")[1].substring(0, 2);
        int minutes;
        try {
            minutes = Integer.valueOf(StringUtils.trim(videoLength));
        } catch (NumberFormatException e) {
            minutes = 1;
        }

        handledWait((int) (minutes * 60 * (1 + Math.random()) + 10) * 1000);
    }

    private DoYouYogaLessonPage loadLessonPage(String lessonURL) {
        driver.get(lessonURL);
        handledWait(15000);
        return PageFactory.initElements(driver, DoYouYogaLessonPage.class);
    }

}
