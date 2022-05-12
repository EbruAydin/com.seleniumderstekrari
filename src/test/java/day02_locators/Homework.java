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
        searchBox.sendKeys("city bike" +Keys.ENTER);

        //        3-Amazon'da goruntulenen ilgili sonuclarin sayisini yazdirin
        //WebDriver aramaSonucu=driver.findElement(By.xpath());


        //        4-"Shopping'e tiklayin


        //        5-Sonra karsiniz cikan ilk sonucun resmine tiklayin

        /*
        WebElement aramaSonuc = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        String[] sonucTextArrays = aramaSonuc.getText().split(" ");
        System.out.println("İlgili Arama Sonucu : " + sonucTextArrays[sonucTextArrays.length-3]);
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));
        ilkUrun.click();
​
​
        Thread.sleep(5000);
        driver.close();
         */
    }
}
