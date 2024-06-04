package comcastCrm.generic.fileUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void switchToTabOnUrl(WebDriver driver,String partialUrl)
	{
		Set<String>set=driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		while (it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			 String actUrl=driver.getCurrentUrl();
			 if(actUrl.contains(partialUrl))
			 {
				 break;
			 }
	}
	}
		public void switchToTabOnTitle(WebDriver driver,String partialTitle)
		{
			Set<String>set=driver.getWindowHandles();
			Iterator<String>it=set.iterator();
			while (it.hasNext()) {
				String windowID=it.next();
				driver.switchTo().window(windowID);
				 String actUrl=driver.getCurrentUrl();
				 if(actUrl.contains(partialTitle))
				 {
					 break;
				 }
		}
	}
		public void SwitchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		
		public void  SwitchToFrame(WebDriver driver,String nameID)
		{
			driver.switchTo().frame(nameID);
		}
		public void SwitchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void switchToAlertAndCancel(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		public void select(WebElement element,String text)
		{
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}
		public void select(WebElement element,int index)
		{
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		public void mousemoveOnElement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void doubleClick(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
}
