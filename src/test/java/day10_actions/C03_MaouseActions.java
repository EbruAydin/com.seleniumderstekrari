package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class C03_MaouseActions extends TestBase {
     /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        driver.switchTo().alert().accept();
        //Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        //6- Elemental Selenium linkine tiklayalim
        String firstWindowHandleId=driver.getWindowHandle();
       // driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        actions.click(driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))).perform();

        Set<String> handleList=driver.getWindowHandles();

        String secondWindowHandleId=
                handleList.stream().
                        filter(t->!t.equals(firstWindowHandleId)).
                        collect(Collectors.toList()).get(0);

        driver.switchTo().window(secondWindowHandleId);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.xpath("//h1")).getText());
    }


}
