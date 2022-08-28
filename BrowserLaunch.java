package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common.Commonmethods;

public class BrowserLaunch {
	public static String ApplPropFilePath = "config.properties";
	public static WebDriver webdriver = null;
	public static WebDriver returnDriver()
	{
		return webdriver;
	}
	
	public static WebDriver initWebDriver() throws Throwable {
		String URL = Commonmethods.getPropValuesFromFile(ApplPropFilePath, "URL");	
		WebDriver webdriver = null;
		String browser = Commonmethods.getPropValuesFromFile(ApplPropFilePath, "Browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Commonmethods.getPropValuesFromFile(ApplPropFilePath, "ChromeDriver"));
		} else if (browser.equals("internet explorer")) {
			System.setProperty("webdriver.ie.driver", Commonmethods.getPropValuesFromFile(ApplPropFilePath, "IEDriverPath"));
		}
		if (browser.equals("chrome")) {
				webdriver = new ChromeDriver();
				webdriver.manage().window().maximize();
			} else if (browser.equals("ie")) {
				webdriver = new InternetExplorerDriver();
				webdriver.manage().window().maximize();
				
			}
		webdriver.get("URL");		
		return webdriver;
		
	}
	
	public static void closeDriver()
	{
		webdriver.close();
		webdriver.quit();
	}
}
