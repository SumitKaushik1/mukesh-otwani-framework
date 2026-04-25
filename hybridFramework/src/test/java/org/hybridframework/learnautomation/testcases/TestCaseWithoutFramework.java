package org.hybridframework.learnautomation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class TestCaseWithoutFramework
{
    /**
     * Rigorous Test :-)
     */



   // without the  freameweork  the problem comes that if  anyvalue is changes again you have to change that value in each line which is difficult to do
    @Test
    public void test1() throws InterruptedException
    {
       //System.setProperty("webdriver.chrome.driver","C:\\Users\\Chandani_50\\Desktop\\Selenium  Jar\\chromedriver.exe");
        WebDriverManager.chromedriver().clearDriverCache().setup();

       WebDriver driver= new ChromeDriver();

       driver.get("https://ui.freecrm.com/");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.findElement(By.name("email")).sendKeys("pritam.2581996@gmail.com");
       driver.findElement(By.name("password")).sendKeys("Abcd@123456");
       driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
       driver.quit();

    }
}
