package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCognizant extends BasePage {

	WebDriver driver;
	
	public OneCognizant(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//div[@class='viewAllHotAppsBtn']")
	WebElement view_all_apps;
	
	public void scrollDown()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", " ");
	}
	
	public void allAppsBtn()
	{
		JavascriptExecutor jvs = (JavascriptExecutor)driver;
		jvs.executeScript("arguments[0].click();", view_all_apps);
	}
	
	
	
}
