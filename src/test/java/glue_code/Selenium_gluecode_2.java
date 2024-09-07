package glue_code;

import io.cucumber.java.en.*;
import page_validation.Base_class;

public class Selenium_gluecode_2 {
	
	private Base_class base_class;
	public Selenium_gluecode_2(Base_class base_class) {
		this.base_class = base_class;
	}
	
	@When("test_step_2")
	public void test_step_2() {
		System.out.println("base_class.test_str value from test_step_2 = " + base_class.test_str);
		base_class.test_str = "test_step_2";
		System.out.println("base_class.test_str value modified by test_step_2 = " + base_class.test_str);
	}

}
