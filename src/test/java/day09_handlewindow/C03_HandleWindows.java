package day09_handlewindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

public class C03_HandleWindows {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

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
        driver.quit();
    }

    @Test
    public void tets01() {

        driver.get("https://the-internet.herokuapp.com/windows ");
        String firstWindowHandleId=driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals("Opening a new window", driver.findElement(By.xpath("//h3")).getText());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Set<String> windowHandle=driver.getWindowHandles();
        System.out.println(windowHandle);

        String secondWindowHandleId= windowHandle.stream().
                filter(t->!t.equals(firstWindowHandleId)).
                collect(Collectors.toList()).get(0);
        /*
        String secondWindowHandleId="";

        for (String each:windowHandle) {
            if(!each.equals(firstWindowHandleId)){
                secondWindowHandleId=each;
            }
        }
         */

        //ikinci sayfaya gecebilirim simdi
       driver.switchTo().window(secondWindowHandleId);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Assert.assertEquals("New Window",driver.getTitle());

    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstWindowHandleId);
        Assert.assertEquals("The Internet",driver.getTitle());
    }
    }

