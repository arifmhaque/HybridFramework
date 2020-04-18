package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page.actions.LoginPageActions;

import base.BasicTest;
//@Listeners(com.utilities.Reports.class)
public class TC_LoginTest_001 extends BasicTest {
	
	@Test
	public void loginTest() {
		
		LoginPageActions login = new LoginPageActions(driver);
		login.setUser(email);
		logger.info("Entered email");

		login.setPass(passWord);
		logger.info("Entered password");

		login.clickSubmit();
		logger.info("Clicked login button");

		if(driver.getTitle().equalsIgnoreCase("Facebook")) {
			//captureScreenshots("LoginTest");
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}else {
			captureScreenshots("LoginTest");
			logger.info("Screenshot taken ");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			

		}
	}

}
