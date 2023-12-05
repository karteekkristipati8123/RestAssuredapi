package day1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;
public class GetAndPostExmples {

//	@Test
	void getTest() {
		baseURI="https://reqres.in/api";
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name",equalTo("George"));
	
	}
	
	@Test
	void testPost() {
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("name", "Karthik");
		map.put("Job","Sr.Automation Engineer");
		
		System.out.println(map);
		JSONObject request= new JSONObject(map);
		System.out.println(request.toString());
		
		baseURI ="https://reqres.in/api";
		
		given().
			body(request.toString()).
		when().
			post("/users").
		then().
			statusCode(201).
		log().all();
		
	}
}
