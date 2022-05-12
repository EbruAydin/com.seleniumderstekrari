package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;


public class AmazonSearchTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // a.google web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // b. Search(ara) “city bike”
        //WebElement aramaButonu=driver.findElement(By.id("twotabsearchtextbox")); id yerine xpath denedim
        WebElement aramaButonu=driver.findElement(By.xpath("//input[@type='text']"));
        aramaButonu.sendKeys("city bike" + Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

        WebElement ilgiliSonuc=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucu[]=ilgiliSonuc.getText().split(" ");

        System.out.println("Arama sonucu : ");
        Arrays.stream(aramaSonucu).
                limit(3).
               skip(2).forEach(System.out::print);


        // e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        WebElement ilkCikanResim=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkCikanResim.click();

        driver.close();


    }
}

