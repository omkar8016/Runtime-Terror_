package Functionalities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup 
{
	private static WebDriver driver;
	
	//This Function is used to setup Chrome Driver
	public static WebDriver setupChromeDriver()
	{
		//Here, we are using path to get the home directory of the user to setup our webdriver.
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	//This Function is used to setup FireFox Driver
	public static WebDriver setupFireFoxDriver() 
	{
		//Here, we are using path to get the home directory of the user to setup our webdriver.
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	//This Function is used to setup Opera Driver
	public static WebDriver setupEdgeDriver() 
	{
		//Here, we are using path to get the home directory of the user to setup our webdriver.
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", path + "\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		return driver;
	}
	
}
