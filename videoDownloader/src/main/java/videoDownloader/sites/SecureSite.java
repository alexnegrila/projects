package videoDownloader.sites;

import videoDownloader.Constants;
import videoDownloader.configuration.Configuration;

/**
 * Created by alexandriann on 02/01/16.
 */
public abstract class SecureSite {

    public abstract String getHostName();
    public abstract String getStartURL();

    public abstract Class getHomePage();

    public String getUsername(){
        return getSitePropertyValue(Constants.USER_NAME);
    }

    public String getPassword(){
        return getSitePropertyValue(Constants.PASSWORD);
    }

    public String getSitePropertyValue(String property) {
        return Configuration.getInstance().getPropertyValue(getHostName() + Constants.DOT + property);
    }

    public abstract Class getLoginPage();

    public abstract Class getStartPage();
}
