package comcastCrm.OrgTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import ObjectRepository.LoginPage;

public class CreateOrganizationTest {



	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
	    
	    
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//step 1:login to application
		LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		lp.usernameEdt.sendKeys("admin");
		lp.passwordEdt.sendKeys("admin");
		lp.loginBtn.click();
		driver.quit();
		

	}

}
