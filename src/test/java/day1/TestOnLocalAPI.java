package day1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class TestOnLocalAPI {
	
//	@Test
	public void testget() {
		baseURI="http://localhost:3000";
		given().get("/users").then().statusCode(200);
	}
//	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstName","Thmoas");
		request.put("lastName","Edison");
		request.put("subjectId",1);
		
		baseURI= "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
	}
	
//	@Test
	public void put() {
		JSONObject request = new JSONObject();
		request.put("firstName","Albert");
		request.put("lastName","Instein");
		request.put("subjectId",2);
		
		baseURI= "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toString())
		.when()
			.put("/users/3")
		.then()
			.statusCode(200);
	}
	
//	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("lastName","John");
		baseURI= "http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toString())
		.when()
			.patch("/users/3")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void delete() {
		baseURI ="http://localhost:3000";
		given().delete("users/3").then().statusCode(200);
	}
	
}
