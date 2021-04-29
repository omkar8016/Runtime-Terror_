package Functionalities;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WriteExcel.WriteCruiseDetails;

public class LaunchedYear {
	 
    //public static WebDriver driver;
	WebDriver driver;
	public LaunchedYear(WebDriver driver)
	{
		this.driver=driver;
	}
 
	By launchYear = By.xpath("//*[contains(text(),'Launched')]");
	
    // To write Launched year in excel file
    public void launchedYear(String parent,WriteCruiseDetails excel) throws IOException 
    {
        JavascriptExecutor jse=(JavascriptExecutor)driver;
      
        Set<String> s = driver.getWindowHandles();
        for (String element : s) 
        {
            if (!parent.equals(element)) 
            {
                driver.switchTo().window(element);
            }
        }
        
        
        jse.executeScript("window.scrollBy(0,350)");
        
       //WebElement launch = driver.findElement(By.xpath("//*[contains(text(),'Launched')]"));
        WebElement launch = driver.findElement(launchYear);
        System.out.println(launch.getText()+"\n");
 
        //excel.writeToExcel(driver.findElement(By.xpath("//*[contains(text(),'Launched')]")).getText());
        excel.writeToExcel(driver.findElement(launchYear).getText());
    }       
}