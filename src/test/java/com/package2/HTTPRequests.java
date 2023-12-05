package com.package2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HTTPRequests {
	
	int id;
	@Test(priority=1)
	void getUsers() {
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test(priority=2)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Karthik");
		data.put("job", "Automtion Engineer");
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users").jsonPath().getInt("Id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test(priority=3,dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Karthik");
		data.put("job", "Automtion Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users"+id)
			 
		.then()
			.statusCode(200)
			.log().all();
	}
	  	
	@Test(priority=4)
	void deleteUser() {
	  		given()
	  			
	  		.when()
	  			.delete("https://reqres.in/api/users\"+id")
	  		.then()
	  			.statusCode(204)
	  			.log().all();
	  	}
}
