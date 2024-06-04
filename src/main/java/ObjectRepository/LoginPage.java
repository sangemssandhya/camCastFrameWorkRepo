package ObjectRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Sandhya
 * Contains login pageElements and bussiness libraries like login()
 
 */

public class LoginPage {
	//Rule: create a separte java class
	//Rule : Object Craetion
	
	@FindBy(name="user_name")
	public  WebElement usernameEdt;
	
	
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	 
	
	@FindBy(id="submitButton")
	public WebElement loginBtn;
	
	//Rule:Object Intialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Object encapsulation
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
		
	}
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
		
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
		
	}
	
	
	//utilization
	/**
	 * login to application based on username , url ,password
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 */
	
	public void loginToVtiger(
			WebDriver driver, String url,String username,String password)
	{
		
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	 

	
	

}
