package restAPITesting.api_automation_testing.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CommonMethod {
	
	
	public Response getRequest(String baseURI, String pageNumber){
		
		RestAssured.baseURI=baseURI;
		
		Response response=RestAssured.given()
		.when()
		.get("/api/users?page="+pageNumber);
		
		return response;
		
	}
	
	public Response postRequest(String baseURI, String requestURL, String body){
		RestAssured.baseURI=baseURI;
		Response response=RestAssured.given().
				contentType("application/json")
				.body(body)
				.when()
				.post(requestURL);
		return response;		
	}

}
