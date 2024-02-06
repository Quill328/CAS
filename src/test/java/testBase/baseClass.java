package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public WebDriver driver;
	public Properties pro;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setupDriver(String br) throws IOException {
		
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		 pro = new Properties();
		 pro.load(file);
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	//Chrome Browser	
		}
		
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	//edge Browser	
		}
		
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	//firefox Browser	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	// ImplicitWait
		
		driver.get(pro.getProperty("be_cognizant"));
		
		driver.manage().window().maximize();

}
	@AfterClass
	public void close()
	{
		driver.close();
	}

}
