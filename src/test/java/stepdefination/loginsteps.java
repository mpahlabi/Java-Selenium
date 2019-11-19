package stepdefination;

import PageObjects.homepage;
import PageObjects.regpage;
import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;



public class loginsteps {

	
	homepage testhome;
	
	
	// Setup 
	@Before
	public void tearUP() {

	}
	
	
	// ALl Real Test Code will Go here 
	
	@Given("I am on mct-website home page")
	public void i_am_on_mct_website_home_page() {
		
		System.out.println(">>>> Going MCT Home Page......");		
		testhome = new homepage();
		testhome.LaunceBrowser("chrome");
		testhome.gotoWebsite("https://www.demo.iscripts.com/multicart/demo/index.php");		
		
	}

	@When("I complete login with valid credentails")
	public void i_complete_login_with_valid_credentails() {
		System.out.println(">>> Login With Valid Credentaisl ......");
		testhome.login();
	}

	@Then("I see my profile as {string}")
	public void i_see_my_profile_as(String prfoleName ) {
		
		System.out.println(">>>> Validating James Willimas  ......");
		
		boolean isProfileNameFOund = testhome.validateProfileNameExist(prfoleName);
	
		
		assertEquals("FAILED : Profile Name not Matched!!!",true,isProfileNameFOund);
	}
	
	@And("I go to reg page")
	public void i_go_to_reg_page() {
		testhome.gotoRegPage();
	}

	@When("I complete registration with Fname {string} and Lname as {string}")
	public void i_complete_registration_with(String fname, String lname) {
		
		regpage testregpage = new regpage();
		testregpage.completeRegistration(fname+lname+"@gmail.com", fname+lname, fname, lname);
	}

	
	@When("I complete logout")
	public void i_do_a_log_out() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new cucumber.api.PendingException();
		testhome.logOut();
		
	}

	@Then("I see my james williams is not there")
	public void i_see_my_profile_name_is_not_there() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new cucumber.api.PendingException();
		
		boolean actualresult = testhome.validateProfileNameNotExsit("James Williams");
		
		assertEquals("FAILED : Profile Name not Matched!!!",actualresult,false);

	}

	
	
	
	@When("I complete registration with below data")
	public void i_complete_registration_with_below_data(DataTable dataTable) {
	  		
	      List<String> data = dataTable.asList();

	      for(int i=0;i<data.size();i++) {
	    	  
	    	  System.out.println(data.get(i));
	      }
		
	}
	
	
	
	
	
	
	
	
	// Clean Up 
	@After
	public void tearDown(Scenario scenario) {
		
		
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = testhome.takeFailScreenShot();
				scenario.embed(screenshot, "image/png");
				testhome.closebrowser();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			testhome.closebrowser();
		}
		
	}
}
