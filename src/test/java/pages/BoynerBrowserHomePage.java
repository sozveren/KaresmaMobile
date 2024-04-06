package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;
import utils.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class BoynerBrowserHomePage {
    public BoynerBrowserHomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(BrowserDriver.getBrowserDriver(), Duration.ofSeconds(15)), this);
    }
    @FindBy(xpath = "//h1]")
    public static List<WebElement> headerMainTitleMenu;

    public void getHomePageBoyner(String url) {
        BrowserDriver.getBrowserDriver().get(url);

    }
    public void isDisplayedBoynerHeader() {

        boolean found = false;
        for (WebElement actualBaslik : headerMainTitleMenu) {
            if (actualBaslik.isDisplayed() && actualBaslik.isEnabled()) {
                ReusableMethods.wait(1);
                System.out.println(actualBaslik.getText());
                found = true;
            }
        }
    }
}
