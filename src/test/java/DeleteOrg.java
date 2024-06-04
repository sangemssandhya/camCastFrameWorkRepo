import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.CreatingNewOrganizationsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;
import comcastCrm.OrgTest.CreateOrganizationTest;
import comcastCrm.generic.fileUtility.ExcelUtility;
import comcastCrm.generic.fileUtility.Fileutility;
import comcastCrm.generic.fileUtility.JavaUtility;
import comcastCrm.generic.fileUtility.WebDriverUtility;

public class DeleteOrg {

	public static void main(String[] args) throws Throwable {
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
		
		String orgName=eiu.getDataFromExcel("Sheet1", 10, 2)+jiu.getRandomNum();
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
	    
	    
		driver.get(URL);
		wiu.waitForPageToLoad(driver);
		//step 1:login to application
		LoginPage login=new LoginPage(driver);
		login.usernameEdt.sendKeys(USERNAME);
		login.passwordEdt.sendKeys(PASSWORD);
		login.loginBtn.click();
	 HomePage home=new HomePage(driver);
	 home.clickOrganizations();
		//step 3:click on organization plus button
		OrganizationPage orgpage=new OrganizationPage(driver);
		orgpage.clickPlusButton();
		//step 4: enter all the details and create new organization
		CreatingNewOrganizationsPage createneworg=new CreatingNewOrganizationsPage(driver);
		createneworg.setOrgName(orgName);
		
		createneworg.clickSave();
		
		
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
		
		//go back to Organization Page
		home.clickOrganizations();
		//search for organization
		orgpage.getSearchEdt().sendKeys(orgName);
		wiu.select(orgpage.getSearchDropDown(),"Organization Name");
		Thread.sleep(1500);
        orgpage.getSearchBtn().click();
        Thread.sleep(5000);
        
        
        //In dynamic webtable slect and delete org
        driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
        Thread.sleep(500);
        
        Alert alt=driver.switchTo().alert();
        System.out.println(alt.getText());
        Thread.sleep(5000);
        alt.accept();
        System.out.println("deleted");
       // logout
		
       driver.quit();
	}

	
			

}
