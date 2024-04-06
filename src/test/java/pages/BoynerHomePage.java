package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BoynerHomePage {
    public BoynerHomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    @FindBy(id = "com.mobisoft.boyner:id/ll_boyner")
    public MobileElement loginToApp;
    @FindBy(id = "com.mobisoft.boyner:id/navigation_bar_item_large_label_view")
    public MobileElement anasayfaIcon;
    @FindBy(className = "android.widget.TextView")
    public List<MobileElement> footerMenu;
    @FindBy(className = "android.widget.LinearLayout")
    public List<MobileElement> elementsOffooterMenu;
    @FindBy(xpath = "(//*[@resource-id='com.mobisoft.boyner:id/navigation_bar_item_icon_view'])[2]")
    public MobileElement kategorilerButton;
    @FindBy(id = "com.mobisoft.boyner:id/tvPageTitle")
    public MobileElement subMenuTitle;
    @FindBy (id = "com.mobisoft.boyner:id/rlFilterProduct")
    public MobileElement filterProduct;
    @FindBy (id = "com.mobisoft.boyner:id/tvApplyFilter")
    public MobileElement urunuGorButton;
    @FindBy (id = "com.mobisoft.boyner:id/tvProductBrand")
    public MobileElement productBrand;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement firstoption;
    @FindBy (id = "com.mobisoft.boyner:id/snackbar_text")
    public MobileElement sepeteEklendiAlert;

    public void appFirstLaunch() {
        loginToApp.click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Konum bilgisini kullanmadan devam et");
        Assert.assertTrue(anasayfaIcon.isDisplayed());
    }

    public void verifyFooterMenu() {
        for (int i = 1; i < footerMenu.size(); i++) {
            Assert.assertTrue(footerMenu.get(i).isDisplayed());
            Assert.assertTrue(footerMenu.get(i).isEnabled());
            System.out.println(footerMenu.get(i).getText());
        }
    }
    public void accessTheMenu(String menu, String kategoriler){

        ReusableMethods.scrollWithUiScrollableAndClick(kategoriler);
        ReusableMethods.wait(2);
        ReusableMethods.ekranKaydirmaMethodu(453, 1622, 750, 453, 271);
        ReusableMethods.scrollWithUiScrollableAndClick(menu);
        ReusableMethods.wait(2);
    }
    public void verifyTheMenu(String menu, String kategoriler){

        ReusableMethods.scrollWithUiScrollableAndClick(kategoriler);
        ReusableMethods.wait(2);
        verifyFooterMenu();
        ReusableMethods.ekranKaydirmaMethodu(453, 1622, 750, 453, 271);
        ReusableMethods.wait(2);
        verifyFooterMenu();
        ReusableMethods.scrollWithUiScrollableAndClick(menu);

    }

    String[] subMenuListEvYasam = {"Yeni Gelenler", "Çok Satanlar", "İndirimli Ürünler", "Elektrikli Ev Aletlerinde Özel Fiyatlar",
            "Hediye Önerileri", "Sofra & Mutfak", "Sofra & Mutfak", "Banyo", "Dekorasyon & Aksesuar", "Elektrikli Ev Aletleri",
            "Fotoğraf & Kamera", "Aydınlatma", "Aydınlatma", "Plaj Tekstili", "Gurme", "Atıştırmalıklar", "Kırtasiye", "Kitap", "İçecekler",
            "Takviye Edici Gıdalar", "Evcil Hayvan Ürünleri", "Trendler", "Markalar"};

    public void verifySubMenuTitle(String menu, String lastMenu, String kategoriler) {
        //accessTheMenu(menu,kategoriler);
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriler);
        ReusableMethods.wait(2);
        verifyFooterMenu();
        ReusableMethods.ekranKaydirmaMethodu(453, 1622, 750, 453, 271);
        ReusableMethods.wait(2);
        verifyFooterMenu();
        ReusableMethods.scrollWithUiScrollableAndClick(menu);
        ReusableMethods.wait(2);
        for (int i = 3; i <= 9; i++) {
            Assert.assertTrue(footerMenu.get(i).isDisplayed());
            Assert.assertTrue(footerMenu.get(i).isEnabled());
            System.out.println(footerMenu.get(i).getText());
            if (Objects.equals(footerMenu.get(i).getText(), lastMenu)) {
                i = 10;
            } else if (i == 9) {
                ReusableMethods.ekranKaydirmaMethodu(453, 1735, 750, 1242, 453);
                ReusableMethods.wait(2);
                i = 3;
            }}}
    public void getOrderOfProduct(int sequenceNumber){
        String dynamicXpath = "(//*[@resource-id='com.mobisoft.boyner:id/tvProductName'])["+sequenceNumber+"]";
        MobileElement orderOfProduct = driver.findElement(By.xpath(dynamicXpath));
        orderOfProduct.click();
    }





}
