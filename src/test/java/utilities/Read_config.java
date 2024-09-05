package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Read_config {
	
	
	
	public static String get_from_config(String config_key)throws Throwable{
		String res = "";
		Properties props = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
			props.load(input);
			res = props.getProperty(config_key);
			System.out.println("get_from_config(" + config_key + ") = " + res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
