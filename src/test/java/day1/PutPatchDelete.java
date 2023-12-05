package day1;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;

public class PutPatchDelete {
	 
	//@Test
	void put() {
		 
		JSONObject request = new JSONObject();
		request.put("name", "Karteek");
		request.put("job","Automation Engineer");
		
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application").
			contentType(ContentType.JSON).	
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			put("/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
//	@Test
	void patch() {
		 
		JSONObject request = new JSONObject();
		request.put("name", "Karteek");
		request.put("job","Automation Engineer");
		
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type","application").
			contentType(ContentType.JSON).	
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	void delete() {
		 
		
		
		baseURI = "https://reqres.in";
		
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204)
			.log().all();
	}

}
