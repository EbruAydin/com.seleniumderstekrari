package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NailsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- amazon.com'a gidip arama kutusunu locate edin
        driver.get("http://amazon.com");
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //2- arama kutusunun tagName'inin input oldugunu test edin

        String dogrulamakutu = "input";
        String dogrulamakutu1 = aramakutusu.getTagName();
        if (dogrulamakutu.equals(dogrulamakutu1)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED");
        }
        //3- arama kutusunun name attribute'nun degerinin field-keywords oldugunu test edin
        String dogrulamaname = "field-keywords";
        String dogrulamaname1 = aramakutusu.getAttribute("name");
        if (dogrulamaname1.equals(dogrulamaname)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED");
        }

        //kapat
    }
    }

