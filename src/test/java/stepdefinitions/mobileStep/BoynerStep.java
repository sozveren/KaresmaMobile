package stepdefinitions.mobileStep;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BoynerHomePage;
import utils.Driver;
import utils.ReusableMethods;

public class BoynerStep {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    BoynerHomePage page = new BoynerHomePage();

    @Given("The user goes to the relevant App.")
    public void the_user_goes_to_the_relevant_url() {
    page.appFirstLaunch();
    }
    @Given("The elements in the Footer section are verified by the user.")
    public void the_elements_in_the_footer_section_are_verified_by_the_user() {
        page.verifyFooterMenu();
        page.footerMenu.get(2).click();
        ReusableMethods.scrollWithUiScrollableAndClick("KADIN");
        for (int i = 0; i < page.elementsOffooterMenu.size(); i++) {
            System.out.println(page.elementsOffooterMenu.get(i).getText());
        }
    }
    @Given("Displaying {string} elements in the footer section {string}")
    public void displaying_elements_in_the_header_section(String menu, String kategoriler) {
        page.verifyTheMenu(menu,kategoriler);

    }

    @Then("Verifying {string} elements up to {string} in the footer section {string}")
    public void displaying_elements_in_the_footer_section(String menu,String lastMenu, String kategoriler) {
        page.verifySubMenuTitle(menu,lastMenu, kategoriler);
    }
    @Given("Verifying {string} subMenu  elements  {string} subMenu  in the footer section {string}")
    public void verifying_sub_menu_elements_sub_menu_in_the_footer_section(String subMenu, String menu, String kategoriler) {
        //page.accessTheMenu(menu,kategoriler);
        ReusableMethods.scrollWithUiScrollableAndClick(subMenu);
        Assert.assertTrue(page.subMenuTitle.getText().contains(subMenu));
        System.out.println(subMenu+" "+ page.subMenuTitle.getText());
    }
    @Given("Verifying {string} subMenu  elements  {string} subMenu  in the footer section {string}.")
    public void verifying_sub_menu_elements_sub_menu_in_the_footer_section1(String subMenu, String menu, String kategoriler) {
        page.accessTheMenu(menu,kategoriler);
        ReusableMethods.scrollWithUiScrollableAndClick(subMenu);
        Assert.assertTrue(page.subMenuTitle.getText().contains(subMenu));
        System.out.println(subMenu + " " + page.subMenuTitle.getText());
    }
    @Given("Verify the filtering menu is displayed")
    public void verify_the_filtering_menu_is_displayed() {
        page.filterProduct.click();
        page.verifyFooterMenu();

    }
    @Given("Verified that filtering is done for the {string} of {string} option in the filtering menu.")
    public void verified_that_filtering_is_done_for_the_of_option_in_the_filtering_menu(String filteringOption, String filteringMenu) {

     //ReusableMethods.scrollWithUiScrollableAndClick(filteringMenu);
        page.firstoption.click();
     ReusableMethods.scrollWithUiScrollableAndClick(filteringOption);
     ReusableMethods.scrollWithUiScrollableAndClick("UYGULA");
     page.urunuGorButton.click();
     Assert.assertEquals(filteringOption,page.productBrand.getText());
    }
    @Given("The user closes the application.")
    public void the_user_closes_the_application() {
    Driver.quitAppiumDriver();
    }
    @Given("Click {int} .  product on the list")
    public void click_product_on_the_list(Integer orderOfProduct) {
    page.getOrderOfProduct(orderOfProduct);
    }
    @Given("Click {string} button")
    public void click_sepete_ekle_button(String sepeteEkle) {
       ReusableMethods.scrollWithUiScrollableAndClick(sepeteEkle);
    }
    @Given("Verify that the product in the cart is the correct product")
    public void verify_that_the_product_in_the_cart_is_the_correct_product() {
    Assert.assertTrue(page.sepeteEklendiAlert.isDisplayed());
    }



}
