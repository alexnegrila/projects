package videoDownloader.strategies;

import org.openqa.selenium.WebDriver;
import videoDownloader.pages.DoYouYogaCoursePage;
import videoDownloader.pages.StartPage;

/**
 * Created by alexandriann on 04/01/16.
 */
public class StrategyFactory {

    public static Strategy getStrategy(StartPage startPage, WebDriver driver) throws ClassNotFoundException {
        if (startPage instanceof DoYouYogaCoursePage) {
            return new DoYouYogaStrategy((DoYouYogaCoursePage) startPage, driver);
        }
        throw new ClassNotFoundException("No strategy for start page");
    }
}
