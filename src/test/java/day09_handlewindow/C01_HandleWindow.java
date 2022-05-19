package day09_handlewindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindow {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void tets01() {

        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        // nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        String firstWindowHandleId=driver.getWindowHandle();
        /*
        getWIndowHandle bize hashcode getirir yani sayfaya ait unique kodu ancak bunu kullanarak
        geriye gidebiliriz ya da windowlar arasi gecis yapabiliriz

        yeni bir tab'e gecerken driver.switchTo().newWindow(WindowType.TAB); kullaniriz
        eskisine geri donmek icin ise   driver.switchTo().window(firstWindowHandleId); kullaniriz
         */

        //ilk urunun resmini tiklayarak farkli bir tab olarak acin
        /*
        //WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        bunu yapsan bile sonrasinda ilkUrunResmi.click() yaptiginda olmuyor, yeni tab ile acilan sayfada WebElement'i bastan yine cagirmak
        gerekiyor ve sonrasinda click yapiyorsun
         */

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //yeni tah'da acilan urunun basligini yazdiralim
        WebElement productTitle=driver.findElement(By.xpath("(//h1)[1]"));
        System.out.println(productTitle.getText());

        //ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(firstWindowHandleId);
        System.out.println(driver.getCurrentUrl());
    }
}
