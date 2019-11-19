package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.homepage;
import PageObjects.myaccountpage;
import PageObjects.pageActions;
import PageObjects.regpage;

public class nmktsmoketest {

	public homepage testHomepage;
	public regpage testRegpage;
	public myaccountpage testmyaccountpage;

	public pageActions pa;


	@BeforeMethod
	public void prepareAllPageObject() {
		testHomepage = new homepage();
		testRegpage = new regpage();
		testmyaccountpage = new myaccountpage();

		pa = new pageActions();

	}

	@Test
	public void loginTest() {

		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.login();
		Assert.assertEquals(testHomepage.validateProfileNameExist("James williams"), true,"Failed Pfname is not found");
		
	}

	@Test
	public void logOutTest() {

		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.login();
		testHomepage.logOut();
		Assert.assertEquals(testHomepage.validateProfileNameNotExsit("James williams"), true,"Failed Pname is not Expected at this point ");
	}
	
	@Test
	public void myAccountTest() {

		testHomepage.LaunceBrowser("chrome"); 
		testHomepage.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/");
		testHomepage.login();	
		testHomepage.takeMetoMyaccount();
		Assert.assertEquals(testmyaccountpage.validateMyAccountLabelExist("My AccountXYR"), true,"Failed My Account LAbel is not Found  ");
	}
	
	@AfterMethod
	public void tearDown() {
		pa.closeBrowser();
	}
	
}
