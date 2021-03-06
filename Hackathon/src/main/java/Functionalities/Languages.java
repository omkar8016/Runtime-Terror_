package Functionalities;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WriteExcel.WriteCruiseDetails;

public class Languages 
{
   // public static WebDriver driver;
    WebDriver driver;
    
	public Languages(WebDriver driver)
	{
		this.driver=driver;
	}
 
	By languageList = By.cssSelector("span[class='_1wk-I7LS']");
    // To write Languages in excel file
    public void languages(String parent,WriteCruiseDetails excel) throws IOException 
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
        
        
        
        //List<WebElement> list = driver.findElements(By.cssSelector("span[class='_1wk-I7LS']"));
        List<WebElement> list = driver.findElements(languageList);
        
        for (WebElement element : list) 
        {
            excel.writeToExcel(element.getText());
            System.out.println(element.getText());
        }
        System.out.println("\n");
    }
}
