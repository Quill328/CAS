package testCases;

import org.testng.annotations.Test;

import pageObject.BeCognizant;
import testBase.baseClass;

public class TC_1accountSignedIn extends baseClass {
	
	@Test
	public void accountDetails()
	{
	BeCognizant tc1 = new BeCognizant(driver); 
	
	tc1.clickAcc();
	tc1.getName();
	tc1.getMailId();
	
	}
	
	
	
}
