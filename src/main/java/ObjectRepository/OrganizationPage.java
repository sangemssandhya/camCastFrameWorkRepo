package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement pageHeader;
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement newOrgLink;

	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search_field")
	private WebElement searchDropDown;
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	//Initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickPlusButton() {
		plusButton.click();
	}
	public String getNewOrgName() {
		return newOrgLink.getText();
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public void setSearchEdt(WebElement searchEdt) {
		this.searchEdt = searchEdt;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public void setSearchDropDown(WebElement searchDropDown) {
		this.searchDropDown = searchDropDown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}


}
