package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreatingNewOrganizationsPage {
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTF;
	 @FindBy(name="industry")
	 private WebElement industryDropdown;
	 
	 @FindBy(name="accounttype")
	 private WebElement typeDropdown;
	 @FindBy(xpath="//input[normalize-space(@value)='Save']")
	 private WebElement saveButton;
	 
	 //initialization
	 
	 public CreatingNewOrganizationsPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
   //Utilization
	 public String getPageHeader()
	 {
		 return pageHeader.getText();
	 }
	 public void setOrgName(String orgName)
	 {
		 orgNameTF.sendKeys(orgName);
	 }
	 
	
	 
	 public void clickSave() {
		 saveButton.click();
	 }
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	public void setIndustryDropdown(WebElement industryDropdown) {
		this.industryDropdown = industryDropdown;
	}
	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
	public void setTypeDropdown(WebElement typeDropdown) {
		this.typeDropdown = typeDropdown;
	}

	  

}
