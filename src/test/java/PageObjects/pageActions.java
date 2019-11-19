package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class pageActions {
	

	public static WebDriver driver;

	

	
	public void clickElement(String locators) {

		if(locators.contains("xpath")) {
			driver.findElement(By.xpath(locators.split(":")[1])).click();
		} else if(locators.contains("css")) {
			driver.findElement(By.cssSelector(locators.split(":")[1])).click();
		} else if(locators.contains("id")) {
			driver.findElement(By.id(locators.split(":")[1])).click();
		} else if(locators.contains("name")) {
			driver.findElement(By.name(locators.split(":")[1])).click();
		} 

		// Utility Code 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public void typeOn(String locators, String value) {

		if(locators.contains("xpath")) {
			driver.findElement(By.xpath(locators.split(":")[1])).sendKeys(value);
		} else if(locators.contains("css")) {
			driver.findElement(By.cssSelector(locators.split(":")[1])).sendKeys(value);;
		} else if(locators.contains("id")) {
			driver.findElement(By.id(locators.split(":")[1])).sendKeys(value);;
		} else if(locators.contains("name")) {
			driver.findElement(By.name(locators.split(":")[1])).sendKeys(value);;
		} 
	}


	public String getElementValue(String locators) {


		// Utility Code 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(locators.contains("xpath")) {
			return driver.findElement(By.xpath(locators.split(":")[1])).getText();
		} else if(locators.contains("css")) {
			return driver.findElement(By.cssSelector(locators.split(":")[1])).getText();
		} else if(locators.contains("id")) {
			return driver.findElement(By.id(locators.split(":")[1])).getText();
		} else if(locators.contains("name")) {
			return driver.findElement(By.name(locators.split(":")[1])).getText();
		}
		return null; 
	}


	public void closeBrowser() {
		driver.close();
	}
	
	
	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
}
