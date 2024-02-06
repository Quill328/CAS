package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeCognizant extends BasePage{
	
	//constructors
	WebDriver driver;
	
	public BeCognizant(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
//	By account_btn =By.id("O365_MainLink_Me");
//	By user_name = By.id("mectrl_currentAccount_primary");
//	By user_email = By.id("mectrl_currentAccount_secondary");
//	By cognizant_title = By.xpath("//div[@Title='OneCognizant']");
	
	@FindBy(id="O365_MainLink_Me")
	WebElement account_btn;
	
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement user_name;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement user_email;
	
	@FindBy(xpath="//div[@Title='OneCognizant']")
	WebElement cognizant_title;
	
	//methods
	public void clickAcc()
	{
		account_btn.click();
	}
	
	public void getName()
	{
		String myName = user_name.getText();
		System.out.println(myName);
	}
	
	public void getMailId()
	{
		String myEmailId = user_email.getText();
		System.out.println(myEmailId);
	}
	
	public boolean title() throws InterruptedException
	{
		cognizant_title.click();
		
		Set<String> wId=driver.getWindowHandles();
		List<String> sas= new ArrayList<String>(wId);         //more than 2 handles
		String sa= sas.get(1);
		driver.switchTo().window(sa);
		Thread.sleep(2000);
		return cognizant_title.isDisplayed();
	}
	
	

	public String actualText() {
		String actual = cognizant_title.getText();
		return actual;
		
	}
	

}
