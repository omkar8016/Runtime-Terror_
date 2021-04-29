package Functionalities;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WriteExcel.WriteCruiseDetails;

public class PassengersAndCrew {
	 
    //public static WebDriver driver;
    WebDriver driver;
	 
	public PassengersAndCrew(WebDriver driver)
	{
		this.driver=driver;
	}
    
    //To take screenshot
    public void TakeScreenShot(String Name) {
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		String path = System.getProperty("user.dir");
		File DestFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\" + Name +".png");
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    By passengerAndCrew = By.xpath("//*[@id=\"ship_overview\"]/div/div/div/div[1]/div[1]/div[2]/div[1]");
    By PassengerAndCrew = By.cssSelector("#ship_overview > div > div > div > div.ui_column.is-6-desktop.is-12-mobile.is-12-tablet._2uUROZdb > div.ui_column.is-12-desktop.is-12-mobile.is-12-tablet._114pqgnv > div._30ZCn9lR > div:nth-child(1)");
    // To write Passengers and Crew data in excel file
    public void passengersAndCrew(String parent,WriteCruiseDetails excel)throws IOException, InterruptedException {
        
        JavascriptExecutor jse=(JavascriptExecutor)driver;
 
        Set<String> s = driver.getWindowHandles();
        for (String element : s) {
            if (!parent.equals(element)) {
                driver.switchTo().window(element);
            }
        }
        //To take a screenshot
        Thread.sleep(300);
      	TakeScreenShot("Cruise Page");
      	
        jse.executeScript("window.scrollBy(0,350)");
        
        //WebElement passenger = driver.findElement(By.xpath("//*[@id=\"ship_overview\"]/div/div/div/div[1]/div[1]/div[2]/div[1]"));
        WebElement passenger = driver.findElement(passengerAndCrew);
        System.out.println(passenger.getText());
        
        //excel.writeToExcel(driver.findElement(By.cssSelector("#ship_overview > div > div > div > div.ui_column.is-6-desktop.is-12-mobile.is-12-tablet._2uUROZdb > div.ui_column.is-12-desktop.is-12-mobile.is-12-tablet._114pqgnv > div._30ZCn9lR > div:nth-child(1)")).getText());
        excel.writeToExcel(driver.findElement(PassengerAndCrew).getText());
    }
}
