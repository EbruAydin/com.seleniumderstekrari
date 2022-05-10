package day01_seleniumtekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_getWindowHandle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());
        //1.pencere : CDwindow-9579CAE9C6188F961E7F8C82E12E8907
        //2. pencere : CDwindow-695C7678E09F6215F4664D22B61D8E24
        //her run edilisinde yeni pencere acildigi icin
        //her pencerenin kendine has hashcode'u bulunur
        //ilerleyen zamanlarda detayli olarak gorup, kullanacagiz

    }
}
