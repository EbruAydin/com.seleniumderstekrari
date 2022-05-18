package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class meryem {
        /*
             https://www.youtube.com adresine gidin
            Asagidaki adlari kullanarak 3 test methodu olusturun ve gerekli testleri yapin
           titleTest->Sayfanin basliginin YouTube oldugunu test edin
           imageTest->YouTube resminin goruntulendigini test edin
           Search Box'in erisilebilir oludugunu test edin
           wrongTitleTest->Sayfa Basligiini
        */
        WebDriver driver;
        @Before
        public void before() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //https://www.youtube.com adresine gidin
            driver.get("https://www.youtube.com");
            driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        }
        @After
        public void after() {
            //driver.close();
        }
        @Test
        public void titleTest() {
            //  //Asagidaki adlari kullanarak 3 test methodu olusturun ve gerekli testleri yapin
            //        titleTest->Sayfanin basliginin YouTube oldugunu test edin
            String asilTitle = driver.getTitle();
            String arananTitle = "YouTube";
            Assert.assertTrue("Title test failed", asilTitle.equals(arananTitle));
        }
        @Test
        public void imgTest() {
            //        imageTest->YouTube resminin goruntulendigini test edin
            WebElement imgTest = driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo'][1]"));
            Assert.assertTrue("img test failed", imgTest.isDisplayed());
        }
        @Test
        public void searchBox() {
            //        Search Box'in erisilebilir oludugunu test edin
            WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
            if (searchBox.isDisplayed()) System.out.println("search box erisilebilir");
            else System.out.println("searchbox test filed");
        }
        @Test
        public void wrongTitleTest() {
            //        wrongTitleTest->Sayfa Basligiini
            String actuelTitle=driver.getTitle();
            String wrongTitle="yetube";
            Assert.assertFalse("wrongTitle failed",!(actuelTitle.equals(wrongTitle)));
        }
    }

