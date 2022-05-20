package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenelTekrar extends TestBaseClass {

    /*
    test1
    amazona gidin
    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
    dropdown menusunde 40 eleman oldugunu dogrulayin

    test2
    dropdown menuden elektronik bolumu secin
    arama kutusuna iphone yazip aratin ve bulunan sonuc sayisini yazdirin
    sonuc sayisi bildiren yazisinin iphone icerdigini test edin
    ikinci urune relative locator kullanarak tiklayin
    urunun title'ini ve fiyaitni variable'a assign edip urunu sepete ekleyin

    test3
    yeni bir sekme acarak amazon sayfasina gidin
    dropdown'dan bebek bolumunu secin
    bebek puset aratip bulunan sonuc sayisini yazdirin
    sonuc yazsinin puset icerdigini test edin
    ucuncu urune relative locator kullanarak tiklayin
    title ve fiyat bilgilerini assign edelim ve sepete ekleyelim

    test 4
    sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
     */


    @Test
    public void test01() {
        //amazona gidin
        driver.get("https://www.amazon.com");
        //    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
        WebElement searchBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select obj = new Select(searchBox);

        obj.getOptions().stream().
                collect(Collectors.toList()).
                forEach(t -> System.out.println(t.getText()));

        //    dropdown menusunde 28 eleman oldugunu dogrulayin
        int expectedNumber = 28;
        //int actualNumber= obj.getOptions().size();//28
        Assert.assertEquals(expectedNumber, obj.getOptions().size());
    }

    @Test
    public void test02() {
        //dropdown menuden elektronik bolumu secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select obj = new Select(dropDown);
        obj.selectByIndex(10);

        //    arama kutusuna iphone yazip aratin ve bulunan sonuc sayisini yazdirin
        //acttions denemesi yapildi
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(searchBox).sendKeys("iphone" + Keys.ENTER).perform();

        //    sonuc sayisi bildiren yazisinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().
                contains("iphone"));
        //    ikinci urune relative locator kullanarak tiklayin

        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).below(firstProduct));
        actions.click(secondProduct).perform();



        //    urunun title'ini ve fiyaitni variable'a assign edip urunu sepete ekleyin
        String FirstProductTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String FirstProductPrice = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]")).getText();

        WebElement sepet = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        actions.click(sepet).perform();


    }



    @Test
    public void test03() {
        //yeni bir sekme acarak amazon sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //    dropdown'dan bebek bolumunu secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select obj = new Select(dropDown);
        obj.selectByVisibleText("Baby");

        //    bebek puset aratip bulunan sonuc sayisini yazdirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Baby stroller" + Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[]sonucSayisi=sonuc.getText().split(" ");
        Arrays.stream(sonucSayisi).limit(4).skip(3).forEach(t-> System.out.println("sonuc sayisi = " + t));

        //    sonuc yazsinin puset icerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("stroller"));


        //    ucuncu urune relative locator kullanarak tiklayin
        WebElement secondProducy = driver.findElement(By.xpath("(//img[@class='s-image'])[3]"));
        WebElement thirdProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).below(secondProducy));
        thirdProduct.click();

        //    title ve fiyat bilgilerini assign edelim ve sepete ekleyelim

        WebElement productTitle2=driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement productPrice2= driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]"));
        WebElement sepet = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        sepet.click();
    }



    @Test
    public void test04() {
        // sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
        WebElement goToCart=driver.findElement(By.id("sw-gtc"));
        goToCart.click();

        List<WebElement> titleList=driver.findElements(By.className("a-truncate-cut"));

        titleList.
                stream().
                forEach(t-> System.out.println(t.getText()));


        List<WebElement> priceList=driver.findElements(By.className("a-price-whole"));
        priceList.
                stream().
                forEach(t-> System.out.println(t.getText()));




        /*
        String sepetTekiIlkUrunBaslik=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();
        String sepetTekiIkinicUrunBaslik=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();

        String sepettekiIlkUrunFiyat=driver.findElement(By.xpath("(//(//span[@class='a-price-whole'])[2])")).getText();
        String sepettekiIkinciUrunFiyat=driver.findElement(By.xpath("(//(//span[@class='a-price-whole'])[3])")).getText();
         */


    }
}
