package restAPITesting.api_automation_testing;



import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import restAPITesting.api_automation_testing.utility.CommonMethod;

public class GetRequestExample {

	
	CommonMethod cm=new CommonMethod();
	
	@Test
	public void validateInvalidLogin(){
		
		RestAssured.baseURI="https://gateway.healthrecoverysolutions.com";
		String body = "{\"data\":"
				+ "{\"type\":\"credentials\""
				+ ",\"username\":\"sreelatha.b84@gmail.com\""
				+ ",\"password\":\"test\","
				+ "\"source\":\"ClinicianConnect 2\"}}";
		Response response=RestAssured
				.given()
				.contentType("application/json")
				.body(body)
				.when()
				.post("/v1/tokens");
		
		Assert.assertEquals(422, response.getStatusCode());
		Assert.assertEquals("application/json",response.contentType());
		JsonPath jp= response.jsonPath();
		
		Assert.assertEquals("Invalid Credentials", jp.getString("message"));

		
		
	}
	
	
	@Test
	public void validateLoginwithBalnkUserName(){
		
		RestAssured.baseURI="https://gateway.healthrecoverysolutions.com";
		String body = "{\"data\":"
				+ "{\"type\":\"credentials\""
				+ ",\"username\":\"\""
				+ ",\"password\":\"test\","
				+ "\"source\":\"ClinicianConnect 2\"}}";
		Response response=RestAssured
				.given()
				.contentType("application/json")
				.body(body)
				.when()
				.post("/v1/tokens");

		Assert.assertEquals(422, response.getStatusCode());
		Assert.assertEquals("application/json",response.contentType());
		JsonPath jp= response.jsonPath();
		
		Assert.assertEquals("Invalid Credentials", jp.getString("message"));
		
	}
	
	@Test
	public void validateLoginwithBalnkUserNameandPassword(){
		
		RestAssured.baseURI="https://gateway.healthrecoverysolutions.com";
		String body = "{\"data\":"
				+ "{\"type\":\"credentials\""
				+ ",\"username\":\"\""
				+ ",\"password\":\"\","
				+ "\"source\":\"ClinicianConnect 2\"}}";
		Response response=RestAssured
				.given()
				.contentType("application/json")
				.body(body)
				.when()
				.post("/v1/tokens");

		Assert.assertEquals(422, response.getStatusCode());
		Assert.assertEquals("application/json",response.contentType());
		JsonPath jp= response.jsonPath();
		
		Assert.assertEquals("Invalid Credentials", jp.getString("message"));
		
	}
	
	
	@Test
	public void resetPassword(){
		
		RestAssured.baseURI="https://gateway.healthrecoverysolutions.com";
		
		String body= "{\n  \"data\": "
				+ "{\n    \"username\": \"sreelatha.b84@gmail.com\",\n    "
				+ "\"landing_url\": \"https://cc.healthrecoverysolutions.com/recovery\"\n  }\n}";
		Response response=RestAssured
				.given()
				.contentType("application/json")
				.body(body)
				.when()
				.post("v1/password-reset-tokens");
		Assert.assertEquals(204, response.getStatusCode());	
		
	}
	
	

	
}
