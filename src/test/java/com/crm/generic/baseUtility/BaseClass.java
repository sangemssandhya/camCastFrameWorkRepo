package com.crm.generic.baseUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import comcastCrm.generic.fileUtility.DatabaseUtility;
import comcastCrm.generic.fileUtility.ExcelUtility;
import comcastCrm.generic.fileUtility.Fileutility;
import comcastCrm.generic.fileUtility.JavaUtility;
import comcastCrm.generic.fileUtility.JsonUtility;
import comcastCrm.generic.fileUtility.UtilityClassObject;
import comcastCrm.generic.fileUtility.WebDriverUtility;
@Listeners(com.comcast.crm.listenersutility.ListernerImplementation.class)
public class BaseClass {
public	DatabaseUtility dbu=new DatabaseUtility() ;
public	ExcelUtility eiu=new ExcelUtility();
public	Fileutility fiu=new Fileutility();
public	JavaUtility jiu=new JavaUtility();
public	WebDriverUtility wdu=new WebDriverUtility();
public	JsonUtility jsu=new JsonUtility();
	public WebDriver driver=null;
	//public static WebDriver sdriver=null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("==connect to DB,Report config====");
		dbu.getDbconnection();
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

	@BeforeClass
	public void configBC() throws Throwable
	{    		
		
		
			 
			
			
		
	         
		
		System.out.println("===Launch the bROWSER");
		String BROWSER=fiu.getDataFromPropertiesFile("browser");
		
		 if(BROWSER.equals("chrome"))
		    {
		    	   driver= new ChromeDriver();	
		    }else if(BROWSER.equals("edge"))
		    {
		    	driver=new EdgeDriver();
		    	
		    }else
		    {
		    	driver= new ChromeDriver();	
		    }
		// sdriver=driver;
		 UtilityClassObject.setDriver(driver);
		}
		
	
	@BeforeMethod()
	public void configBM() throws Throwable
	{
		System.out.println("Login");
		String URL=fiu.getDataFromPropertiesFile("url");
		String USERNAME=fiu.getDataFromPropertiesFile("username");
		String PASSWORD=fiu.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		
		
			lp.loginToVtiger(driver,URL, USERNAME,PASSWORD);
	
		
		
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("LogOut");
		HomePage hp=new HomePage(driver);
		
		wdu.mousemoveOnElement(driver, hp.getAdminIcon());
		
		hp.getSignOutLink().click();
	}
	
		
	@AfterClass
	public void configAC()
	{
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException
	{
		System.out.println("==========Close the DB ,Report backUp====");
		dbu.closeDbconnection();
		report.flush();
	}

	

}
