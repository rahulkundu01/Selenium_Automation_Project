package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginCases implements driver {
	
	
WebDriver driver;
long stime, etime, total;
	
	
	
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
		
	}
	
	@Test
	public void startTest() {
		
		stime = System.currentTimeMillis();
		
		driver.findElement(By.className("login")).click();
			//driver.wait(1000);
		if(driver.findElement(By.id("email")).isEnabled()) {
			System.out.println("Email is enabled");
		};
		if(driver.findElement(By.id("passwd")).isEnabled()) {
			System.out.println("password is enabled");
		};
		
		
		driver.findElement(By.id("SubmitLogin")).click();
		etime  = System.currentTimeMillis();
		
		total = etime - stime;
		System.out.println("Total time for test1 = "+total);
	}
	
	@Test
	public void loginTest1() {
		
		//Invalid Data
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		if(driver.getPageSource().contains("Authentication failed")){
			System.out.println("Validation present");
			}else{
			System.out.println("Validation not present");
	}
	
	}
	
	@Test
	public void loginTest2() {
		
		//Valid Data
		
		String currentURL;
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys("rk1@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		
		currentURL = driver.getCurrentUrl();
		if(currentURL.equalsIgnoreCase("http://automationpractice.com/index.php?controller=my-account")){
			System.out.println("Navigated successfully to My Account page");
			}
		else{
			System.out.println("Issue with the login");
			}
		driver.findElement(By.className("logout")).click();
		System.out.println("Successfully Loggedout");
	}
	
	
	@AfterTest
    public void endTest() {
        driver.quit();
    }

}
