package comcastCrm.contactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseUtility.BaseClass;

import ObjectRepository.Createcontact;
import ObjectRepository.HomePage;
import ObjectRepository.createNewContact;
import comcastCrm.generic.fileUtility.UtilityClassObject;
@Listeners(com.comcast.crm.listenersutility.ListernerImplementation.class)
public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContact() throws Throwable
	{
		
		//WebDriver driver=new ChromeDriver();
		//Fileutility fiu=new Fileutility();
		//ExcelUtility eiu=new ExcelUtility();
		//JavaUtility jiu=new JavaUtility();
		//read the common data from properties file
		//String BROWSER=fiu.getDataFromPropertiesFile("browser");
		//String URL=fiu.getDataFromPropertiesFile("url");
		//String USERNAME=fiu.getDataFromPropertiesFile("username");
		//String PASSWORD=fiu.getDataFromPropertiesFile("password");
		
		//LoginPage lp=new LoginPage(driver);
		
		
			//	lp.loginToVtiger(driver,URL, USERNAME,PASSWORD);
	UtilityClassObject.getTest().log(Status.INFO, "reading the data from excel");
		System.out.println("hi");
		
		//Read data from excel file
				String lastname=eiu.getDataFromExcel("contact", 1, 2)+jiu.getRandomNum();
				
				UtilityClassObject.getTest().log(Status.INFO,"navigate to contact page");
				HomePage hp=new HomePage(driver);
				hp.clickContacts();
				UtilityClassObject.getTest().log(Status.INFO,"navigate to craete contact page");
				createNewContact cnc=new createNewContact(driver);
				cnc.clickPlusButton();
				UtilityClassObject.getTest().log(Status.INFO,"create new contact");
			Createcontact cc=new Createcontact(driver);
			cc.getLastNameTF().sendKeys(lastname);
		cc.clickSave();
			String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(lastname))
			{
				System.out.println(lastname+"is created=Pass");
				
			}
			else
			{
				System.out.println(lastname+"is not created=fail");
			}
			
				
				
				
	}
	
	@Test
	public void createContactwithDate() throws IOException, Throwable
	{
		System.out.println("execute createcontactwithDate and verify");
		String lastname=eiu.getDataFromExcel("contact", 4, 2)+jiu.getRandomNum();
		
		
		HomePage hp=new HomePage(driver);
		hp.clickContacts();
		
		createNewContact cnc=new createNewContact(driver);
		cnc.clickPlusButton();
	Createcontact cc=new Createcontact(driver);
	cc.getLastNameTF().sendKeys(lastname);
	//cc.getOrgPlusButton().click();
	
	String startDate=jiu.getSystemDateYYYYMMDD();
	String endDate=jiu.getRequiredDateYYYYMMDD(30);
	System.out.println(startDate);
	System.out.println(endDate);
	Thread.sleep(5000);
	cc.getStartdate().sendKeys(startDate);
	Thread.sleep(5000);
	cc.getEndDate().clear();
	cc.getEndDate().sendKeys(endDate);
	Thread.sleep(5000);
	cc.clickSave();
	String actStartdate=cc.getActStartDate().getText();
	boolean status =actStartdate.contains(startDate);
	Assert.assertEquals(status,true);
	
	String actEnddate=cc.getActEndDate().getText();
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actEnddate,endDate);
	soft.assertAll();
	
	
	
	
	}
	

}

