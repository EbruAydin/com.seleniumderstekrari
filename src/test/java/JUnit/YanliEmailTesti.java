package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanliEmailTesti {
    /*
    https://www.automationpractice.com/index.php adresine gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
    'Invalid email adress'uyarisi cikitigni test edin.
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test(){
        driver.get("https://www.automationpractice.com/index.php");

        /*
        Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
    'Invalid email adress'uyarisi cikitigni test edin.
         */

        driver.findElement(By.xpath("//*[@class='login']")).click();
        //index ile aldim click yapmadi, class ile alinca oldu

        WebElement mail=driver.findElement(By.xpath("//*[@id='email_create']"));
        mail.sendKeys("ebraydn" + Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());

    }
}
