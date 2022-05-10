package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_ManageMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //maximize iken boyut ve konumuna bakalim
        System.out.println("maximize iken konum : " +driver.manage().window().getPosition());
        System.out.println("maximize iken boyut " + driver.manage().window().getSize());

        //fullscreen iken boyut ve konumuna bakalim
        driver.manage().window().fullscreen();
        System.out.println("fullscreen iken konum : " + driver.manage().window().getPosition());
        System.out.println("fullscreen iken konum : " + driver.manage().window().getSize());

        /*
        maximize iken konum : (-8, -8)
        maximize iken boyut (1382, 744)
        fullscreen iken konum : (0, 0)
        fullscreen iken konum : (1366, 768)
         */
    }
}
