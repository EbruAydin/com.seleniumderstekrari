package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PazarPratigi extends TestBase {//Mehmet Hocanin utility icin yapmis oldugu class'tan extend edildi

    //Notes: It may also be necessary to write code to accept the accept cookies warning.
    //1. Go to 'https://www.amazon.com.tr/'
    //2. Search iPhone13 512
    //3. Check that the results are listed
    //4. Click iPhone13 at the top of the list
    //5. Log the following values for each size
    //.Size information .Price .Color .Stock status

    @Test
    public void test(){
        driver.get("https://www.amazon.com.tr/");
        WebElement cerez=driver.findElement(By.xpath("//input[@class=\"a-button-input celwidget\"]"));
        cerez.click();
        //2. Search iPhone13 512
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone13 512" + Keys.ENTER);

        //3. Check that the results are listed
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());


        //4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        WebElement productTitle=driver.findElement(By.xpath("//span[@id='productTitle']"));
        String productBilgileri[]=productTitle.getText().split(" ");//[Apple, iPhone, 13, (512, GB), -, Yıldız, Işığı]

       String ilkKelime= Arrays.stream(productBilgileri).
                limit(3).skip(1).collect(Collectors.toList()).get(0);
        String ikinciKelime= Arrays.stream(productBilgileri).
                limit(3).skip(1).collect(Collectors.toList()).get(1);


        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status
        WebElement size=driver.findElement(By.xpath("(//span[@class='selection'])[1]"));
        System.out.println(ilkKelime+ " " + ikinciKelime + "\tSize:" + size.getText());

        WebElement color=driver.findElement(By.xpath("(//span[@class='selection'])[2]"));
        WebElement price=driver.findElement(By.xpath("(//span[@class='a-size-base a-color-price'])[5]"));
        System.out.println("Color:" +color.getText() + "\tPrice:" + price.getText());

        WebElement stock=driver.findElement(By.xpath("//div[@id='availability']"));
        System.out.println("Stock: " + stock.getText());


    }

}
