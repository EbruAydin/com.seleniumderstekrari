package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BestBuyAssertion {
    /*
    https://www.bestbuy.com/ adresine gidin farkli test methodlari olusturarak asagidaki testleri yapin
    Sayfa URl'nin https://www.bestbuy.com/'a esit oldugunu test edin
    titleTest=>Sayfa basliginin "Rest" icermedigini(contains) test edin
    logoTest=>BestBuy logosunun goruntulendigini test edin
    FrancaisLinkTest=>Fransizca Linkin gorunutlendigini test edin.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void urlTest(){
        //Sayfa URl'nin https://www.bestbuy.com/'a esit oldugunu test edin

        Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    }
    @Test
    public void titleTest(){
        //  titleTest=>Sayfa basliginin "Rest" icermedigini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void logoTest(){
        //logoTest=>BestBuy logosunun goruntulendigini test edin

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }


    @Test
    public void FrancaisLinkTest(){
        //FrancaisLinkTest=>Fransizca Linkin gorunutlendigini test edin.

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());
    }

}
