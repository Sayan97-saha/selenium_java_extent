package glue_code;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_validation.*;
import utilities.Common_methods;
import utilities.Driver_manager;
import utilities.Read_config;
import utilities.StepDetails;

public class selenium_gluecode {
	
	private Base_class base_class;
	public selenium_gluecode(Base_class base_class) {
		this.base_class = base_class;
	}
	
	
	@Before
	public void before_method(Scenario scenario)throws Throwable{
		base_class.initialize_scenario(scenario);
	}
	
	@BeforeStep
	public void before_step() {
		base_class.extent_log_msg = "";
	}
	
	@After
	public void after_test() throws Throwable{
		try {
			if(base_class.driver != null) {
				base_class.driver.quit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	Home_Page home_page = null;
	
	@Given("User is preparing to test {string}")
	public void user_is_preparing_to_test(String test_keyword) throws Throwable {
		 
		base_class.scenario_keyword = test_keyword;
		Base_class.extent_test_obj = Base_class.extent_obj.createTest(base_class.scenario.getName());
		
		base_class.driver = Driver_manager.create_driver("chrome");
		base_class.actions_obj = new Actions(base_class.driver);
		home_page = new Home_Page(base_class);
		base_class.cmn_mthds = new Common_methods(base_class);
		base_class.cmn_mthds.setup_wait();
		String url_val = Read_config.get_from_config("url");
		base_class.driver.navigate().to(url_val);
		base_class.step_log(url_val + " opened successfully!");
		base_class.capture_screenshot();
		String step_name = StepDetails.stepName;
		System.out.println("step_fetch = " + StepDetails.stepName);
		Assert.assertEquals(Read_config.get_from_config("expected_page_title"), base_class.driver.getTitle());
		boolean res = false;
		if((Read_config.get_from_config("expected_page_title")).equals(base_class.driver.getTitle())) {
			res = true;
		}
		base_class.extent_log_msg = url_val + " opened successfully!";
		//cmn_mthds.assertion_method("Given", res, extent_log_msg);
		base_class.cmn_mthds.assertion_method(step_name, res, base_class.extent_log_msg);
	}

	@When("User closes the login popup")
	public void test_step_one() throws Throwable {
		//Assert.assertTrue(home_page.close_login_popup());
		String step_name = StepDetails.stepName;
		//cmn_mthds.assertion_method("Given", home_page.close_login_popup(), extent_log_msg);
		base_class.cmn_mthds.assertion_method(step_name, home_page.close_login_popup(), base_class.extent_log_msg);
	}
	
	@When("User clicks on the {string} link")
	public void link_check(String parameter_val) throws Throwable {
		//Assert.assertTrue(home_page.link_click_chk(parameter_val));
		String step_name = StepDetails.stepName;
		//cmn_mthds.assertion_method("When", home_page.link_click_chk(parameter_val), extent_log_msg);
		base_class.cmn_mthds.assertion_method(step_name, home_page.link_click_chk(parameter_val), base_class.extent_log_msg);
	}

	@Then("test step_two")
	public void test_step_two() {
		System.out.println("step 2");
	}
	
	@Given("test_step_1 {string}")
	public void test_step_1(String test_keyword) throws Throwable{
		base_class.scenario_keyword = test_keyword;
		System.out.println("base_class.test_str original = " + base_class.test_str);
		base_class.test_str = base_class.scenario_keyword;
		System.out.println("base_class.test_str modified by test_step_1 = " + base_class.test_str);
	}
	
	@Then("test_step_3")
	public void test_step_3() {
		System.out.println("base_class.test_str value from test_step_3 = " + base_class.test_str);
		base_class.test_str = "test_step_3";
		System.out.println("base_class.test_str value modified by test_step_3 = " + base_class.test_str);
	}

}
