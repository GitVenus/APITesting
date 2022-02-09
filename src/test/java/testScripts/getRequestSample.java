package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class getRequestSample {

	@Test
	public void testResponseStatus() {
		RequestSpecification request =		RestAssured.given();
		//request.baseUri("https://demoqa.com/utilities/weather/city");
		//Response response = 		request.get("/Chennai");
		request.baseUri("https://gorest.co.in/public/v2/users");
		Response response = 		request.get("test23user@gmail.com");
		
		 String resString = response.asPrettyString();
		 System.out.println("Response Details : " + resString);
		 System.out.println("Response Headers : " + response.getContentType());
		 System.out.println("Status Code : " + response.statusCode());
		 ValidatableResponse valRes = 		 response.then();
		 valRes.statusCode(200);
		 Headers allHeaders = 		 response.headers();
		 for(Header header: allHeaders) {
			 System.out.println("Key :" + header.getName() + "  Value : " + header.getValue());
		 }
		 String serverType = 		 response.header("Server");
		Assert.assertEquals(serverType,"nginx/1.17.10 (Ubuntu)");
		Assert.assertEquals(resString.toLowerCase().contains("test23user"),true);
		JsonPath jsonPathEval=		response.jsonPath();
		System.out.println("City Name : "+jsonPathEval.get("email"));
		String cityName = jsonPathEval.get("email");
		Assert.assertEquals(cityName, "test23user","Expcted city name is fetched");

	}
	@Test
	public void testResponseBDD() {
		RestAssured.given().baseUri("https://demoqa.com/utilities/weather/city").when().get("/Chennai").then().statusCode(200);
	}
	
	
	
	
	
	
}
