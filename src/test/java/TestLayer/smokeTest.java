package TestLayer;

import PageObjects.homepage;
import PageObjects.pageActions;
import PageObjects.regpage;

public class smokeTest {


	
	
	public static void main(String[] args) {
		
		String expResult;
		String actualREsult;

		
		
		// Page Objects 
		homepage testHomepage = new homepage();
		regpage testRegpage = new regpage();
		pageActions pa = new pageActions();
		
		
		
		// ######### page Objects Driven Test 
		// Login Test 
		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.login();
		pa.closeBrowser();
		
		
		// Log Out 
		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.login();
		testHomepage.logOut();
		pa.closeBrowser();
		
		
		// Registration 
		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.gotoRegPage();
		
//		String randomName;
//		randomName = "Abcd" +  Math.random();
//		testRegpage.completeRegistration(randomName+"@gmail.com",randomName,randomName);
//		pa.closeBrowser();

		
	}

	
}
