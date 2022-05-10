package day01_seleniumtekrar;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();


        System.out.println("mevcut pencere boyutu : " + driver.manage().window().getSize());
        System.out.println("mevcut pencere position : " + driver.manage().window().getPosition());
        /*
        mevcut pencere boyutu : (1050, 708)
        mevcut pencere position : (10, 10)
         */

        driver.manage().window().setSize(new Dimension(900,600));
        driver.manage().window().setPosition(new Point(15,15));

        System.out.println("degisen pencere boyutu : " + driver.manage().window().getSize());
        System.out.println("degisen pencere position : " + driver.manage().window().getPosition());

        /*
        degisen pencere boyutu : (900, 600)
        degisen pencere position : (15, 15)
         */

    }
}
