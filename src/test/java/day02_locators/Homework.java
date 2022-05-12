package day02_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        //Amazon Search Test

        /*
        1-google web sayfasina gidip->https://www.amazon.com/
        2-Search "city bike"
        3-Amazon'da goruntulenen ilgili sonuclarin sayisini yazdirin
        4-"Shopping'e tiklayin
        5-Sonra karsiniz cikan ilk sonucun resmine tiklayin
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        //2-Search "city bike"
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike");
        //        3-Amazon'da goruntulenen ilgili sonuclarin sayisini yazdirin
        List<WebElement> goruntulenenSonuclarListesi=driver.findElements(By.tagName("a"));
        System.out.println(goruntulenenSonuclarListesi.size());

        //        4-"Shopping'e tiklayin
        WebElement shopping=driver.findElement(By.className("nav-cart-count nav-cart-0 nav-progressive-attribute nav-progressive-content"));
        shopping.click();
        //        5-Sonra karsiniz cikan ilk sonucun resmine tiklayin
    }
}
