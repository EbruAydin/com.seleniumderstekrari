package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();


        //ChromeDriver kullanarak,facebook sayfasina gidin ve sayfa basliginin "facebook"
        //oldugunu dogrulayin, degilse dogru basligi yazdirin

        driver.get("https://www.facebook.com");

        String actualTitle=driver.getTitle();
        String expectedTItle="facebook";

        if(actualTitle.equals(expectedTItle))
            System.out.println("aranan baslik " +expectedTItle+"gercek title " + actualTitle + "ile eslesiyor." );
        else System.out.println("aranan baslik actual baslik ile eslesmiyor. Actual baslik sudur : " + actualTitle);

        //Sayfa URL'nin facebook kelimesi icerdigini dogrulayin, icermiyorsa "actual" URLyi yazdirin
        System.out.println("***********");
       String actualUrl= driver.getCurrentUrl();
       String arananKelime="facebook";

       if(actualUrl.contains(arananKelime))
           System.out.println("aranan kelime " + arananKelime+ " actual url olan " +actualUrl + " icerisinde yer aliyor");
       else System.out.println("aranan keliem " + arananKelime+" "+ actualUrl + " de yer almiyor");

        //https:www.walmart.com/ sayfasina gidin
        System.out.println("***********");
        driver.navigate().to("https:www.walmart.com/ ");

        //sayfa basliginin "Walmart.com" icerdigini dogrulayin
        String actualTitle2=driver.getTitle();
        String arananKelime2="Walmart.com";

        if(actualTitle2.contains(arananKelime2))
            System.out.println("Test Passed");
        else System.out.println("Test Failed");

        //tekrar facebook sayfasina geri donun
        driver.navigate().back();
        //sayfayi yineleyin
        driver.navigate().refresh();
        //sayfayi maximize yapin
        driver.manage().window().maximize();
        //browseri kapatin
        driver.close();
    }
}
