package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import page_validation.*;

public class Driver_manager{
	
	public static WebDriver create_driver(String browser_name) {
		WebDriver driver = null;
		System.out.println("Inside create_driver --->");
		try {
			if(browser_name.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "D:/IT/java_practice/framework_build_project/test_dev_project/chromedriver.exe");
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.addArguments("--start-maximized");
				chrome_options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				driver = new ChromeDriver(chrome_options);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("driver creation successful!");
		return driver;
	}

}
