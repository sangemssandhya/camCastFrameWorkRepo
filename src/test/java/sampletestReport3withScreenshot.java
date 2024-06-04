import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampletestReport3withScreenshot {
	
	ExtentReports report;
	@BeforeSuite
	public void configBs()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdavnceReport/reports1.html");
		spark.config().setDocumentTitle("Crm test suite results");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSER","CHROME-100");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
	
	@Test
	public void createcontacttest()
	{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	TakesScreenshot ts=(TakesScreenshot)driver;
	String filePath=ts.getScreenshotAs(OutputType.BASE64);//screenshot of failure page
	ExtentTest test=  report.createTest("createcontactTest");
	test.log(Status.INFO,"login to App");
	test.log(Status.INFO, "navigate to contact page");
	test.log(Status.INFO, "create contact");
	if("HDFCD".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is created");
	}else
	{
		test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
	}
	driver.close();
	}
	

}
