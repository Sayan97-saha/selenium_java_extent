package page_validation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Read_config;

public class Home_Page extends Base_class{
	
	
	@FindBy(xpath = "//button[text()='✕']")
	private List<WebElement> close_login_popup;
	
	@FindBy(xpath = "//input[@name='q' or @title = 'Search for products, brands and more' or @title = 'Search for products, Brands and More']")
	private WebElement product_search_box;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement register_link;
	
	@FindBy(xpath = "//div[@id='rightPanel']/h1")
	private WebElement right_panel_header;
	
	@FindBy(xpath = "//div[@id='rightPanel']/p")
	private WebElement right_panel_msg;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean close_login_popup() throws Throwable{
		boolean res = false;
		
		
		try {
			if(close_login_popup.size() > 0) {
				close_login_popup.get(0).click();
			}
			res = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean search_products()throws Throwable{
		boolean res = false;
		try {
			product_search_box.sendKeys("");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean link_click_chk(String parameter_val) throws Throwable{
		boolean res = false;
		String log_text = "";
		try {
			Base_class.cmn_mthds.click_on(register_link);
			capture_screenshot();
			cmn_mthds.custom_wait("visible", right_panel_header);
			cmn_mthds.custom_wait("visible", right_panel_msg);
			
			String panel_header_txt_actual = cmn_mthds.get_from_element(right_panel_header, "text");
			String panel_msg_txt_actual = cmn_mthds.get_from_element(right_panel_msg, "text");
			String panel_header_txt_expctd = Read_config.get_from_config("register_panel_header");
			String panel_msg_txt_expctd = Read_config.get_from_config("register_panel_msg");
			
			log_text = "Header text(expected) = " + panel_header_txt_expctd + "\n" + "Header text(actual) = " + panel_header_txt_actual + "\n" + 
					"Message text(expected) = " + panel_msg_txt_expctd + "\n" + "Message text(actual) = " + panel_msg_txt_actual;
			
			if(panel_header_txt_actual.equals(panel_header_txt_expctd) && panel_msg_txt_actual.equals(panel_msg_txt_expctd)) {
				res = true;
				log_text = "Validation passed!" + "\n" + log_text;
			}
			else {
				log_text = "Validation failed!" + "\n" + log_text;
			}
			extent_log_msg = log_text;
			step_log(log_text);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	
	
	
	

}
