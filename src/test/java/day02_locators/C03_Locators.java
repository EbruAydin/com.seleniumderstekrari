package day02_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class C03_Locators {
    public static void main(String[] args) {
 /*
    Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. http://a.testaddressbook.com adresine gidiniz.
    b. Sign in butonuna basin
    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        i. Username : testtechproed@gmail.com
        ii. Password : Test1234!
    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
     */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //    b. Sign in butonuna basin
        WebElement signInButonu=driver.findElement(By.id("sign-in"));
        signInButonu.click();
        //    c. email textbox,password textbox, and signin button elementlerini locate ediniz.
       WebElement emailTextBox=driver.findElement(By.id("session_email"));
       WebElement passwordTextBox=driver.findElement(By.id("session_password"));
       WebElement signInButton=driver.findElement(By.name("commit"));
        //    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        i. Username : testtechproed@gmail.com
        emailTextBox.sendKeys("testtechproed@gmail.com");
        //        ii. Password : Test1234!
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();
        //    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).

        WebElement actualUserId=driver.findElement(By.className("navbar-text"));
        System.out.println("actual user id :"+actualUserId.getText());
        String expectedUserId="testtechproed@gmail.com";

        /*
        buradaki onemli konu WebElement'i yazdirirken ya da isleme koyarken getText() KULLANMAKTIR
        getText kullanilmaz ise ve bu ornekte oldugu gibi if icerisine dogrudan actualUserId yazarsak
        reference devreye girecegi icin test failed oldu diyecektir.
         */
        if(actualUserId.getText().equals(expectedUserId))//bu da calisiyor
            //if(expectedUserId.equals(actualUserId.getText())
            System.out.println("User id test PASSED");
        else System.out.println("User id test FAILED");

        //    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        /*
        bunu taski yapabilmemiz icin locate etmemiz gerekir.
         */
        WebElement addressesElementi=driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));//href="/sign_out">Sign out</a>

        if(addressesElementi.isDisplayed())
            System.out.println("adrresses testi PASSED");
        else System.out.println("addresses testi FAILED");

        if(signOutElementi.isDisplayed())
            System.out.println("Sign Out testi PASSED");
        else System.out.println("Sign Out testi FAILED");

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> elementListesi=driver.findElements(By.tagName("a"));
        System.out.println("Su kadar link var : " +elementListesi.size());

        //lambda ile cozumu
        System.out.println("**********");
        System.out.println("\nLambda ile cozumu");

        elementListesi.stream().
                map(WebElement::getText).
                forEach(System.out::println);

        //diger cozum
        System.out.println("*************");
        System.out.println("\nForeach Loop ile cozumu");
        for (WebElement each:elementListesi) {
            System.out.println(each.getText());
        }



        driver.close();

    }
}
