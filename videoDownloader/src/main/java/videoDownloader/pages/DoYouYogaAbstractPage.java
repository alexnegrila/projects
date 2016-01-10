package videoDownloader.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexandriann on 03/01/16.
 */
public class DoYouYogaAbstractPage implements SecurePage{

    @FindBy(className = "dyy_header_login_btn")
    private WebElement headerLogin;

    public WebElement getHeaderLogin() {
        return headerLogin;
    }

}
