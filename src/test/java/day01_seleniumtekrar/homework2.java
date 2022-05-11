package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class homework2 {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //Youtube web sayfasina gidin
        driver.get("https://www.youtube.com"); //youtube sayfasini getirdim
        //sayfa basliginin "youtube" olup olmadigini kontrol edin
        //eger degilse dogru basligi yazdirin

        String actualtitle=driver.getTitle(); //basligi string bir variable'a atadim
        String findTitle="youtube"; //aradigimiz basligi da string bir variable'a atadim
        Thread.sleep(3000);

        if( actualtitle.equals(findTitle)){
            System.out.println(findTitle+ " ---> is equal with actual title so this test PASSED");
        }else{
            System.out.println(findTitle+ "---->  is not equal actual title so this test FAILED");
            System.out.println("The correct tile is >>>"+ actualtitle );
//sayfa url'sinin  "yotube" icerip icermedigini dogrulayin
            //icermiyorsa dogrusunu yazdirin

            String actualUrl= driver.getCurrentUrl();
            String exist="youtube";
            if(actualUrl.contains(exist)){
                System.out.println(exist+" ----> is inside the url ");
            }else{
                System.out.println(exist+"----> is not inside the url ,the correct url is---> "+actualUrl );
            }
        }
        //daha sonra Amazon sayfasina gidin
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);
        //youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);
        //sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(3000);

        //Sayfayi tam sayfa yapin
        driver.manage().window().fullscreen();
        //sayfa basliginin Amazon icerip icermedigini dogrulayin
        //yoksa dogru basligi yazdirin

        String actualtitle2=driver.getTitle(); //basligi string bir variable'a atadim
        String findTitle2="Amazon"; //aradigimiz basligi da string bir variable'a atadim
        Thread.sleep(3000);

        if(actualtitle2.contains(findTitle2)){
            System.out.println(actualtitle+ "---> inside the title");
        }else{
            System.out.println( "Actuaul title is: --> "+ actualtitle);
        }

        String actualUrl2= driver.getCurrentUrl();
        String exist2="https://www.amazon.com/";
        if(actualUrl2.equals(exist2)){
            System.out.println(exist2+" ----> is inside the url ");
        }else{
            System.out.println(exist2+ "----> is not inside the url ,the correct url is---> "+actualUrl2 );
        }
        driver.close();
    }
}
