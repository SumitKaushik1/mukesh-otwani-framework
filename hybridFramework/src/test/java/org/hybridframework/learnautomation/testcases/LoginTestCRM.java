package org.hybridframework.learnautomation.testcases;


import org.hybridframework.learnautomation.pages.BaseClass;
import org.hybridframework.learnautomation.pages.LoginPage;
import org.hybridframework.learnautomation.utility.ExcelDataProvider;
import org.hybridframework.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCRM  extends BaseClass {

   // WebDriver driver;

/*    first we  will see the old approch or test case without freamowork

    then we will see the page object framwrk
    thne we crete teh base class and thne we creat the library and then  we create the test suite

            without the  freameweork  the problem comes that if  anyvalue is changes again you have to change that value in each line which is difficult to do


    we will create the browser factory class which will return the browsers only

    one method will take care  of the browser and laod




    the abstract means is showing hte essential feature hiding the essential background details

    only thing we are taking the data hardcoded and all we will change in teh next video  and the

    we will maintain the testrunner nice and crispy noone come change our code which is repetative we keep in the baseClass*/

    @Test(priority = 1)
    //@Test
    public void loginApp(){


        logger= report.createTest("Login to CRM");
      //  ExcelDataProvider excel= new ExcelDataProvider();

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

        logger.info("starting Applicaton");



  loginPage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));


  logger.pass("Login success");
  Helper.capturesScreenshot(driver);

  //LoginPage loginPage= PageFactory.initElements(this.driver, LoginPage.class);

  // loginPage.loginToCRM("pritam.2581996@gmail.com","Abcd@123456");
}

/*

    @Test(priority = 2)
    //@Test
    public void loginApp1(){

        logger=report.createTest("Logout");
        logger.fail("Logout failed");

    }
*/





}
