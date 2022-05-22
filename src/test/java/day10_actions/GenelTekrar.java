package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;


import java.util.*;
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

    static String fiyat1;
    static String baslik1;
    static String fiyat2;
    static String baslik2;

    @Test
    public void test01() {
        //amazona gidin
        driver.get("https://www.amazon.com");

        //    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdirin
        WebElement searchBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select obj = new Select(searchBox);

        System.out.println("\n=======DropDown Menu Icerigi=========");
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

        //arama kutusuna iphone yazip aratin
        //acttions denemesi yapildi
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(searchBox).sendKeys("iphone" + Keys.ENTER).perform();

        // bulunan sonuc sayisini yazdirin
        System.out.println("\n=======ilk urun bilgileri=========");
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] sonucSayisi = sonuc.getText().split(" ");
        Arrays.stream(sonucSayisi).
                limit(4).
                skip(3).
                forEach(t -> System.out.println("iphone icin sonuc sayisi = " + t));

        //    sonuc sayisi bildiren yazisinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().
                contains("iphone"));

        //    ikinci urune relative locator kullanarak tiklayin
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).below(firstProduct));
        actions.click(secondProduct).perform();


        //    urunun title'ini ve fiyaitni variable'a assign edip urunu sepete ekleyin
        baslik1 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("Ilk Urun Baslik : " + baslik1);
        fiyat1 = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium']")).getText();
        System.out.println("Ilk Urun Fiyati : " + fiyat1);

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
        System.out.println("\n=======ikinci urun bilgileri=========");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Baby stroller" + Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] sonucSayisi = sonuc.getText().split(" ");
        Arrays.stream(sonucSayisi).
                limit(4).
                skip(3).
                forEach(t -> System.out.println("Baby stroller sonuc sayisi = " + t));

        //    sonuc yazsinin puset icerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("stroller"));


        //    ucuncu urune relative locator kullanarak tiklayin
        WebElement secondProducy = driver.findElement(By.xpath("(//img[@class='s-image'])[3]"));
        WebElement thirdProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).below(secondProducy));
        thirdProduct.click();

        //    title ve fiyat bilgilerini assign edelim ve sepete ekleyelim
        baslik2 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("Ikinci urun baslik : " + baslik2);

        try {
            fiyat2 = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium']")).getText();
            System.out.println("Ikinci Urun Fiyati : " + fiyat2);
        } catch (Exception e) {
            System.out.println("urun fiyati bulunamadi");
        }

        WebElement sepet = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        sepet.click();

    }


    @Test
    public void test04() {
        // sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
        WebElement goToCart = driver.findElement(By.cssSelector("[href='/gp/cart/view.html?ref_=sw_gtc']"));
        //https://www.amazon.com/gp/cart/view.html?ref_=sw_gtc
        //https://www.amazon.com/gp/cart/view.html?ref_=sw_gtc
        goToCart.click();



        System.out.println("\n=======sepetteki urunlerin baslik bilgileri=========");
        String sepettekiIlkUrunBaslik=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-product-title'])[1]")).getText();
        System.out.println(sepettekiIlkUrunBaslik);
        String sepettekiIkinciUrunBaslik=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-product-title'])[2]")).getText();
        System.out.println(sepettekiIkinciUrunBaslik);

        Assert.assertEquals(sepettekiIlkUrunBaslik, baslik2);
        Assert.assertEquals(sepettekiIkinciUrunBaslik, baslik1);

        System.out.println("\n=======sepetteki urunlerin fiyat bilgileri=========");
        //String sepettekiIlkUrunFiyat=driver.findElement(By.xpath("(//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last'])[1]")).getText();
        //String sepettekiIlkUrunFiyat=driver.findElement(By.xpath("(//span[@class='a-price sc-product-price'])[1]")).getText();
        String sepettekiIlkUrunFiyat=driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]")).getText();
        System.out.println(sepettekiIlkUrunFiyat);
       // String sepettekiIkinciUrunFiyat=driver.findElement(By.xpath("(//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last'])[2]")).getText();
        //String sepettekiIkinciUrunFiyat=driver.findElement(By.xpath("(//span[@class='a-price sc-product-price'])[2]")).getText();
        String sepettekiIkinciUrunFiyat=driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();
        System.out.println(sepettekiIkinciUrunFiyat);


        Assert.assertEquals(fiyat2, sepettekiIlkUrunFiyat);
        Assert.assertEquals(fiyat1,sepettekiIkinciUrunFiyat);


    }
}
