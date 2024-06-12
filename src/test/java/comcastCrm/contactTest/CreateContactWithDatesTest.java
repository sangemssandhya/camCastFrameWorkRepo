package comcastCrm.contactTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import comcastCrm.generic.fileUtility.ExcelUtility;
import comcastCrm.generic.fileUtility.Fileutility;
import comcastCrm.generic.fileUtility.JavaUtility;

public class CreateContactWithDatesTest {
	
	@Test
	public  void Anything() throws IOException, Throwable {
		
	Fileutility fiu=new Fileutility();
	ExcelUtility eiu=new ExcelUtility();
	JavaUtility jiu=new JavaUtility();
	
	//read data from json file
	String BROWSER=fiu.getDataFromPropertiesFile("browser");
	String URL=fiu.getDataFromPropertiesFile("url");
	String USERNAME=fiu.getDataFromPropertiesFile("username");
	String PASSWORD=fiu.getDataFromPropertiesFile("password");
	
	
	
	//Read data from excel file
	String lastname=eiu.getDataFromExcel("contact", 1, 2)+jiu.getRandomNum();
	WebDriver driver=null;
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
    
    
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	//step 1:login to application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//step 2: navigate to Organization module
	driver.findElement(By.linkText("Contacts")).click();
	//step 3:click on contact plus button
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//enter all the details and create new Organization
	String startDate=jiu.getSystemDateYYYYMMDD();
	String endDate=jiu.getRequiredDateYYYYMMDD(30);
	
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//verify HEader Msg Expected Result
	String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(lastname))
	{
		System.out.println(lastname+"is created=Pass");
		
	}
	else
	{
		System.out.println(lastname+"is not created=fail");
	}
	//verify start date
	String actStartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
	if(actStartdate.equals(startDate))
	{
		System.out.println(startDate+"actualstart is equals to start date=pass");
	}else {
		System.out.println(startDate+"actualstart is  not equals to start date=fail");
	}
	
	//verify end date
	String actEnddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
	if(actEnddate.equals(endDate))
	{
		System.out.println(actEnddate+"actual end date is equal to end date=passs");
	}else {
		System.out.println(actEnddate+"actual end date is not equal to end date=fail");
	}
	
	
	
	//step 5:logout
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
	
}

}
