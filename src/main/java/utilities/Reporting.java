package utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting {

	ExtentHtmlReporter reporter;
	public ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {
		reporter=new ExtentHtmlReporter("./Reports/Flipkart.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterSuite
	public void reportTeardown() {
		extent.flush();
	}
}
