package org.hybridframework.learnautomation.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){

        if(browserName.equals("Chrome")){
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Chandani_50\\Desktop\\Selenium  Jar\\chromedriver.exe");
            WebDriverManager.chromedriver().clearDriverCache().setup();

             driver= new ChromeDriver();
        }else if (browserName.equals("Firefox")){
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Chandani_50\\Desktop\\Selenium  Jar\\chromedriver.exe");
            WebDriverManager.firefoxdriver().clearDriverCache().setup();

           driver= new FirefoxDriver();
        }else if(browserName.equals("IE")){
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Chandani_50\\Desktop\\Selenium  Jar\\chromedriver.exe");
            WebDriverManager.edgedriver().clearDriverCache().setup();

             driver= new InternetExplorerDriver();
        }
        else
            System.out.println("we donot  support this browser");


        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       return driver;

    }

    public static  void  quitBrowser(WebDriver driver){
        driver.quit();
    }
}
