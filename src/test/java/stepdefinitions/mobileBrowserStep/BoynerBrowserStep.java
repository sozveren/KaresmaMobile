package stepdefinitions.mobileBrowserStep;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BoynerBrowserHomePage;
import utils.BrowserDriver;
import utils.TestData;

public class BoynerBrowserStep {

    BoynerBrowserHomePage browserHomePage = new BoynerBrowserHomePage();

    @Given("The user goes to the relevant {string}.")
    public void the_user_goes_to_the_relevant_url(String url) {
        browserHomePage.getHomePageBoyner(url);
    }
    @Given("Verifies that the user is on the Homepage")
    public void verifies_that_the_user_is_on_the_homepage() {
        Assert.assertEquals(TestData.boynerUrl, BrowserDriver.getBrowserDriver().getCurrentUrl());
    }
    @Given("The relevant page is closed.")
    public void the_relevant_page_is_closed() {
        BrowserDriver.quitAppiumDriver();
    }
    @Given("The elements in the Header section are verified by the user.")
    public void the_elements_in_the_header_section_are_verified_by_the_user() {
       browserHomePage.isDisplayedBoynerHeader();

    }
}
