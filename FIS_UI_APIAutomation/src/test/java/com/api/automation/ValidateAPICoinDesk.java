package com.api.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateAPICoinDesk {
	protected RequestSpecification request;
	
	@BeforeClass
	public void setUp() throws Exception {
		RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";
		request = RestAssured.given();	
	}
	@Test
	public void testCoinDeskAPI() {
		// Define the base URI

		Response response = request
				.when()
				.get().then()
				.statusCode(200) // Verify the response status code is 200
				.extract().response();

		String jsonResponse = response.getBody().asString();

		assertTrue(jsonResponse.contains("USD"), "Response does not contain USD");
		assertTrue(jsonResponse.contains("GBP"), "Response does not contain GBP");
		assertTrue(jsonResponse.contains("EUR"), "Response does not contain EUR");

		String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
		assertEquals("British Pound Sterling", gbpDescription, "GBP description does not match");
	}
}
