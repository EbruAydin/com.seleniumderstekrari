package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class YanliEmailTesti {
    /*
    https://www.automationpractice.com/index.php adresine gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
    'Invalid email adress'uyarisi cikitigni test edin.
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromiumdriver().setup();


    }
}
