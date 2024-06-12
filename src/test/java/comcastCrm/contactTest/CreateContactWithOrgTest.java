package comcastCrm.contactTest;

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
import comcastCrm.generic.fileUtility.WebDriverUtility;

public class CreateContactWithOrgTest {
@Test
	public  void maineverything() throws Throwable {
		// TODO Auto-generated method stub
		Fileutility fiu=new Fileutility();
		ExcelUtility eiu=new ExcelUtility();
		JavaUtility jiu=new JavaUtility();
		WebDriverUtility wiu=new WebDriverUtility();
		//read data from json file
		String BROWSER=fiu.getDataFromPropertiesFile("browser");
		String URL=fiu.getDataFromPropertiesFile("url");
		String USERNAME=fiu.getDataFromPropertiesFile("username");
		String PASSWORD=fiu.getDataFromPropertiesFile("password");
		
		
		
		//Read data from excel file
		String lastname=eiu.getDataFromExcel("contact", 1, 2)+jiu.getRandomNum();
		String orgName=eiu.getDataFromExcel("contact", 7, 2)+jiu.getRandomNum();
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
		wiu.waitForPageToLoad(driver);
		//step 1:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		//step 3:click on organization plus button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step 4: enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//VERIFY HEADER INFO WITH ORG NAME
		
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgName))
		{
			System.out.println(orgName+"is created=Pass");
			
		}
		else
		{
			System.out.println(orgName+"is not created=fail");
		}
		
		
		
		
		
		//step 2: navigate to Organization module
		driver.findElement(By.linkText("Contacts")).click();
		//step 3:click on contact plus button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wiu.switchToTabOnUrl(driver,"module=Account");
	
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		Thread.sleep(2000);
		wiu.switchToTabOnUrl(driver,"Contacts&action");
		

		
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
		String headerinfo1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo1.contains(lastname))
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


