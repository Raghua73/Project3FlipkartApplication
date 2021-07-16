package test;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.*;
import pageObject.FlipkartPage;

import utilities.Reporting;
import utilities.Screenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


public class FlipkartTest extends Reporting{

	//static WebDriver driver;
	FlipkartPage objFlipkart;
	public AndroidDriver<AndroidElement> adriver;	


	@BeforeTest
	public void openapp(){

		System.out.println("Launching the App");
		File app =new File(System.getProperty("user.dir")+"\\Apps\\Flipkart-7.18.apk");
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("deviceName","Redmi Note 8 Pro");
		capabilities.setCapability("udid", "xoukea4pk7gmu8fa");	
		capabilities.setCapability("platformVersion","10");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("fullReset","false");

		capabilities.setCapability("appPackage","com.flipkart.android");
		capabilities.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
		capabilities.setCapability("app", app.getAbsolutePath());		

		try 
		{
			adriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities); 
		} 
		catch (MalformedURLException e) 
		{

			e.printStackTrace();
			Assert.fail("Driver failed to start" + e.getMessage());
		}
		adriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);							
	}	


	@Test
	public void test_FlipkartPage() throws IOException {

		System.out.println("App Started");

		try {


			FlipkartPage objFlipkart=new FlipkartPage(adriver);
			objFlipkart.FlipkartApplication("iPhone Mobiles");

			Thread.sleep(5000);

			Screenshot ss1=new Screenshot(adriver);
			ss1.capture();			
			Thread.sleep(5000);

			//ExtentReport
			ExtentTest logger=extent.createTest("FlipkartTest : Success");
			logger.log(Status.INFO, "Application Launched Successfully");
			logger.log(Status.PASS, "Product added to cart");

		}

		catch(Exception e){
			System.out.println("Failure while adding the product to cart");
			Screenshot ss2=new Screenshot(adriver);
			ss2.capture();
			
			//ExtentReport
			ExtentTest logger=extent.createTest("FlipkartTest : Failure");
			logger.log(Status.INFO, "Application Launched Successfully");
			logger.log(Status.FAIL, "Could not add the Product to cart");

		}
	}

	@AfterTest
	public void closeApp(){

		adriver.quit();
	}


}
