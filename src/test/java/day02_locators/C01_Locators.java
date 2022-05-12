package day02_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {

    /*
    locators ile ilgili en onemli mevzu nokta atisi yaparak bulunmasini saglamak
    yani driver'a bla bla'yi bul dedigimiz zaman onun unique olmasi gerekir.
    mesela arama cubuguna git dendiginde gidecegi adresin net olmasi lazim
    alternatif olmamali onun bizzat bulunmasi gerekir
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        html kodlarinda genelde id kullaniriz cunku buyuk olasilikla unique'tir.
        unique degilse de unique olani bulmak gerekir

        locator'a yazacagimizin
        kesinlikle unique olmasi gerekir.
         */

        //Amazon'a gidip nutella aratalim
        /*
        bu task'ta demek istedigi aramaKutusunu bulmak, onu locate etmek ve bir WebElement'e atamak gerekir

        locate edereken 3 adim vardi findElement() kullanip
        icerisine (By.LocateName("....")) yazmak
        ve son olarak da WebElement'e atamak.

        Nutella'yi aramak icin de olusturdugumuz WebElement'e nutella yazisini yollamamiz gerekir.
         */
        driver.get("https://www.amazon.com");

        /*
        findElement(By....locator)--->istedigimiz web elementini bize dondurur
        biz de o web elementini kullanmak icin bir objeye assing ederiz
         */
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));//burada aramaKutusunu bulup-locate ettik
                                                                                 //WebElement'e atadik

       // WebElement aramaKutusu=driver.findElement(By.name("field-keywords")); CALISTI

        /*
        WebElement aramaKutusu=driver.findElement(By.className("nav-search-field "));CALISMADI

        bunu yaptigimizda olmadi mesela ama burada (ilerleyen zamanda daha detayli gorecegiz) cozum
        bulacagiz. Bu locater calismaz ise alternatif locator'lar denemeliyiz. Bunda israrci olmanin
        manasi yoktur. Mesela id,name,className gibi

        AMA AMA AMA className genelde unique olmaz, birden fazla kullanilir CSS ozelliklerini yapmakta
        kolaylastirdigi icin mevzuyu vs yani websitesine sekil sukul vermek icin class kolaylik saglar
        bu nedenle locate ederken className pek tercih edilmez.
         */


        /*
        KODLAR ULKEDEN ULKEYE FARKLILIK GOSTEREBILIR BUNU UNUTMAMAK LAZIM!!!

        Mesela aramaButonu'nun Amazon'daki html kodunu Copy Element yaparak buraya alip inceleyebiliriz

        <input type="text" id="twotabsearchtextbox" value="Nutella"
        name="field-keywords" autocomplete="off"
        placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Söka">
         */


        //herhangi bir web elementine istedigimiz yaziyi yollamak istersek asagidaki yolu izleriz

        aramaKutusu.sendKeys("Nutella " + Keys.ENTER);


    }


}
