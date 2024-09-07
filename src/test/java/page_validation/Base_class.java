package page_validation;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Scenario;
import utilities.*;

public class Base_class {
	
	public WebDriver driver;
	public String scenario_keyword = "";
	public Actions actions_obj = null;
	public WebDriverWait wait_obj = null;
	public static Scenario scenario;
	public Common_methods cmn_mthds = null;
	public static ExtentReports extent_obj = new ExtentReports();
	public static ExtentSparkReporter spark_obj = null;
	public static ExtentTest extent_test_obj = null;
	public String extent_log_msg = "";
	public String test_str = "default";
	
			
	
	
	
	public void initialize_scenario(Scenario scenario) {
		Base_class.scenario = scenario;
	}
	
	
	
	public void step_log(String log_msg) {
		scenario.log(log_msg);
	}
	
	public void capture_screenshot() {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot");
	}
	
	
	
}
