package Challenge;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.ITestListener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// BONUS
		
		/* Instantiate a webdriver  */
		WebDriver driver = new ChromeDriver();
		
		/* Navigate to https://www.google.com */
		String baseURL = "https://www.google.com";
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		
		/* Searches for "Happy Returns" */
		
		driver.findElement(By.cssSelector("input.gLFyf")).sendKeys("Happy Returns");
		driver.findElement(By.className("gNO89b")).click();
		
		/* Assert that https://www.happyreturns.com is the first
		 * non-advertised link in the list of results */
		
		driver.findElement(By.cssSelector("#res .rc")).click(); // clicks the first non-ad link
		String currentURL = driver.getCurrentUrl(); // url of the webpage clicked above
		
		Assert.assertEquals(currentURL, "https://www.happyreturns.com/",
				"The url doesn't match!!!");
		
		driver.quit();

	}

}
