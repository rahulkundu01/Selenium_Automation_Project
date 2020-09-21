package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface driver {
	
	public  WebDriver wd = new FirefoxDriver();
	public static String baseURL = "http://automationpractice.com/index.php";
	public static String driverPath = "F:\\Work Environment\\MyProject\\GoogleTestCases\\geckodriver.exe";
	public void CallDriver();
	public static String email = "rahul@gmail.com";
	public static String password = "pass1234";

}
