package videoDownloader;

import videoDownloader.sites.DoYouYogaSite;

/**
 * Created by alexandriann on 09/01/16.
 */
public class Application {

    public static void main(String[] args)
    {
        VideoDownloader videoDownloader = new VideoDownloader(new DoYouYogaSite());
        videoDownloader.downloadVideos();
    }
}
