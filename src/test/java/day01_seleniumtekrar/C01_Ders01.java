package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Ders01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();//ekrani buyuk yapmaya calsiri


        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

        driver.close();


    }
}
