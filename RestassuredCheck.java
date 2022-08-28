package Functionalcheck;

import common.Commonmethods;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

public class RestassuredCheck extends Commonmethods {
	public static String filePath = "Application.properties";
	public static String jsonfile = "schema.json";
	//to test the get input
	@Test(priority =1 ,enabled = true)
	public static void Test01_RestAssured() {
		boolean result = false;
		try {
		String URL  = Commonmethods.getPropValuesFromFile("Application.properties", "URL1");
		Commonmethods.PrintMessage("The URL is "+URL);
		Response response = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.get(URL);
		if (response.getStatusCode() == 200) {
			org.json.JSONArray arr = new org.json.JSONArray();
			for (int i = 0;i<arr.length();i++) {
				if (arr.getJSONObject(i).getInt("id") == 10) {
					if (arr.getJSONObject(i).getString("first_name").equalsIgnoreCase("Byron")) {
						Commonmethods.PrintMessage("the first name is validated");
						result = true;
					} else {
						Commonmethods.PrintMessage("mismatch between id and  first name");
						result = false;
					}
				}
			}
								
		}
		} catch (Exception e) {
			
			Commonmethods.PrintMessage("some issue with URL");
		}
		Assert.assertEquals(result, true);
    }
     
	@Test(priority = 2,enabled = true)
	public static void Test02_RestAssuredPost() {
		boolean result = false;
		try {
			
			String URL  = Commonmethods.getPropValuesFromFile("Application.properties", "URL2");
			Commonmethods.PrintMessage("The URL is "+URL);
			String Request = Commonmethods.getPropValuesFromFile("Application.properties", "Request");
			Commonmethods.PrintMessage("The Request is "+Request);
			Response response = RestAssured.given()
					.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
					.body(Request).post(URL);
			/*
			if ((response.getStatusCode() == 201) and 
				(response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new file(jsonfile))
				and if (response.then().body("id", "null")))){
				org.json.JSONArray arr = new org.json.JSONArray();
				for (int i = 0;i<arr.length();i++) {
					if (arr.getJSONObject(i).getInt("id") == 10) {
						if (arr.getJSONObject(i).getString("first_name").equalsIgnoreCase("Byron")) {
							Commonmethods.PrintMessage("the first name is validated");
							result = true;
						} else {
							Commonmethods.PrintMessage("mismatch between id and  first name");
						}
					}
				}
				*/
		
	} catch (Exception e) {
		Commonmethods.PrintMessage("there is issue with plugin");
	}
	Assert.assertEquals(result, true);
	}
	
}

