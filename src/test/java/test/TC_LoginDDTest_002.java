package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.actions.LoginPageActions;

import com.utilities.XLUtils;

import base.BasicTest;

public class TC_LoginDDTest_002 extends BasicTest {

	@Test(dataProvider = "LoginData")
	public void loginDD(String user, String pass) {
		LoginPageActions login = new LoginPageActions(driver);
		login.setUser(user);
		logger.info("Entered email");

		login.setPass(pass);
		logger.info("Entered password");

		login.clickSubmit();
		logger.info("Clicked login button");

		
	}
	
	@DataProvider(name = "LoginData")
	public String [][] getData() {
		String path = System.getProperty("user.dir")+"/src/test/java/com/testData/logintestdata.xlsx";
		
		int row = XLUtils.getRowCount(path, "Sheet1");
		int col = XLUtils.getCellCount(path, "Sheet1", 0);
		
		String loginData [][] = new String [row][col];
		
		for(int i = 1; i<=row; i++) {
			for(int j = 0; j<col; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		
		return loginData;
	}
}
