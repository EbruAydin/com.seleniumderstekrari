package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice {
    public static void main(String[] args) {
         /*
        1 ) Bir class oluşturun : Locators_css
2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
    b. Locate email textbox
    c. Locate password textbox ve
    d. Locate signin button
    e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        i. Username : testtechproed@gmail.com
        ii. Password : Test1234!
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in

        driver.get("http://a.testaddressbook.com/sign_in");
        //    b. Locate email textbox
        //    c. Locate password textbox ve
        //    d. Locate signin button
        //    e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //        i. Username : testtechproed@gmail.com
        //        ii. Password : Test1234!

        //Locate ile Cozum
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        WebElement signInButonu=driver.findElement(By.name("commit"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();

        /*
        xpath ile cozum
        ===============
        WebElement emailTextBox=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        WebElement passwordTextBox=driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        WebElement signInButonu=driver.findElement(By.xpath("(//input[@type='submit'])"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
         */


        //css locater kismi eksik

        driver.close();

    }
}
