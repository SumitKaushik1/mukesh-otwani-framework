package org.hybridframework.learnautomation.pages;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import org.hybridframework.learnautomation.utility.BrowserFactory;
import org.hybridframework.learnautomation.utility.ConfigDataProvider;
import org.hybridframework.learnautomation.utility.ExcelDataProvider;
import org.hybridframework.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseClass {


   public  WebDriver driver;
   public ExcelDataProvider excel;
  public ConfigDataProvider config;
  public ExtentReports report;
  public ExtentTest logger;

   @BeforeSuite
   public void setUpSuite(){


       Reporter.log("Setting up reports and Test is getting ready and less is getting ready",true);

       excel= new ExcelDataProvider();
       config= new ConfigDataProvider();

// once the report is done in the file it hast o flush it
       ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));

       report= new ExtentReports();
       report.attachReporter(extent);

    Reporter.log("Setting Done Test can be started",true);
   }

  // @BeforeClass
  /*  public void setup(){

       Reporter.log("Trying to start Browser and Getting applicaitons ready",true);

       // driver= BrowserFactory.startApplication(driver,"Chrome","https://ui.freecrm.com/");
        System.out.println("Browser"+config.getBrowser()+"url"+config.getStagingURL());

       driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
         Reporter.log("Browser and Application is up and running ", true);
    }*/





   @Parameters({"browser","urlToBeTested"})
    @BeforeClass
    public void setup(String browser,String url){

        Reporter.log("Trying to start Browser and Getting applicaitons ready",true);

        // driver= BrowserFactory.startApplication(driver,"Chrome","https://ui.freecrm.com/");
        //System.out.println("Browser"+config.getBrowser()+"url"+config.getStagingURL());

       System.out.println("Browser"+browser+"url"+url);

       // driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());

         //driver= BrowserFactory.startApplication(driver,browser,config.getStagingURL());

         driver= BrowserFactory.startApplication(driver,browser,url);

        Reporter.log("Browser and Application is up and running ", true);
    }


    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);

    }


    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {


       Reporter.log("Test is about to end",true);
       if(result.getStatus()==ITestResult.FAILURE){
           Helper.capturesScreenshot(driver);
           logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenshot(driver)).build());
       }
       else if ( result.getStatus() == ITestResult.SUCCESS)
       {
           logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenshot(driver)).build());
       }

       report.flush();

    }




}
