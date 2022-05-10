package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_Navigate {
    public static void main(String[] args) throws InterruptedException {

        /*
        navigate().to()->birden fazla pencerede calisacak isek
        pencereler arasinda gecis yapmak icin -> back() ile geriye, forward() ile ileriye
        refresh()
         */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);

        //tek pencerede calistigimiz icin hashcode ayni OLURRRR!! ornek asagida!!!
        //CDwindow-4293171C5E3E455094584C48587B8580
        //CDwindow-4293171C5E3E455094584C48587B8580

        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);

        //amazona geri donelim
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().to("https://techproeducation.com");
        Thread.sleep(2000);

        //amazona donecek
        driver.navigate().back();
        Thread.sleep(2000);

        //techproya gidecek
        driver.navigate().forward();
        Thread.sleep(2000);

        //sayfayi refresh et
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();


    }
}
