package testScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestSample {
    @Test
    public void postUserWithAuth() {
	//RestAssured.baseURI = "https://reqres.in/api/users";
    	RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("name", "TestUser");
	//jsonObject.put("job", "TestArchitect");
	jsonObject.put("email", "test23user@gmail.com");
	jsonObject.put("gender", "female");
	jsonObject.put("status", "Active");
	System.out.println(jsonObject.toString());
	Response resp = RestAssured.given()
			.header("authorization","Bearer ff76351ffa8dc00efe7305d51a40e63b0d72e298f2c94de333e9f666f29efbed")
			.accept(ContentType.JSON)
			.contentType("application/JSON")
			.and()
			.body(jsonObject.toString())
			.post();
	System.out.println("Status Code : " + resp.getStatusCode());
    }
}
