package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Createcontact {
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	
	@FindBy(xpath="//img[contains(@onclick,'Accounts')]")
	private WebElement orgPlusButton;
	
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	@FindBy(name = "support_start_date")
	private WebElement startdate;
	
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	@FindBy(id="dtlview_Support Start Date")
	private WebElement ActStartDate;
	@FindBy(id="dtlview_Support End Date")
	private WebElement ActEndDate;
	
    private String orgPath="//a[text()='%S']";
    
    //Initialization
    		
    		public Createcontact(WebDriver driver)
    		{
    	PageFactory.initElements(driver,this);
    		}
    
    		//Utilization
    public String getPageHeader() {
    	return pageHeader.getText();
    }
    
    public void setLastName(String contactName) {
    	lastNameTF.sendKeys(contactName);
    }
    
        
    public void clickSave() {
    	saveButton.click();
    }

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getOrgPlusButton() {
		return orgPlusButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public String getOrgPath() {
		return orgPath;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getActStartDate() {
		return ActStartDate;
	}

	public WebElement getActEndDate() {
		return ActEndDate;
	}


}
