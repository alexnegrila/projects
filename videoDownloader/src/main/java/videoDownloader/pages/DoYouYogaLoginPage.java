package videoDownloader.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexandriann on 03/01/16.
 */
public class DoYouYogaLoginPage implements LoginPage {
    @FindBy(name = "user_name")
    private WebElement usernameField;
    @FindBy(name = "user_pass")
    private WebElement passwordField;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
}
