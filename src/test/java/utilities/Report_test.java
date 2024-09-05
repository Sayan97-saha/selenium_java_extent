package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report_test {
	
	public static void main(String[] args) throws Throwable {
		ExtentReports extent = new ExtentReports();
		String report_path = System.getProperty("user.dir") + Read_config.get_from_config("extent_report_path");
		System.out.println("report_path = " + report_path);
		ExtentSparkReporter spark = new ExtentSparkReporter(report_path);
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();
	}

}
