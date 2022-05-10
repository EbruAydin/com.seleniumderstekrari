package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTest {
    public static void main(String[] args) {

        /*  1- https://www.amazon.com url'ine gidin
            2- Basligin Amazon kelimesi icerdigini test edin
            3- Url'in "https://www.amazon.com" a esit oldugunu test edin
            4- sayfayi kapatin
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

//1- https://www.amazon.com url'ine gidin
        driver.get("https://www.amazon.com");
        //2- Basligin Amazon kelimesi icerdigini test edin

        String mevcutBaslik=driver.getTitle();
        String arananBaslik="Amazon";

        if(mevcutBaslik.contains(arananBaslik))
            System.out.println("Test PASSED");
        else System.out.println("Test FAILED");

      //3- Url'in "https://www.amazon.com" a esit oldugunu test edin

      String mevcutUrl=driver.getCurrentUrl();
      String arananUrl="https://www.amazon.com";

      if(mevcutUrl.equals(arananUrl))
          System.out.println("Test PASSED");
      else System.out.println(mevcutUrl+ " esit degil aranana urlye, Test FAILED");

      //sayfayi kapain
        driver.close();


    }
}
