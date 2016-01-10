package videoDownloader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videoDownloader.pages.LoginPage;
import videoDownloader.pages.SecurePage;
import videoDownloader.pages.StartPage;
import videoDownloader.sites.SecureSite;
import videoDownloader.strategies.Strategy;
import videoDownloader.strategies.StrategyFactory;

import static videoDownloader.Utils.handledWait;

/**
 * Created by alexandriann on 02/01/16.
 */
public class VideoDownloader {
    private static final Logger LOG = LoggerFactory.getLogger(VideoDownloader.class);

    WebDriver driver;
    private SecureSite secureSite;
    private SecurePage homePage;
    private StartPage startPage;

    public VideoDownloader(SecureSite secureSite) {
        this.secureSite = secureSite;
    }

    public void downloadVideos() {
        init();
        login();
        loadStartPage();
        crawl();
        tearDown();
    }

    private void init() {
        driver = new FirefoxDriver();
        driver.get(Constants.HTTP + secureSite.getHostName());
        handledWait(3000);
        homePage = (SecurePage) PageFactory.initElements(driver, secureSite.getHomePage());
    }

    private void login() {
        homePage.getHeaderLogin().click();
        handledWait(1000);
        LoginPage loginPage = (LoginPage) PageFactory.initElements(driver, secureSite.getLoginPage());
        loginPage.getUsernameField().sendKeys(secureSite.getUsername());
        loginPage.getPasswordField().sendKeys(secureSite.getPassword());
        loginPage.getPasswordField().sendKeys(Constants.ENTER_KEY);
        handledWait(5000);
    }

    private void loadStartPage() {
        driver.get(secureSite.getStartURL());
        handledWait(4000);
        startPage = (StartPage) PageFactory.initElements(driver, secureSite.getStartPage());
    }

    private void crawl() {
        final Strategy strategy;
        try {
            strategy = StrategyFactory.getStrategy(startPage, driver);
            strategy.crawl();
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(),e);
        }
    }

    private void tearDown() {
        driver.quit();
    }
}
