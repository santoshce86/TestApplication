package common;
import java.util.Properties;

import org.testng.Reporter;

import java.io.FileInputStream;
import java.util.Enumeration;

public class Commonmethods {
	public static String getPropValuesFromFile(String filePath, String key1) {
		String returnValue = null;
		try {
			Properties properties = new Properties();
			FileInputStream stream = new FileInputStream(filePath);
			properties.load(stream);
			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				if (key.equals(key1)) {
					returnValue = value;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Key not present in properties file ");
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public static void PrintMessage(String message) {
		System.out.println(message);
		Reporter.log(message);
	}


}
