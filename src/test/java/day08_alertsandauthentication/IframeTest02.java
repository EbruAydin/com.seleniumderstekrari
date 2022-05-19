package day08_alertsandauthentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest02 {
    /*
    https://demo.guru99.com/test/guru99home/ gidiniz
    -sayfadaki iframe sayisini yazdiriniz
    -ilk iframe'deki Youtube play butonuna basiniz
    -ilk iframe'den cikip anasayfaya donun
    -ikinci iframe'deki (Jmeter Made Easy) linke https://www.guru99.com/live-selenium-project.html tiklayin
     */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.guru99.com/test/guru99home/");

    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void iframe(){
        //-sayfadaki iframe sayisini yazdiriniz
        // ilk iframe'deki Youtube play butonuna basiniz

        // ilk iframe'den cikip anasayfaya donun

        //ikinci iframe'deki (Jmeter Made Easy) linke https://www.guru99.com/live-selenium-project.html tiklayin
    }
}
