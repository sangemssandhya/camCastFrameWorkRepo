package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement pageHeader;
	@FindBy(xpath="//a[text()='Leads' and contains(@href,'Leads&action')]")
	private WebElement leadsTab;
	@FindBy(xpath="//a[text()='Organizations' and contains (@href,'Accounts&action')]")
	private WebElement OrganizationsTab;
	@FindBy(xpath="//a[text()='Contacts' and contains (@href,'Contacts&action')]")
	private WebElement ContactsTab;
	@FindBy(linkText="Products")
	private WebElement ProductTab;
	
	@FindBy(id="qccombo")
	private WebElement quickCreateDropdown;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	//initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
		}
	
	public void clickOrganizations() {
		 OrganizationsTab.click();
	}
	public void clickContacts() {
		ContactsTab.click();
	}
	public void clickLeads() {
		leadsTab.click();
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void setSignOutLink(WebElement signOutLink) {
		this.signOutLink = signOutLink;
	}

	public WebElement getQuickCreateDropdown() {
		return quickCreateDropdown;
	}

	public void setQuickCreateDropdown(WebElement quickCreateDropdown) {
		this.quickCreateDropdown = quickCreateDropdown;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public void setAdminIcon(WebElement adminIcon) {
		this.adminIcon = adminIcon;
	}

	public WebElement getProductTab() {
		return ProductTab;
	}

	public void setProductTab(WebElement productTab) {
		ProductTab = productTab;
	}
	


}
