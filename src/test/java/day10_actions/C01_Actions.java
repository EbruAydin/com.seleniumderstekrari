package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    //amazon anasayfa'ya gidin
    //account menusunden create a list linkine tiklayin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountMenu=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountMenu).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }


}
