import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampleReportTest2 {
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
	public void createContactwithOrg()
	{
		ExtentTest test= report.createTest("createcontactWithOrg");
		test.log(Status.INFO,"login to App");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}else
		{
			test.log(Status.FAIL,"contact is  NOT created");
		}
		report.flush();//flush is used to save the data
		System.out.println("login to app");
		
	}
	@Test
	public void createContactwithPhoneNumber()
	{
		ExtentTest test= report.createTest("createContactwithPhoneNumber");
		test.log(Status.INFO,"login to App");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}else
		{
			test.log(Status.FAIL,"contact is  NOT created");
		}
		report.flush();//flush is used to save the data
		System.out.println("login to app");
		
	}
	}


