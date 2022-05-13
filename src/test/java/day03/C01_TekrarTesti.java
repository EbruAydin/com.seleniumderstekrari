package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class C01_TekrarTesti {
    /*
       bu adrese gidin: https://www.amazon.com/
        1-browseri tam sayfa yapin
        2-Sayfayi refresh yapin
        3-Sayfa basliginin 'Spend less" ifadesi icerdigini test edin
        4-Gift Cards sekmesine basin
        5-Birthday butonuna basin
        6-Best Seller bolumunden ilk urunu tiklayin
        7-Gift card details'den 25$'i secin
        8-Urun ucretinin 25$ oldugunu test edin
        9-sayfayi kapartin
         */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //bu adrese gidin: https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //        1-browseri tam sayfa yapin
        driver.manage().window().maximize();
        //        2-Sayfayi refresh yapin
        driver.navigate().refresh();
        //        3-Sayfa basliginin 'Spend less" ifadesi icerdigini test edin

        String actualTitle=driver.getTitle();
        String expectedTitle="Spend less";

        if(actualTitle.contains(expectedTitle))
            System.out.println("Title testi PASSED");
        else System.out.println("Title testi FAILED");

        //        4-Gift Cards sekmesine basin
        /*
        uzun yol
        WebElement giftCard=driver.findElement(By.xpath("(//*[text()='Gift Cards'])[1]"));
        giftCard.click();
         */
        //bir defa kullanacagimiz ve click hemen ardindan istendigi icin kisa yolu tercih ettim:
        driver.findElement(By.xpath("(//*[text()='Gift Cards'])[1]")).click();
        //        5-Birthday butonuna basin
        driver.findElement(By.xpath("//img[@*='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png']")).click();

        //        6-Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@*='Amazon.com eGift Card'])[1]")).click();
        //        7-Gift card details'den 25$'i secin
        WebElement giftCard=driver.findElement(By.xpath("(//*[@class='a-button a-button-toggle'])[1]"));
        giftCard.click();
        //List<WebElement> elementListesi=driver.findElements(By.id("gc-mini-picker-amount-1"));


        //        8-Urun ucretinin 25$ oldugunu test edin
        String actualValue=giftCard.getText();
        String urunUcreti="$ 25";

        if(actualValue.equals(urunUcreti))
            System.out.println("urun ucreti $25");
        else System.out.println("gift card selected testi failed");
        //        9-sayfayi kapartin



    }
}
