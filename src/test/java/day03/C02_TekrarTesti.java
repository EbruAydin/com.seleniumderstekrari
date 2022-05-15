package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_TekrarTesti {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");
        //cookies uyarisini kabul ederek devam edin

        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        //driver.findElement(By.Xpath("(//button[@id='L2AGLb'])")).click()
        //Sayfa basliginin "Google" ifadesi icerdigini test edin

        String actualTitle=driver.getTitle();
        String expectedTItle="Google";

        if(actualTitle.equals(expectedTItle))
            System.out.println("aranan baslik " +expectedTItle+" gercek title " + actualTitle + " ile eslesiyor." );
        else System.out.println("aranan baslik actual baslik ile eslesmiyor. Actual baslik sudur : " + actualTitle);

        //Arama cubuguna "Nutella" yazdirip aratin


       WebElement aramaCubugu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucText = sonucYazisi.getText();
        System.out.println(sonucText); //Yaklaşık 77.400.000 sonuç bulundu (0,40 saniye)

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] arr = sonucText.split(" ");
        arr[1] = arr[1].replaceAll("\\p{Punct}", "");
        String deger = arr[1]; //77400000

        int degerInt = Integer.parseInt(deger); //Integer deger : 77400000
        System.out.println("Integer deger : "+degerInt);
        System.out.println(degerInt > 10000000 ? "10M´dan büyük" : "10M´dan kücük");

        //8-Sayfayi kapatin
        driver.close();

    }
}
