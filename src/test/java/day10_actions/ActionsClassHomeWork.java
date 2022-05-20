package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsClassHomeWork extends TestBase {
    /*
    http://webdriveruniversity.com/Actions sayfasina gidin
    Hover over Me First kutusunun uzerine gelin
    Link1'e tiklayin
    Popup mesajini yazdirin
    Popup'i tamam diyerek kapatin
    "Click and hold" tusuna basili tutun
    "Click and hold" kutusunda cikan yaziyi yazdirin
    "Double click me" butonuna cift tiklayin
     */

    @Test
    public void test(){
        driver.get("https://webdriveruniversity.com/Actions ");
        //  Hover over Me First kutusunun uzerine gelin
        Actions actions=new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).perform();

        //    Link1'e tiklayin
        actions.click(driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]"))).perform();

        //    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //    "Click and hold" tusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']"))).perform();

        //    "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());

        //    "Double click me" butonuna cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//h2"))).perform();
    }
}
