package Functionalcheck;
import common.Commonmethods;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.PageFactory;

import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.support.ui.Select;

import TestBase.BrowserLaunch;

public class SeleniumUICheck extends PageFactory{
	
	//For the first test case
	

	@BeforeTest
	public static void Browserlaunch() {
		
		try {
			BrowserLaunch.initWebDriver();
			BrowserLaunch.webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		}catch(Throwable e) {
			Commonmethods.PrintMessage("there is issue with browser launch");
		}
		
	}
	
	@Test(priority = 1, enabled= true)
	public static void Test01_dragdrop() {
		Dropbutton.click();
		Actions action = new Actions(BrowserLaunch.webdriver);
		//moves the button from one end to other
		action.dragAndDrop(Source,Target);
	}
	
	@Test(priority =2,enabled =true)
	public static void Test02_Selectable() {
		Selectbutton.click();
		//Select the 3 options simultaneously
		Actions action = new Actions(BrowserLaunch.webdriver);
		//to press control key and select 3 options to enable simultaneous selection
		action.keyDown(Keys.CONTROL).click(Firstoption).click(Thirdoption).click(Seventhoption).build().perform();
		
	}
	
	@Test(priority =3,enabled =true)
	public static void Test03_Selectable() {
		ControlButton.click();
		// to select SUV
		Select select  = new Select(CartypeButton);
		select.selectByIndex(4);
		//to select top values
		AutomaticButton.click();
		Insurancetopbutton.click();
		// to enter car quantity
		inputbox.sendKeys("2");
		//Select the 2 pane options
		Select select1 = new Select(Cartype2Button);
		select1.deselectByVisibleText("Truck");
		Standardbutton.click();
		Insurancebutton.click();
		Numberinput.sendKeys("1");
	}
	
	@AfterTest
	public static void CloseBrowser() {
		BrowserLaunch.closeDriver();
		
	}
	

}
