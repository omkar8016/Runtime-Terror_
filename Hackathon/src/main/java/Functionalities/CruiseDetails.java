package Functionalities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CruiseDetails 
{
	WebDriver driver;
	 
	public CruiseDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver setDriver(WebDriver driver) throws IOException 
	{
		Properties prop =new Properties(); 
		//Importing the config file
		InputStream input= new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
		//Loading the config file
		prop.load(input);
		driver.get(prop.getProperty("Cruise_Url"));	
		return driver;
	}
	
	By cruiseLine = By.xpath("//*[@id=\"component_1\"]/div/div[3]/div/div[1]/div/button");
	By selectCruiseLine = By.xpath("//*[@id=\"menu-item-17391487\"]");
	
	public void SetCruiseLine(WebDriver driver, String CruiseLine) 
	{
		//driver.findElement(By.xpath("//*[@id=\"component_1\"]/div/div[3]/div/div[1]/div/button")).click();
		//driver.findElements(By.xpath("//*[@id=\"menu-item-17391487\"]")).get(0).click();
		driver.findElement(cruiseLine).click();
		driver.findElements(selectCruiseLine).get(0).click();
	}
		
	By cruiseShip = By.xpath("//*[@id=\"component_1\"]/div/div[3]/div/div[2]/div/button");
	By selectCruiseShip = By.xpath("//*[@id=\"menu-item-17735350\"]");
	
	public void SetCruiseShip(WebDriver driver, String CruiseShip) 
	{
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"component_1\"]/div/div[3]/div/div[2]/div/button")).click();
		driver.findElement(cruiseShip).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
		driver.findElement(selectCruiseShip).click();
		//driver.findElements(By.xpath("//*[@id=\"menu-item-17735350\"]")).get(0).click();	
	}
	
	By search = By.cssSelector("span._2O1ErRJV:nth-child(1) > button");
	
	public void SearchCruise(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span._2O1ErRJV:nth-child(1) > button")));
	    //driver.findElement(By.cssSelector("span._2O1ErRJV:nth-child(1) > button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(search));
		driver.findElement(search).click();
	}
}
