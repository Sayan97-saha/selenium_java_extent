package glue_code;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_validation.*;
import utilities.*;

public class selenium_gluecode extends Base_class{
	
	@Before
	public void before_method(Scenario scenario)throws Throwable{
		initialize_scenario(scenario);
	}
	
	@BeforeStep
	public void before_step() {
		extent_log_msg = "";
	}
	
	Home_Page home_page = null;
	
	@Given("User is preparing to test {string}")
	public void user_is_preparing_to_test(String test_keyword) throws Throwable {
		 
		scenario_keyword = test_keyword;
		extent_test_obj = extent_obj.createTest(scenario.getName());
		
		driver = Driver_manager.create_driver("chrome");
		actions_obj = new Actions(driver);
		home_page = new Home_Page(driver);
		cmn_mthds = new Common_methods();
		cmn_mthds.setup_wait();
		String url_val = Read_config.get_from_config("url");
		driver.navigate().to(url_val);
		step_log(url_val + " opened successfully!");
		capture_screenshot();
		System.out.println("step_fetch = " + StepDetails.stepName);
		Assert.assertEquals(Read_config.get_from_config("expected_page_title"), driver.getTitle());
		boolean res = false;
		if((Read_config.get_from_config("expected_page_title")).equals(driver.getTitle())) {
			res = true;
		}
		extent_log_msg = url_val + " opened successfully!";
		//cmn_mthds.assertion_method("Given", res, extent_log_msg);
		cmn_mthds.assertion_method(res, extent_log_msg);
	}

	@When("User closes the login popup")
	public void test_step_one() throws Throwable {
		Assert.assertTrue(home_page.close_login_popup());
		//cmn_mthds.assertion_method("Given", home_page.close_login_popup(), extent_log_msg);
		cmn_mthds.assertion_method(home_page.close_login_popup(), extent_log_msg);
	}
	
	@When("User clicks on the {string} link")
	public void link_check(String parameter_val) throws Throwable {
		Assert.assertTrue(home_page.link_click_chk(parameter_val));
		//cmn_mthds.assertion_method("When", home_page.link_click_chk(parameter_val), extent_log_msg);
		cmn_mthds.assertion_method(home_page.link_click_chk(parameter_val), extent_log_msg);
	}

	@Then("test step_two")
	public void test_step_two() {
		System.out.println("step 2");
	}

}
