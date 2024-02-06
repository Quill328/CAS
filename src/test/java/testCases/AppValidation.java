package testCases;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
 
public class AppValidation {
 
	
	public  WebDriver driver;
	public void createDriver() {
		// Launch browser with URL
		driver = new ChromeDriver();
		driver.navigate().to("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");

	}
	public void profile() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("O365_MainLink_Me")).click();
		String s1=driver.findElement(By.id("mectrl_currentAccount_primary")).getText();
		System.out.println(s1);
		String s2=driver.findElement(By.id("mectrl_currentAccount_secondary")).getText();
		System.out.println(s2);
 
	}
	public void oneC() throws InterruptedException {
		driver.findElement(By.xpath("//div[@Title='OneCognizant']")).click();
		//driver.navigate().to("https://onecognizant.cognizant.com/Home?GlobalAppId=926#.");
		Set<String> wId=driver.getWindowHandles();
		List<String> sas= new ArrayList<String>(wId);         //morethan 2 handles
		String sa= sas.get(1);
		driver.switchTo().window(sa);
		//if there are only 2 handles
//		for(String win:wId) {
//			if(!driver.getWindowHandle().contentEquals(win)) {
//				driver.switchTo().window(win);
//				break;
//			}
//		}
		Thread.sleep(5000);
		System.out.println(driver.getTitle());      //Validating OneC
	}
	public void AppSearchValidation() throws IOException, InterruptedException {
		driver.manage(). timeouts(). implicitlyWait(Duration.ofSeconds(15));
		//WebElement ele = driver.findElement(By.id("QuicklinksItemTitle"));
		//ele.click();
		//driver.navigate().to("https://onecognizant.cognizant.com/Home?GlobalAppId=926");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", " ");
		WebElement element =driver.findElement(By.xpath("//div[@class='viewAllHotAppsBtn']"));
		JavascriptExecutor jvs = (JavascriptExecutor)driver;
		jvs.executeScript("arguments[0].click();", element);
		
		List<WebElement> li= driver.findElements(By.xpath("//div[@class ='aZHolder']/div"));
		List<String> str= new ArrayList<String>();
		for(WebElement e: li) {
			if(e.getAttribute("role")!=null) {
				continue;
			}
			else 
				str.add(e.getText());
		}
		for(String s:str)
		System.out.println(s+" is disabled");
		li.get(2).click();
		
		Random rand= new Random();
		while(true) {
		int n=rand.nextInt(li.size());
		if(li.get(n).equals("x"))
			continue;
		li.get(n).click();
		break;
		}
		
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("..\\project\\ss\\image.png");
		FileUtils.copyFile(src, trg);
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		AppValidation app= new AppValidation();
		app.createDriver();
		app.profile();
		app.oneC();
		app.AppSearchValidation();
 
	}
 
}



/*
 	public List<WebElement> randomAlphabet()
	{
		
		Random random= new Random();
		while(true) {
		int n=random.nextInt(a_2_z.size());
		if(a_2_z.get(n).equals("x"))
			continue;
			a_2_z.get(n).click();
			break;
		}
	}

	
	//List<String> str= new ArrayList<String>();
	
	for(WebElement e: li) {
		if(e.getAttribute("role")!=null) {
			continue;
		}
		else 
			str.add(e.getText());
	}
	
	for(String s:str) {
	System.out.println(s+" is disabled");
	a_2_z.get(2).click();
	}
	
	
	
	Thread.sleep(3000);
	
	public void snapShot()
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("..\\project\\ss\\image.png");
	FileUtils.copyFile(src, trg);
	
	}
	
	
	
}
}
*/