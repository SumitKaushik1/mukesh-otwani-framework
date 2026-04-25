package org.hybridframework.learnautomation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {


    //Screenshots , alerts,frames, windows ,Sync, isues , javascript executor

  //  public static void capturesScreenshot(WebDriver driver){
        public static String  capturesScreenshot(WebDriver driver) {


            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/Screenshots/FreeCRM_" + getCurrentDateTime()+".png";
            try {
                //FileHandler.copy(src,new File("./Screenshots/Login.png"));

                //  FileHandler.copy(src, new File("./Screenshots/FreeCRM_" + getCurrentDateTime() + ".png"));

                FileHandler.copy(src, new File(screenshotPath));



                System.out.println("Screenshot captured");

            } catch (Exception e) {
                System.out.println("Unable to capture scrrenshot" + e.getMessage());
            }

            return screenshotPath;
        }


                public static String getCurrentDateTime(){

                    DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
                    Date currentDate = new Date();

                    return customFormat.format(currentDate);

                }


            }

