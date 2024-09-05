package auto_runner;

import org.testng.annotations.*;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.testng.*;
import page_validation.*;
import utilities.Read_config;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "glue_code",
		plugin = {"utilities.StepDetails"}
		)


public class Cucumber_Runner {
	
	private TestNGCucumberRunner testng_cucumber_runner;
	
	@BeforeSuite
	public void setup_extent()throws Throwable{
		Base_class.spark_obj = new ExtentSparkReporter(System.getProperty("user.dir") + Read_config.get_from_config("extent_report_path"));
		Base_class.extent_obj.attachReporter(Base_class.spark_obj);
	}
	
	@BeforeClass(alwaysRun = true)
	public void set_up_class() throws Throwable{
		testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumber_feature) {
		testng_cucumber_runner.runScenario(pickle.getPickle());
	}
	
	@DataProvider(name = "features")
	public Object[][] scenarios(){
		if(testng_cucumber_runner == null) {
			System.out.println("Runnner is returning null: dataprovider");
			testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
		}
		else {
			System.out.println("Runner is not null: dataprovider");
		}
		return testng_cucumber_runner.provideScenarios();
	}
	
	@AfterMethod
	public void after_test() throws Throwable{
		try {
			if(Base_class.driver != null) {
				Base_class.driver.quit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(alwaysRun = true)
	public void tear_down_class() throws Throwable{
		try {
			testng_cucumber_runner.finish();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void terminate_driver() throws Throwable{
		try {
			System.out.println("Inside terminate_driver --->");
			
			Base_class.extent_obj.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
