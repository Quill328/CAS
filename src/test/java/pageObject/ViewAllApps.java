package pageObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAllApps extends BasePage {

	WebDriver driver;
	List<String> str= new ArrayList<String>();
	
	public ViewAllApps(WebDriver driver)
	{
		super(driver);
	}
 
	//By  a_2_z = By.xpath("//div[@class ='aZHolder']/div");
	
	@FindBy(xpath="//div[@class ='aZHolder']/div")
	List<WebElement> a_2_z;
	
	public void randomAlphabet()
	{
		
		Random random= new Random();
		while(true) {
			
		int n=random.nextInt(a_2_z.size());
		if(a_2_z.get(n).equals(str)) //? which str
			continue;
			a_2_z.get(n).click();
			break;
		}
	}
	
	public void checkDisabled()
	{
	
	for(WebElement e: a_2_z) 
	{
		if(e.getAttribute("role")!=null) {
			continue;
		}
		
		else 
			str.add(e.getText());
	}
	
	
	for(String s:str) 
	{
	System.out.println(s+" is disabled");
	//return false; ??????????
	
	}
//	if(str!=null)
//		return false;
//	return false;
	
	}
	
	
	public void snapShot() throws IOException
	{
		
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("..\\project\\ss\\image.png");
	FileUtils.copyFile(src,trg);
	
	}
	
}

