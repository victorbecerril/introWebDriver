package intro;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooSearchMain {
	
	

	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
	    WebDriver driver;
	    //Open browser
		driver = new ChromeDriver();
		//Sets 30 sec of waiting for the session
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		//Browse to specified web site
		driver.get("http://www.yahoo.com");
		//Find search box
		WebElement searchBox = driver.findElement(By.id("uh-search-box"));
		//Find search button
		WebElement searchButton = driver.findElement(By.id("uh-search-button"));
		//Clear any text in the search box
		searchBox.clear();
		//Send the specified input in the text box
		searchBox.sendKeys("Selenium");
		//Click on search button
		searchButton.click();
		//Find the specified link
		WebElement seleniumLink = driver.findElement(By.linkText("Selenium - Web Browser Automation"));
		//Click on the specified link (This opens the link in a new window)
		seleniumLink.click();
		//Instantiates the String ArrayList "windowIds" and fill with number of handled windows
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		//Displays ArrayList windowIds' size 
		System.out.println("Number of windows: " + windowIds.size());
		//This is supposed to switch between each window but can't really tell if it's working as expected
		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
			System.out.println("switched to window: " + windowId);
		}
		//Find the "Download" link
		WebElement downloadLink = driver.findElement(By.linkText("Download"));
		//Click the "Download" link
		downloadLink.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 18);
		
		wait.until(ExpectedConditions.invisibilityOfAllElements(findElement(By.class)));
		
		//Close all windows from current session
		driver.quit();

	}

}
