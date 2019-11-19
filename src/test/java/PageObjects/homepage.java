package PageObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class homepage extends pageActions {


	// All Locators Variables 
	public  String loginLink = "xpath://*[@id='dLabellogin']/span";
	public  String signUpButton = "xpath:.//*[@id='jqSignup']";
	public  String loginButton = "xpath://*[@id='jqLogin']";
	public  String userIdTextField = "xpath://*[@id='username']";
	public  String passwordTextField = "xpath://*[@id='password']";
	public  String prfileNameLink = "xpath://*[@id='dLabel']/span";
	public  String logOutLink = "xpath:.//*[@id='drp_div']/ul/li/div/div[3]/a";
	public  String myAccountLink = "xpath://*[@id='drp_div']/ul/li/div/div[1]/a";




	public void LaunceBrowser(String browserName) {

		if(browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/rasulm/eclipse-workspace/Z_SchoolProjects_PTWorld/myseleniumproject/chromedriver");
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/rasulm/eclipse-workspace/Z_SchoolProjects_PTWorld/myseleniumproject/chromedriver");
			driver = new FirefoxDriver();
		} else if(browserName.equals("ie")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/rasulm/eclipse-workspace/Z_SchoolProjects_PTWorld/myseleniumproject/chromedriver");
			driver = new InternetExplorerDriver();
		}

	}


	public void gotoWebsite(String url) {
		driver.get(url);
	}


	public void login() {
		// ==>> Login Operation on Our Site 
		clickElement(loginLink); 			// Readeable 
		typeOn(userIdTextField, "user");	// readable 
		typeOn(passwordTextField, "pass");	// Readable 
		clickElement(loginButton); 			// Read Able 
	}

	public void logOut() {
		// ==>> Login Operation on Our Site 
		clickElement(prfileNameLink); 			// Readeable 
		clickElement(logOutLink); 			// Readeable 
	}

	public  void gotoRegPage() {
		// ==>> Login Operation on Our Site 
		clickElement(loginLink); 			// Readeable 
		clickElement(signUpButton); 			// Readeable 
	}


	public boolean validateProfileNameExist(String pname) {
		try {
			String expResult =  pname;		
			String actualREsult = getElementValue(prfileNameLink);


			if(expResult.equalsIgnoreCase(actualREsult)) {
				return  true;
			} else {
				return  false;
			}
		}catch(Exception e) {

			return  false;
		}

	}


	public boolean validateProfileNameNotExsit(String pname) {
		try {
			String expResult =  pname;		
			String actualREsult = getElementValue(prfileNameLink); // 
			if(expResult.equalsIgnoreCase(actualREsult)) {
				return false;
			} else {
				return true;
			}	
		}
		catch(Exception e) {
			return true;
		}
	}


	public void takeMetoMyaccount() {
		clickElement(prfileNameLink);
		clickElement(myAccountLink);

	}



	public void closebrowser() {
		closeBrowser();	
	}



	public byte[] takeFailScreenShot() {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			return screenshot;
		} catch (Exception e) {
			System.out.println("Error Taking Ecreen Shot");
		}
		return null;
	}





}
