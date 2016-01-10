package videoDownloader.models;

import org.openqa.selenium.WebElement;

/**
 * Created by alexandriann on 10/01/16.
 */
public class Video {
    public static final String URL_ATTRIBUTE = "src";
    private final WebElement videoElement;
    private String downloadURL;

    public Video(WebElement videoElement) {
        this.videoElement = videoElement;
        this.downloadURL = videoElement.getAttribute(URL_ATTRIBUTE);
    }

    public String getDownloadURL(){
        return downloadURL;
    }
}
