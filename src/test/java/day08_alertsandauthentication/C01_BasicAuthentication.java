package day08_alertsandauthentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BasicAuthentication {
    /*
    bizim authentication mevzusunu halledebilmemiz icin ilgili kurumun bizi bilgilendirmesi gerekir
    yani authentication'i asmamiz icin bize nasil yapabilecegimizi soylemesi gerekir ki ancak o sekilde
    otomasyon yapabiliriz.

    mesela herkuapp sitesinde su sekilde asilabilecegi belirtilmistir:
    html komutu: https://username:password@URL bilgilerini girerek yapabiliriz
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        // html komutu: https://username:password@URL
        //Username: admin
        //password: admin
        //yani==> https://admin:admin@the-internet.herokuapp.com/basic_auth

        driver.get(" https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }


}
