import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest{

    @Step("<id> uygulamanin acildiğini kontrol et")
    public void Assert(String id){
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        ELogger.logger.info("Uygulamanin acildigi kontrol edildi");
    }

    @Step("<int> saniye bekle")
    public void waitForsecond(int s) throws InterruptedException {
        Thread.sleep(1000 * s);
        ELogger.logger.info(s + " saniye beklendi ");
    }


    @Step("<id> Alışveriş butonuna tıkla")
    public void startShop (String id){
        appiumDriver.findElement(By.id(id)).click();
        ELogger.logger.info("Butonuna Tiklandi");
        }

    @Step("<id> Alışveriş Sayfasının açıldığı kontrol edililr")
    public void AssertPag(String id){
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        ELogger.logger.info("sayfa açildi");
    }

    @Step("<id> Kategoriler butonuna tıkla")
    public void pressCategory(String id){
        appiumDriver.findElement(By.id(id)).click();
        ELogger.logger.info("Kategoriler butonuna tiklandi");

    }

    @Step("<id> Kategorilerin açıldığı kontrol edilir")
    public void AssertPage(String id){
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        ELogger.logger.info("kategoriler açildiği doğrulandi");
        }

    @Step("menüden kadın seçeneğine tıklanır")
    public void clickWomen(){
    MobileElement element = appiumDriver.findElement(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'][2]"));
    element.click();
    ELogger.logger.info("Kadin butonuna tiklandi");
    }

    @Step("<xpath> pantolon seçeneğine tıklanır")
    public void clickMan(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        ELogger.logger.info("pantolon  butonuna tiklandi");
    }

    @Step("Sayfa Aşağı Kaydırılır")
    public void scrollDown() {
        int startx = 717, starty = 2569, endx = 723, endy = 490;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();
        ELogger.logger.info("Sayfa Asagi Dogru Kaydirildi");
    }
    @Step("Rastgele bir ürün secilir")
    public void selectRandom() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\t\n" +
                "com.ozdilek.ozdilekteyim:id/textView"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
        ELogger.logger.info("Rastgele ürün seçimi yapıldı");
    }


    @Step("<id> Ürün detay sayfası açıldığı kontrol edilir")
    public void AssertPag(String id){
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        ELogger.logger.info("sayfa açildi");

    }

}





