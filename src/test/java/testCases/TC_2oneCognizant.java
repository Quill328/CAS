package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BeCognizant;
import pageObject.OneCognizant;
import testBase.baseClass;

public class TC_2oneCognizant extends baseClass  {
	
	@Test
	public void oneCognizant()
	{
	
		BeCognizant tc2 = new BeCognizant(driver);
		
		try {
			tc2.title();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		OneCognizant tc21 = new OneCognizant(driver);
		tc21.scrollDown();
		tc21.allAppsBtn();
		
		Assert.assertEquals(tc2.actualText(),pro.getProperty("one_cognizant"));
	}

}
