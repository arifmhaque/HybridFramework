package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.utilities.ReadConfig;

public class BasicTest {
	ReadConfig readConfig = new ReadConfig();
	public String baseURl = readConfig.getApplicationURL();
	public String email = readConfig.getUser();
	public String passWord = readConfig.getPassword();
	public WebDriver driver = null;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("HybridFramework");
		PropertyConfigurator.configure("Log4j2.properties");
		      
         if(br.equalsIgnoreCase("firefox")) {
        	 System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
             driver = new FirefoxDriver();
             
         }else if(br.equalsIgnoreCase("chrome")) {
        	 System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
             driver = new ChromeDriver();
         }
         else if(br.equalsIgnoreCase("ie")) {
        	 System.setProperty("webdriver.ie.driver", readConfig.getFirefoxPath());
             driver = new InternetExplorerDriver();
         }
 		driver.get(baseURl);
		logger.info("URL is opened");

	}
	@AfterClass
	public void tearDown() {
		//driver.quit();
		
	}
	
	public void captureScreenshots(String testName) {
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File detinationFile = new File(System.getProperty("user.dir")+ "/Screenshots/"+testName+".png");
		try {
			FileUtils.copyFile(sourceFile, detinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
	}
	
	

}
