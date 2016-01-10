package videoDownloader.sites;

import videoDownloader.Constants;
import videoDownloader.pages.DoYouYogaAbstractPage;
import videoDownloader.pages.DoYouYogaLoginPage;
import videoDownloader.pages.DoYouYogaCoursePage;

/**
 * Created by alexandriann on 02/01/16.
 */
public class DoYouYogaSite extends SecureSite {

    public static final String HOST_NAME = "www.doyouyoga.com";

    public String getHostName() {
        return HOST_NAME;
    }

    public String getStartURL() {
        return getSitePropertyValue(Constants.START_URL);
    }

    public Class getHomePage() {
        return DoYouYogaAbstractPage.class;
    }

    public Class getLoginPage() {
        return DoYouYogaLoginPage.class;
    }

    public Class getStartPage() {
        return DoYouYogaCoursePage.class;
    }
}
