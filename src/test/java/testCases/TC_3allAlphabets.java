package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.ViewAllApps;
import testBase.baseClass;

public class TC_3allAlphabets extends baseClass {
	
	@Test
	public void check_a2z()
	{
		ViewAllApps tc3 = new ViewAllApps(driver);
		
		tc3.checkDisabled();
		tc3.randomAlphabet();
		try {
			tc3.snapShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
