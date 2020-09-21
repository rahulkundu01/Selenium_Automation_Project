package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoadPage implements driver {

	WebDriver driver;
	
	
	
	@BeforeTest
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver",driverPath );
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }

	@Test
	public void CallDriver() {
		// TODO Auto-generated method stub
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.close();
		
	}
	
	
	@AfterTest
    public void endTest() {
        driver.quit();
    }
	

}
