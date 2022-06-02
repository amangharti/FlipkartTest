package testCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileSection {

	WebDriver driver;
	
	@BeforeMethod
	public void setupTest() {
		driver = browserconfig.BrowserConfig.open("chrome");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@class , '_2QfC02')]/button")).click();
		boolean actualOutput = driver.findElement(By.xpath("//img[@title='Flipkart']")).isDisplayed();
		Assert.assertEquals(true, actualOutput);
		System.out.println("User at Flipkart Page");
	}
	
	@Test(priority=1)
	public void searchRealmeBrand() {
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='realme']")).click();
		driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
		
		String oldTab = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[text() = 'realme GT 2 Pro (Steel Black, 256 GB)']")).click();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    
	    driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Task Run Sucessfully");
	}
}
