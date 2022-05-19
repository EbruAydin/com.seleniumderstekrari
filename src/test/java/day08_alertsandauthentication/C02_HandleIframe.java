package day08_alertsandauthentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleIframe {


   /*
   https://the-internet.herokuapp.com/iframe adresine gidin
   bir method olusturun:iframeTest
   -"An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsolda yazdirin
   -Text Box'a "Merhaba Dunya" yazin
   -TextBox'in altinda bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayin
   ve konsolda yazdirin
    */

     WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void iframe(){

        driver.get("https://the-internet.herokuapp.com/iframe");
        //   -"An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //   -Text Box'a "Merhaba Dunya" yazin

        /*
        WebElement textBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
          textBox.sendKeys("Mehaba Dunya");

        Once bunu yaptikbunu yaptik ama calismadi,
        bu durumlarda kodlarimizdan emin isek html kodlarini incelemek gerekir.
        iframe icerisinde oldugu icin NoSuchElement expection aldik.

        Bu nedenle iframe'i switchTo ile gecmeye calistik
         */
        WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement textBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Mehaba Dunya");

        //   -TextBox'in altinda bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayi ve konsolda yazdirin

        /*
        iframe icerisine girdigimiz icin simid once cikmamiz gerekir ki sonra linkin gorunur oldugunu yapabilelim
        bunun icin once cikacaz iframe'den sonra bu elementi locate edip islemi gerceklestirecegiz
         */

        driver.switchTo().defaultContent();//ana sayfaya donmeyi saglar ve direk olarak iframe'den cikmis olur

        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());




    }

}
