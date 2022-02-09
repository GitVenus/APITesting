package testScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequestSample {

	int userId=2;
	@Test
	public void updateUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Paul");
		requestParams.put("job", "Cloud Architect");
		Response resp =		RestAssured.given()
		.accept(ContentType.JSON)
		.contentType("application/json")
		.and()
		.body(requestParams.toString())
		.put("/2");
		
		System.out.println("Status Code : " + resp.getStatusCode());
		System.out.println("Is job of employee 2 Cloud Architect? " + resp.asString().contains("Cloud Architect"));
		Assert.assertTrue(resp.asString().contains("Cloud Architect"));
		
	}
	@Test
	public void deleteUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		Response resp = RestAssured.given()
				.delete("/2");
		System.out.println("Status code after delete : " + resp.statusCode());
				
	}
}
