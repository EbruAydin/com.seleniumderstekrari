package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyBoardsActions extends TestBase {

    //amazon'a gidin
    //once arama kutusuna click yapin
    //sonra harf harf Nutella yazdirin
    //sonra da ENTER tusuna basalim

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);

        actions.click(searchBox).
                keyDown(Keys.SHIFT)
                .sendKeys("N")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
