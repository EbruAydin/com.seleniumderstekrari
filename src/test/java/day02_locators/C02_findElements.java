package day02_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasinda kac tane link bulundugunu yazdiralim


        driver.get("https://www.amazon.com");

        List<WebElement> elementListesi=driver.findElements(By.tagName("a"));

        System.out.println("sayfadaki list sayisi : " +elementListesi.size());

        for (WebElement each:elementListesi) {
            System.out.println("elementlerin textleri :" + each.getText());
        }

        driver.close();
    }
}
