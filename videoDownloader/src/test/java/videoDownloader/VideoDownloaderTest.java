package videoDownloader;

import org.junit.Before;
import org.junit.Test;
import videoDownloader.sites.DoYouYogaSite;
import videoDownloader.sites.SecureSite;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by alexandriann on 02/01/16.
 */
public class VideoDownloaderTest {

    public static final String COURSE_TITLE = "The Ultimate Yoga Pose Library with Erin Motz";
    public static final String VIDEO_URL = "https://10-lvl3-pdl.vimeocdn.com/01/3338/3/91693181/243451610.mp4?expires=1451822594&token=0acf6ea22b7cfadc38dad";

    private SecureSite doYouYogaSite = new DoYouYogaSite();
    private VideoDownloader videoDownloader;

    @Before
    public void setUp() {
        videoDownloader = new VideoDownloader(doYouYogaSite);
    }

    @Test
    public void downloadVideosTest() throws Exception {
        videoDownloader.downloadVideos();

        assertTrue(new File("./resources/videos/"+COURSE_TITLE).listFiles().length == 92);
    }

    @Test
    public void downloadVideo() throws Exception {
        Utils.downloadVideo(VIDEO_URL, new File("./resources/videos/test.mp4"));

        assertTrue((new File("./resources/videos/").listFiles()).length == 1);
    }

}
