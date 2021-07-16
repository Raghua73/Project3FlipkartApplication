package utilities;

import io.appium.java_client.android.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Screenshot {

	private AndroidDriver<AndroidElement> driver;
	public Screenshot(AndroidDriver<AndroidElement> driver) {

		this.driver=driver;
	}



	public void capture() throws IOException{

		Date d=new Date();
		String Filename=d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\raghu.a\\eclipse-workspace\\Project3FlipkartApplication\\Reports\\"+Filename));

	}


}
