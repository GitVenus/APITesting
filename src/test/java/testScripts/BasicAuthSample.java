package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthSample {
//	@Test
	public void preemptiveAuth() {
		RestAssured.given().auth()
		.preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().log().body();
		
	}
	//@Test
	public void challenged11Auth() {
		RestAssured.given().auth()
		.basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().log().body();
		
	}
	
	//885a0b839845e5a8ee138d877b56fee0
	
	@Test
	public void getWeatherWithAPI() {
		RestAssured.given().queryParam("q", "Kochi")
		.queryParam("appid", "885a0b839845e5a8ee138d877b56fee0")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().log().body();
	}

	@Test
	public void validateCountry() {
		String strCountry =		RestAssured.given().queryParam("q", "Kochi")
		.queryParam("appid", "885a0b839845e5a8ee138d877b56fee0")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().extract().path("sys.country");
		Assert.assertTrue(strCountry.equals("IN"));
	}
	@Test
	public void getWeather() {
		String mainWeather =		RestAssured.given().queryParam("q", "Kochi")
		.queryParam("appid", "885a0b839845e5a8ee138d877b56fee0")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().extract().path("weather[0].description");
		System.out.println("Main Weather is : " + mainWeather);
	}
	@Test
	public void getAnything() {
		Float anyThing =		RestAssured.given().queryParam("q", "Kochi")
		.queryParam("appid", "885a0b839845e5a8ee138d877b56fee0")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().extract().path("coord.lon");
		System.out.println("Anthing is : " + anyThing);
	}
}

