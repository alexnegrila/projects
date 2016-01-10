package videoDownloader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videoDownloader.configuration.Configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by alexandriann on 09/01/16.
 */
public class Utils {
    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static File getDownloadFolder() {
        File videoDownloadFolder = new File(Configuration.getInstance().getPropertyValue(Constants.VIDEO_DOWNLOAD_FOLDER));
        if (!videoDownloadFolder.exists() || !videoDownloadFolder.isDirectory()) {
            videoDownloadFolder.mkdirs();
        }
        return videoDownloadFolder;
    }

    public static WebElement getParent(WebElement element) {
        return element.findElement(By.xpath(".."));
    }


    public static void handledWait(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void downloadVideo(String videoUrl, File video) {
        try {
//            FileUtils.copyURLToFile(new URL(videoUrl), video);
            URL website = new URL(videoUrl);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(video);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            LOG.error("Video not found", e);
        }
    }

}
